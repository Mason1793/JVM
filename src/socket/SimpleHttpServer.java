package socket;

import thread.DefaultThreadPool;
import thread.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author zz
 * @Date
 **/
public class SimpleHttpServer {
     ThreadPool<HttpRequestHandler> threadPool ;
//     String basePath = "";
     ServerSocket serverSocket;
     int port=8090;

    public static void main(String[] args) throws Exception{
        new SimpleHttpServer().start();
    }

    public SimpleHttpServer(){
        threadPool=new DefaultThreadPool(1);
        try {
            serverSocket = new ServerSocket(port);
        }catch (IOException e){

        }

    }

    public  void start() throws Exception{
        Socket socket;
//        while ((socket = serverSocket.accept())!=null){
//            new Thread(new HttpRequestHandler(socket)).start();
//        }
        while ((socket = serverSocket.accept())!=null){
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }
     class HttpRequestHandler implements Runnable{
        private Socket socket;
        public HttpRequestHandler(Socket socket){
            this.socket=socket;
        }
        @Override
        public void run() {
            String line=null;
            BufferedReader br=null;
            BufferedReader reader=null;
            PrintWriter out=null;
            InputStream in=null;
            try {
                reader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header=reader.readLine();
//                String filePath=basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                out.println("HTTP/1.1 200 OK");
                out.println("Content-type:text/html");
                out.println();
                out.println("<h1>successful</h1>");
//                if(filePath .endsWith("jpg") || filePath.endsWith("ico")){
//                    in = new FileInputStream(filePath);
//                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
//                    int i;
//                    while ((i = in.read())!=-1){
//                        baos.write(i);
//                    }
//                    byte[] array=baos.toByteArray();
//                    out.println("HTTP/1.1 200 OK");
//                    out.println("Server: Molly");
//                    out.println("Content-Type: image/jpeg");
//                    out.println("Content-Length:" +array.length);
//                    out.println("");
//                    socket.getOutputStream().write(array,0,array.length);
//                }else {
//                    br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//                    out=new PrintWriter(socket.getOutputStream());
//                    out.println("HTTP/1.1 200 OK");
//                    out.println("Server:Molly");
//                    out.println("Content-Type:text/html;charset=UTF-8");
//                    out.println();
//                    while ((line=br.readLine())!=null){
//                        out.println(line);
//                    }
//                }
                out.flush();
            }catch (Exception e){
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            }finally {
                close(br,in ,reader,out,socket);
            }
        }
    }
    private  void close(Closeable...closeables){
        if(closeables!=null){
            for (Closeable closeable :closeables){
                try {
                    closeable.close();
                }catch (Exception e){

                }
            }
        }
    }
}
