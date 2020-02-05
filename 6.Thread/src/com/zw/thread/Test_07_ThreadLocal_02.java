package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: Thread Local 的上下文
 * @author: zw-cn
 * @create: 2020-02-05 17:06
 */
public class Test_07_ThreadLocal_02 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);
    static class subThread implements Runnable{
        public subThread() {//由于是从main线程调用subThread的构造器，因此，此时的threadLocal属于main线程
            System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
        }

        @Override
        public void run() {//run方法是subThread实例线程调用的方法，因此，此时的threadLocal属于run线程
            System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
        }
    }

    public static void main(String[] args) {
        threadLocal.set(50);
        System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
        new Thread(new subThread()).start();
    }
}
