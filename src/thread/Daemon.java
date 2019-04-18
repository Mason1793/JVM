package thread;

/**
 * @Author zz
 * @Date
 **/
public class Daemon {
    public static void main(String[] args) {
        ThreadDemo threaddemo = new ThreadDemo();
        Thread threadson = new Thread(threaddemo);
        //设置守护线程
        threadson.setDaemon(false);
        //启动线程
        threadson.start();
        System.out.println("bbb");
    }
}
class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("aaa");
        while(true);//无限循环
    }

}
