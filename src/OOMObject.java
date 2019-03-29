import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zz
 * @Date
 **/
public class OOMObject {
    static class OOMObject1{
        public  byte[] placeholder=new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject1> list=new ArrayList<OOMObject1>();

        for (int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject1());
        }

    }

    public static void main(String[] args)throws Exception{
        fillHeap(1000);
        System.gc();
    }
}
