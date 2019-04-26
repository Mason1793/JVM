package cn.mason.code.HotSwap;

/**
 * @Author zz
 * @Date
 **/
public class HotSwapClassLoader extends ClassLoader{
    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
