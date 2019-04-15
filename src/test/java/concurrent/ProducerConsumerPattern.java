package concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liufeixiang on 2019/3/29.
 */

public class ProducerConsumerPattern{
    public static final int MAX_CAP = 2;
    static LinkedList<Object> list = new LinkedList<>();
    static ReentrantLock lock = new ReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();

    static class Producer implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while(list.size() == MAX_CAP) {
                        try {
                            System.out.println("当前已有"+list.size()+"个产品，缓冲区已满，请等待消费者消费");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(new Object());
                    System.out.println(Thread.currentThread().getName() + "生产了一个产品，当前产品个数为 " + list.size());
                    notEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
//                Thread.yield();
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    lock.lock();
                    while(list.size() == 0) {
                        try {
                            System.out.println("当前已有"+list.size()+"个产品，缓冲区已空，请等待生产者生产");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "消费了一个产品，当前产品个数为 " + list.size());
                    notFull.signalAll();
                } finally {
                    lock.unlock();
                }
//                Thread.yield();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<3; i++) {
            new Thread(new Producer()).start();
        }
        for(int i=0; i<3; i++) {
            new Thread(new Consumer()).start();
        }
    }
}
