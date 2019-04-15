package lock;

import com.lfx.business.passport.service.UserService;
import com.lfx.business.passport.service.VoucherService;
import com.lfx.business.passport.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liufeixiang on 2019/3/30.
 */
@Slf4j
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RedisLockTest {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private UserService userService;

    final int THREAD_COUNT = 20;
    final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
    final CountDownLatch endFlag = new CountDownLatch(THREAD_COUNT);
    @Test
    public void test() {
        redisUtil.delete("total_account");
        redisUtil.incrBy("total_account",2);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i=0;i<THREAD_COUNT;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "准备就绪");
                        countDownLatch.await();
                        voucherService.getVoucherRecord();
                        endFlag.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            countDownLatch.countDown();
        }
        try {
            endFlag.await();
            executor.shutdown();
            System.out.println("所有线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
