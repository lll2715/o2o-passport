package com.lfx.business.passport.service.impl;

import com.lfx.business.passport.dao.VoucherMapper;
import com.lfx.business.passport.domain.entity.Voucher;
import com.lfx.business.passport.lock.RedisLock;
import com.lfx.business.passport.response.BaseResult;
import com.lfx.business.passport.service.VoucherService;
import com.lfx.business.passport.util.RedisDistributedLock;
import com.lfx.business.passport.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liufeixiang on 2019/3/30.
 */
@Service
@Slf4j
public class VoucherServiceImpl implements VoucherService {

    private final Long LOCK_EXPIRE_TIME = 1000 * 120L;

    private final short VOUCHER_HAVE_BEAN_USED = 1;

    private final String VOUCHER_REDIS_LOCK_KEY = "voucher_redis_lock";

    private final Integer RETRY_TIMES = 50;

    @Autowired
    private VoucherMapper voucherMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Resource
    private RedisDistributedLock redisDistributedLock;

    @Resource
    private RedisLock redisLock;

    @Override
    public Voucher receiveVoucher() {
        String key = "voucher";
        Voucher voucher = null;
        int count = (int)redisUtil.get("total_account");
        if(count <= 0){
            System.out.println(Thread.currentThread().getName() + "券已领完...");
        }
        if (redisDistributedLock.setLock(key,LOCK_EXPIRE_TIME)){
            System.out.println(Thread.currentThread().getName() + "抢锁成功...");
            try {
                voucher = voucherMapper.selectOneEffectiveRecord();
                if(voucher == null){
                    System.out.println("券已领完...");
                    return null;
                }
                voucherMapper.updateStatusIsUsed(voucher.getId());
                log.info(Thread.currentThread().getName() + ":【" + voucher.getTicketId() + "】");
                redisUtil.decr("total_account",1L);
            } finally {
                redisDistributedLock.releaseLock(key);
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "抢锁失败...");
        };
        return voucher;
    }

    @Override
    public BaseResult getVoucherRecord() {
        BaseResult result = new BaseResult();
        int count = (int)redisUtil.get("total_account");
        if(count <= 0){
            System.out.println(Thread.currentThread().getName() + "券已领完...");
        }
        if (redisLock.lock(VOUCHER_REDIS_LOCK_KEY , LOCK_EXPIRE_TIME , RETRY_TIMES)){
            System.out.println(Thread.currentThread().getName() + "抢锁成功...");
            Voucher voucher = voucherMapper.selectOneEffectiveRecord();
            if(voucher == null){
                System.out.println("券已领完...");
                redisLock.releaseLock(VOUCHER_REDIS_LOCK_KEY);
                return result;
            }
            voucherMapper.updateStatusIsUsed(voucher.getId());
            log.info(Thread.currentThread().getName() + ":【" + voucher.getTicketId() + "】");
            redisUtil.decr("total_account",1L);
            redisLock.releaseLock(VOUCHER_REDIS_LOCK_KEY);
        }else {
            System.out.println("活动火爆，请稍后重试...");
        }
        return result;
    }
}
