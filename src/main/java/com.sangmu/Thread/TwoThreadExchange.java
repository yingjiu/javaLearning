package com.sangmu.Thread;

public class TwoThreadExchange {
    public static void main(String[] args) {
         Num num = new Num();
         One one = new One(num);
         Two two = new Two(num);
         Thread oneT = new Thread(one);
         Thread twoT = new Thread(two);
         oneT.start();
         twoT.start();
    }

    //要打印的资源
    public static  class Num {
        int i=1;
        boolean flag = false; //两个线程，交替执行的一个标志
    }
    public static class One implements Runnable{
        public Num num;

        public One(Num num){
            this.num = num;
        }
        @Override
        public void run() {
            while (num.i < 100) {
                synchronized (num) {
                    if (num.flag) {
                        try {
                            num.wait();
                        } catch (Exception e) {
                        }
                    } else {
                        System.out.println("奇数" + num.i);
                        num.i++;
                        num.flag = true;
                        num.notify();
                    }
                }
            }
        }


    }
    public static class Two implements Runnable{
        public Num num;

        public Two(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num.i < 100) {
                synchronized (num) {
                    if (!num.flag) {
                        try {
                            num.wait();
                        } catch (Exception e) {

                        }


                    } else {
                        System.out.println("偶数" + num.i);
                        num.i++;
                        num.flag = false;
                        num.notify();
                    }
                }
            }
        }
    }
}
