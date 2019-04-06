import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author zz
 * @Date
 **/
public class JavaP {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable{
        System.out.println("hot swap");
//        Object object=System.currentTimeMillis()%2 == 0?System.out:new ClassA();
//
//        getPrintlnMH(object).invoke("icyfenix");
    }
    static class DynamicProxy implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable{
        MethodType mt=MethodType.methodType(void.class,String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }

    private static final String s1="123";
    private static  String s2="456";
    private int m;
    public int inc(){
        return m+1;
    }

}
