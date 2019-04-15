package jdk8;

/**
 * Created by liufeixiang on 2019/3/27.
 */
public class LambdaTest {

    public static void main( String[] args )
    {
        //java7 传统写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("This is a thread(%s) via java7...",Thread.currentThread().getId()));
            }
        }).start();

        //java8 Lambda写法
//        new Thread(() -> System.out.println(String.format("This is a thread(%s) via java8...",Thread.currentThread().getId()))).start();
    }
}
