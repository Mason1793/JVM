package cn.mason.code.thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author zz
 * @Date
 **/
public class ConnectionDriver {
    static class ConnectinHandler implements InvocationHandler{
       
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
            if(method.getName().equals("commit")){
                TimeUnit.MICROSECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class<?>[]{Connection.class},new ConnectinHandler());
    }
}
