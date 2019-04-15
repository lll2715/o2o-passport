package concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liufeixiang on 2019/3/29.
 */
public class QueueTest {

    public static LinkedList<Object> queue = new LinkedList<>();
    static ReentrantLock lock = new ReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();
    static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            new Thread(new Provider()).start();
        }
        for (int j=0;j<3;j++){
            new Thread(new Consumer()).start();
        }
    }

    static class Provider implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    while (queue.size() == MAX_SIZE){
                        System.out.println("队列已满，已停止入队");
                        notFull.await();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.add(new Object());
                    System.out.println(Thread.currentThread().getName() + "生产了一个，当前大小为" + queue.size());
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("unlock");
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    while (queue.size() == 0){
                        System.out.println("队列空了，请抓紧往里加");
                        notEmpty.await();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.remove();
                    System.out.println(Thread.currentThread().getName() + "消费了一个，当前大小为" + queue.size());
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
