package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: Inheritable可继承的ThreadLocal
 * @author: zw-cn
 * @create: 2020-02-05 17:35
 */
public class Test_07_ThreadLocal_03 {
    private static ThreadLocal<Integer> threadLocal = InheritableThreadLocal.withInitial(()->0);
    static class subThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
            threadLocal.set(25);
            System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
        }
    }

    public static void main(String[] args) {
        threadLocal.set(50);
        System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
        new Thread(new subThread()).start();//可继承的ThreadLocal是通过数值的拷贝，并不会影响原有数据

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
    }
}
