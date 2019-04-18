package nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author zz
 * @Date
 **/
public class TimeServer {
    public static void main(String[] args) throws IOException{
        int port=8090;
        if(args!=null && args.length>0){
           port=Integer.valueOf(args[0]);
        }

        MultipleexerTimeServer timeServer = new MultipleexerTimeServer(port);
        new Thread(timeServer,"NIO-MultipleexerTimeServer-001").start();
//        ServerSocket serverSocket=null;
//        try {
//            serverSocket=new ServerSocket(port);
//            System.out.println("the time server is start int port:"+port);
//            Socket socket=null;
//            TimeServerHandlerExecutePool singleExecutor=new TimeServerHandlerExecutePool(50,10000);
//            while (true){
//                socket=serverSocket.accept();
//                singleExecutor.execute(new TimeServerHandler(socket));
//            }
//        }finally {
//            if(serverSocket != null){
//                System.out.println("the time server close");
//                serverSocket.close();
//                serverSocket=null;
//            }
//        }
    }
}
