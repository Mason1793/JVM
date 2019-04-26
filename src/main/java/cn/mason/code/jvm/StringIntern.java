package cn.mason.code.jvm;

/**
 * @Author zz
 * @Date
 **/
public class StringIntern {
    String s="1";

    public static void main(String[] args){
        String s2="1";
        String s1=new String("1");
        s1.intern();
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1") ;
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
