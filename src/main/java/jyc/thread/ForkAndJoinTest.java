package jyc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //新建计算任务
        CountTask task = new CountTask(1,4);
        //执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }
}


class CountTask extends RecursiveTask<Integer>{

    private static final long serialVersionUID = 3140051720766582966L;

    //执行多任务的阈值
    private static final int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for(int i = start; i <= end; i++){
                sum += i;
            }
        } else{
            //如果大于阈值，分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完毕，得到返回结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
