package cn.mason.code.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author zz
 * @Date
 **/
@Aspect
public class AspectJTest {
    @Pointcut("execution(* cn.mason.code.spring..*.test(..))")
    public void test(){

    }
    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o = null;
        try {
            o=p.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
