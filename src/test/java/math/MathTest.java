package math;

import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liufeixiang on 2019/4/4.
 */
public class MathTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1 / 4);
        System.out.println(1F / 4 * 4);
        Hashtable numbers = new Hashtable();
        numbers.put(null,"123");

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();
        condition.await(1, TimeUnit.SECONDS);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();

    }
}
