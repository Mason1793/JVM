package HotSwap;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Mason
 * @date 2019/4/5
 */
public class Main {
    public static void main(String[] args) throws Throwable{
        InputStream is=new FileInputStream("/Users/mason/IdeaProjects/JVM/out/production/Algorithms/HotSwap/Sysout.class");
        byte[] b=new byte[is.available()];
        is.read(b);
        is.close();

        System.out.println(JavaClassExecuter.execute(b).toString());
    }
}
