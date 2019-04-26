package cn.mason.code.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author zz
 * @Date
 **/
public class CountTask extends RecursiveTask<Integer>{
    private final int THRESHOLD=2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute = (end - start)<=THRESHOLD;
        if(canCompute){
            for(int i=start; i<=end;i++){
                sum+=i;
            }
        }else {
            int middle = (end + start)/2;
            CountTask left=new CountTask(start,middle);
            CountTask right=new CountTask(middle + 1,end);
            left.fork();
            right.fork();

            int leftResult=left.join();
            int rightResult=right.join();

            sum=leftResult + rightResult;

        }
        return sum;
    }

    public static void main(String[] args){
        ForkJoinPool pool=new ForkJoinPool();

        CountTask countTask=new CountTask(1,10);
        Future<Integer> result = pool.submit(countTask);
        try {
            System.out.println(result.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
