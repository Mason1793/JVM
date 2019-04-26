package cn.mason.code.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author zz
 * @Date
 **/
public class CyclicBarrierTest {
    static CyclicBarrier c=new CyclicBarrier(1,new A());
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                }catch (Exception e){

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        }catch (Exception e){

        }
        System.out.println(2);
    }
    static class A implements Runnable{
        public void run(){
            System.out.println(3);
        }
    }
}
