package com.lfx.business.passport.service.impl;

import com.google.common.base.Optional;
import com.lfx.business.passport.domain.Account;
import com.lfx.business.passport.domain.CacheContext;
import com.lfx.business.passport.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liufeixiang on 2019/3/20.
 */
@Slf4j
@Service
public class AccountServiceImpl2 implements AccountService {

    @Resource
    private CacheContext<Account> accountCacheContext;

//    @Cacheable(value = "accountCache" ,keyGenerator ="springCacheKeyGenerator")
    @Cacheable(value = "accountCache" ,key = "#accountName")
    public Account getAccountByName(String accountName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        log.info("real querying account... {}", accountName);
        Optional<Account> accountOptional = getFromDB(accountName);
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }
//        return accountOptional.get();
        return null;
    }

    @CacheEvict(value="accountCache", allEntries=true)
    public void reload() {
        log.info("delete all keys");
    }

    private Optional<Account> getFromDB(String accountName) {
        log.info("real querying db... {}", accountName);
        //Todo query data from database
        return Optional.fromNullable(new Account(accountName));
    }
}
