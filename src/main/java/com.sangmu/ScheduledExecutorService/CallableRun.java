package com.sangmu.ScheduledExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableRun {
    public static void main(String[] args) {
        try {
            List<Callable> callableList = new ArrayList<Callable>();
            callableList.add(new MyCallableA());
            callableList.add(new MyCallableB());
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture futureA = executorService.schedule(callableList.get(0), 4L, TimeUnit.SECONDS);
            ScheduledFuture futureB = executorService.schedule(callableList.get(1), 4L, TimeUnit.SECONDS);

            System.out.println("            X = " + System.currentTimeMillis());
            System.out.println("返回值A：" + futureA.get());
            System.out.println("返回值B：" + futureB.get());
            System.out.println("            Y = " + System.currentTimeMillis());

            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyCallableA implements Callable<String> {
        public String call() throws Exception {
            try {
                System.out.println("callA begin " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3); // 休眠3秒
                System.out.println("callA end " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "returnA";
        }
    }

    static class MyCallableB implements Callable<String> {
        public String call() throws Exception {
            System.out.println("callB begin " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
            System.out.println("callB end " + Thread.currentThread().getName() + ", " + System.currentTimeMillis());
            return "returnB";
        }
    }
}
