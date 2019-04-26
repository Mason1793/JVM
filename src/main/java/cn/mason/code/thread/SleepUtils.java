package cn.mason.code.thread;;

import java.util.concurrent.TimeUnit;

/**
 * @Author zz
 * @Date
 **/
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){

        }
    }
}
