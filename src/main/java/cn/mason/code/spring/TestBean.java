package cn.mason.code.spring;

import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zz
 * @Date
 **/
public class TestBean {
    public static void main(String[] args){
        ApplicationContext bf=new ClassPathXmlApplicationContext("aspectTest.xml");
        TestBean bean=(TestBean)bf.getBean("test");
        bean.test();


    }
    private String str="testStr";

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void test(){
        System.out.println("test");
    }
}
