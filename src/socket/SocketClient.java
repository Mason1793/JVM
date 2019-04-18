package socket;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author zz
 * @Date
 **/
public class SocketClient implements Runnable{
    public static void main(String[] args) throws IOException{
        SocketClient client=new SocketClient();
        Thread t1=new Thread(client,"thread -1");
        t1.start();

        Thread t2=new Thread(client,"thread -2");
        t2.start();
    }

    @Override
    public void run() {
        int i=10;
        try {
            Socket socket = new Socket("127.0.0.1", 8090);
            while (i!=0){
                OutputStream outputStream=socket.getOutputStream();
                outputStream.write(("this is  "+Thread.currentThread().getName()+":"+i).getBytes());
                i--;
            }
        }catch (IOException e){

        }

    }
}
