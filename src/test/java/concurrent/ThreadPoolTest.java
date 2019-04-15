package concurrent;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by liufeixiang on 2019/3/31.
 */
public class ThreadPoolTest {

        private static class Task implements Runnable {
            private int taskId;

            Task(int taskId) {
                this.taskId = taskId;
            }

            @Override public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ignore) {
                }
                System.out.println("task " + taskId + " end");
            }
        }

    private static class Task1 implements Callable {
        private int taskId;

        Task1(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public String  call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return "result of taskWithResult "+ taskId;
        }
    }

        public static void main(String[] args) {
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(2) {
                        @Override public boolean offer(Runnable runnable) {
                            try {
                                super.put(runnable); // 使用阻塞的put重写offer方法
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return true;
                        }
                    });
            Future future = threadPool.submit(new Task(1));
            System.out.println("task 1 submitted" + JSON.toJSONString(future));
            threadPool.submit(new Task(2));
            System.out.println("task 2 submitted");
            threadPool.submit(new Task(3));
            System.out.println("task 3 submitted");
            threadPool.submit(new Task(4));
            System.out.println("task 4 submitted");
            threadPool.submit(new Task(5));
            System.out.println("task 5 submitted");
            threadPool.submit(new Task(6));
            System.out.println("task 6 submitted");
            threadPool.shutdown();
        }

    private static class BlockCallerPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void rejectTest(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), new BlockCallerPolicy());
        Future future = threadPool.submit(new Task1(1));
        System.out.println("task 1 submitted" + JSON.toJSONString(future));
        threadPool.submit(new Task1(2));
        System.out.println("task 2 submitted");
        threadPool.submit(new Task(3));
        System.out.println("task 3 submitted");
        threadPool.submit(new Task(4));
        System.out.println("task 4 submitted");
        threadPool.submit(new Task(5));
        System.out.println("task 5 submitted");
        threadPool.submit(new Task(6));
        System.out.println("task 6 submitted");
        threadPool.shutdown();
        try {
         System.out.println("task 1 submitted" + JSON.toJSONString(future.get()));
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
