package cn.mason.code.HotSwap;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @Author zz
 * @Date
 **/
public class HackSystem {
    public final static InputStream in=System.in;
    private static ByteArrayOutputStream buffer=new ByteArrayOutputStream();
    public final static PrintStream out=new PrintStream(buffer);

    public final static PrintStream err=out;

    public static String getBufferString(){
        return buffer.toString();
    }

    public static void classBuffer(){
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager s){
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager(){
        return System.getSecurityManager();
    }

    public static long currentTimeMillis(){
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src,int srcPos,Object dest,int desPos,int length){
        System.arraycopy(src,srcPos,dest,desPos,length);
    }
    public static int identityHashCode(Object x){
        return System.identityHashCode(x);
    }

}
