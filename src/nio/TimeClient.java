package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author zz
 * @Date
 **/
public class TimeClient {
    public static void main(String[] args){
        new Thread(new TimeClientHandle("127.0.0.1",8090),"TimeClient-001").start();
//        int port=8090;
//        if(args != null && args.length>0){
//            port = Integer.valueOf(args[0]);
//        }
//
//        Socket socket=null;
//        BufferedReader in=null;
//        PrintWriter out=null;
//        try {
//            socket = new Socket("127.0.0.1",port);
//            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out=new PrintWriter(socket.getOutputStream(),true);
//            out.println("QUERY TIME ORDER");
//            System.out.println("Send order 2 server succeed.");
//            String resp=in.readLine();
//            System.out.println("Now is: "+resp);
//        }catch (Exception e){
//
//        }finally {
//            if(out != null){
//                out.close();
//                out=null;
//            }
//
//            if(in != null){
//                try {
//                    in.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//                in=null;
//
//            }
//            if(socket !=null){
//                try {
//                    socket.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//                socket=null;
//            }
//        }
    }
}
