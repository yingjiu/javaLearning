/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.Thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wb-lcw229616
 * @version $Id: CountDownLatchTest.java, v 0.1 2018年05月30日 17:57 wb-lcw229616 Exp $
 */
public class CountDownLatchTest {
    static       int            threadCount = 3;
    static final CountDownLatch latch       = new CountDownLatch(threadCount);

    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService executor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        executor.submit(new Thread(new MyRunner(latch, "1号选手")));
        executor.submit(new Thread(new MyRunner(latch, "2号选手")));
        executor.submit(new Thread(new MyRunner(latch, "3号选手")));

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程已经执行完毕！开始计算排名");

        executor.shutdown();
    }
}

class MyRunner implements Runnable {
    // 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)
    private CountDownLatch latch;

    private String name;

    public MyRunner(CountDownLatch latch, String name) {
        super();
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程" + Thread.currentThread().getId() + "开始出发");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
