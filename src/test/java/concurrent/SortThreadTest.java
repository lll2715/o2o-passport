package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liufeixiang on 2019/3/29.
 */
public class SortThreadTest {
    public static CountDownLatch c1 = new CountDownLatch(1);
    public static CountDownLatch c2 = new CountDownLatch(1);

    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
                c1.countDown();
            }
        });
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("lalala");
                c2.countDown();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("xixixi");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
