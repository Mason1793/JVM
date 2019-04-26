package cn.mason.code.HotSwap;

import java.lang.reflect.Method;

/**
 * @author Mason
 * @date 2019/4/5
 */
public class JavaClassExecuter {
    public static String execute(byte[] classByte){
        HackSystem.classBuffer();
        ClassModifier cm=new ClassModifier(classByte);
        byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System","HotSwap/HackSystem");
        HotSwapClassLoader loader=new HotSwapClassLoader();
        Class clazz=loader.loadByte(modiBytes);
        try {
            Method method =clazz.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        }catch (Throwable e){
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
