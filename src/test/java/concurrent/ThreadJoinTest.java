package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liufeixiang on 2019/3/29.
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
            }
        });
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("lalala");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
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
