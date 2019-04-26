package cn.mason.code.thread;;

import javax.security.auth.callback.Callback;
import java.util.concurrent.*;

/**
 * @Author zz
 * @Date
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgr=new Exchanger<String>();
    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);
    public static void main(String[] args){

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A="银行流水A";
                    exgr.exchange(A);
                }catch (InterruptedException e){

                }
            }
        });
        threadPool.execute(()->{
            try {
                String B="银行流水B";
                String A=exgr.exchange(B);
                System.out.println("  :"+A.equals(B)+",A录入了：" +A+",B录入了："+B);
            }catch (InterruptedException e){

            }
        });
        threadPool.shutdown();
    }
}
