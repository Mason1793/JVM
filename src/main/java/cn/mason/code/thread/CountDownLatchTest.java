package cn.mason.code.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author zz
 * @Date
 **/
public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);
    public static void main(String[] args)throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
//                try {
//                    SleepUtils.second(5);
//                }catch (Exception e){
//
//                }
                System.out.println(2);
                c.countDown();


            }
        }).start();
        c.await(3, TimeUnit.SECONDS);

        System.out.println(3);
    }

}
