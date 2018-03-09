package com.sangmu.Future;

import java.util.concurrent.*;

public class J5Thread {
    public static void main(String[] args) {
        // ES
        System.out.println("Get request from TC, thread id="+Thread.currentThread().getId());
        ExecutorService ES= Executors.newCachedThreadPool();

        //task
        Callable<Integer> rmTask= new RMTask();
        Callable<Integer> cupdTask = new CUPDTask();

        //ES submit task,
        //param is callable
        //return result
        Future<Integer> rmResult=ES.submit(rmTask);
        Future<Integer> cupdResult= ES.submit(cupdTask);
        ES.shutdown();

        System.out.println("ES shutdown, thread id="+Thread.currentThread().getId());
        //ES shutdown

        try {
            Integer result = rmResult.get();
            System.out.println("process rmResult, thread id="+Thread.currentThread().getId());
            System.out.println("process rmResult="+result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}