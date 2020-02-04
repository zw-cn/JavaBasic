package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: 指令重排：(不理解)
 * 1.程序执行原理 a.取指令b.解码指令并取值c.运算d.回写
 * 2.JVM和CPU会将寄存器无依赖的指令进行重新排列，以提高效率，但在多线程中可能导致结果出人意料
 * @author: zw-cn
 * @create: 2020-02-04 12:43
 *
 * 某次的运行结果：
    ------------------------
    thread1
    thread2
    happen before a ->1
    //已经发生指令重排：正常运行时，[A1]先执行[A2]不会执行；
    a==0才会打印，但是a的值是1：原因是还未回写
    ------------------------
 */
public class Test_07_HappenBefore {
    public static int a = 0;
    public static boolean flag = false;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            a = 0;
            flag = false;

            //线程1 ：写数据
            Thread t1 = new Thread(() -> {
                System.out.println("thread1");
                a = 1;
                flag = true;
            });
            //线程2 ： 读数据
            Thread t2 = new Thread(() -> {
                System.out.println("thread2");
                //[A1]
                if (flag) {
                    a *= 2;
                }
                //[A2]
                if (a == 0) {
                    System.out.println("happen before a ->" + a);
                }
            });
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------------");
        }

    }
}
