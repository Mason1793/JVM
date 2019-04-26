package cn.mason.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zz
 * @Date
 **/
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());

        }
    }
}
