package cn.mason.code.thread;




import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author zz
 * @Date
 **/
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{
    private static final int MAX_WORKERS_NUMBERS = 10;
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private static final int MIN_WORKER_NUMBERS=1;

    private final LinkedList<Job> jobs=new LinkedList<Job>();
    private final List<Worker> workers= Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_NUMBERS;

    private AtomicLong threadNum=new AtomicLong();


    public DefaultThreadPool(int num){
        workerNum = num>MAX_WORKERS_NUMBERS?MAX_WORKERS_NUMBERS:num<MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS:num;
        initializedWorkers(num);
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker: workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if(num +this.workerNum > MAX_WORKERS_NUMBERS){
                num = MAX_WORKERS_NUMBERS- this.workerNum;
            }
            initializedWorkers(num);
            this.workerNum +=num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                throw  new IllegalArgumentException("beyond workNum");
            }
            int count=0;
            while (count < num){
                Worker worker=workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -=count;
        }

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializedWorkers(int num){
        for(int i=0 ; i<num ;i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread=new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }
    class Worker implements Runnable{
        private volatile boolean running =true;
        public void run(){
            while (running){
                Job job=null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        }catch (InterruptedException ex){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null){
                    try {
                        job.run();
                    }catch (Exception ex){

                    }
                }
            }
        }

        public void shutdown(){
            running=false;
        }
    }
}
