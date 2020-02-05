package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: ThreadLocal的基本使用
 * @author: zw-cn
 * @create: 2020-02-05 14:48
 */
public class Test_07_ThreadLocal_01 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    //initialValue 赋初值
    private static ThreadLocal<Integer> threadLocalWithInit = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 30;
        }
    };
    //lambda 赋初值
    private static ThreadLocal<Integer> threadLocalWithInit2 = ThreadLocal.withInitial(()->550);

    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName()+"-->"+ threadLocal.get());
        System.out.println(Thread.currentThread().getName()+"-->"+ threadLocalWithInit.get());
        System.out.println(Thread.currentThread().getName()+"-->"+ threadLocalWithInit2.get());
        //修改值
        threadLocal.set(66);
        System.out.println(Thread.currentThread().getName()+"-->"+ threadLocal.get());
        //验证线程独有
        new Thread(new subThread()).start();
    }
    /**
     * @description: 静态内部类，验证ThreadLocal为各线程独有
     * @author: zw-cn
     * @create: 2020/2/5 17:01
     */
    static class subThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"-->"+ threadLocal.get());
        }
    }
}
