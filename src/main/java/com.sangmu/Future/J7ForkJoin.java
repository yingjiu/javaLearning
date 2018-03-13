package com.sangmu.Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class J7ForkJoin extends RecursiveTask<Integer> {
    private static final int THRESHOLD=5;
    private int beginning;
    private int ending;

    public J7ForkJoin(int beginning, int ending) {
        super();
        this.beginning = beginning;
        this.ending = ending;
    }

    //override compute
    @Override
    protected Integer compute() {
        // TODO Auto-generated method stub
        //check if still need fork
        int sum=0;
        boolean canCompute = (ending-beginning)<=THRESHOLD;
        if(canCompute){
            //no need
            System.out.println("no need fork, ThreadID="+Thread.currentThread().getId());
            System.out.println("no need fork, beginning="+this.beginning);
            System.out.println("no need fork, ending="+this.ending);
            for(int i=beginning; i<=ending;++i){
                sum+=i;
            }
            return sum;
        }else{
            //need
            int interim=(this.ending+this.beginning)/2;
            //5+1 /2 =3 1-3
            //6+1 /2 =3 1-3
            System.out.println("need fork, ThreadID="+Thread.currentThread().getId());
            System.out.println("need fork, interim="+interim);
            J7ForkJoin leftTask=new J7ForkJoin(this.beginning , interim);
            J7ForkJoin rightTask=new J7ForkJoin(interim+1, this.ending);
            //.fork
            leftTask.fork();
            rightTask.fork();

            //get reuslt
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum =leftResult+rightResult;
            return sum;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ForkJoinPool FJPool=new ForkJoinPool();
        J7ForkJoin task=new J7ForkJoin(1, 20);
        Future<Integer> result=FJPool.submit(task);
        try {
            System.out.println("main result="+result.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
