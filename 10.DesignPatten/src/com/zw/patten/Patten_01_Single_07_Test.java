package com.zw.patten;

import java.util.concurrent.CountDownLatch;

/**
 * @program: JavaBasic
 * @description: 测试各种实现方式的效率
 * 饿汉式->耗时：84
 * 懒汉式->耗时：15483
 * 双重检测加锁式->耗时：164
 * 静态内部类式->耗时：48
 * 枚举式->耗时：43
 * @author: zw-cn
 * @create: 2020-02-28 09:09
 */
public class Patten_01_Single_07_Test {
    public static void main(String[] args) {
        final int THREAD_TIMES = 10000*10000;
        final int THREAD_NUM = 10;
        CountDownLatch count1 = new CountDownLatch(THREAD_NUM);
        final CountDownLatch count2 = new CountDownLatch(THREAD_NUM);
        final CountDownLatch count3 = new CountDownLatch(THREAD_NUM);
        final CountDownLatch count4 = new CountDownLatch(THREAD_NUM);
        final CountDownLatch count5 = new CountDownLatch(THREAD_NUM);
        Runnable s1 = ()->{
            for (int i = 0; i < THREAD_TIMES; i++) {
                Patten_01_Single_01_Hungry o = Patten_01_Single_01_Hungry.getInstance();
            }
            count1.countDown();
        };
        Runnable s2 = ()->{
            for (int i = 0; i < THREAD_TIMES; i++) {
                Patten_01_Single_02_Full o = Patten_01_Single_02_Full.getInstance();
            }
            count2.countDown();
        };
        Runnable s3 = ()->{
            for (int i = 0; i < THREAD_TIMES; i++) {
                Patten_01_Single_03_DoubleCheck o = Patten_01_Single_03_DoubleCheck.getInstance();
            }
            count3.countDown();
        };
        Runnable s4 = ()->{
            for (int i = 0; i < THREAD_TIMES; i++) {
                Patten_01_Single_04_StaticInnerClass o = Patten_01_Single_04_StaticInnerClass.getInstance();
            }
            count4.countDown();
        };
        Runnable s5 = ()->{
            for (int i = 0; i < THREAD_TIMES; i++) {
                Patten_01_Single_05_Enum o = Patten_01_Single_05_Enum.INSTANCE;
            }
            count5.countDown();
        };

        try {
            test("饿汉式",s1,THREAD_NUM,count1);
            test("懒汉式",s2,THREAD_NUM,count2);
            test("双重检测加锁式",s3,THREAD_NUM,count3);
            test("静态内部类式",s4,THREAD_NUM,count4);
            test("枚举式",s5,THREAD_NUM,count5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void test(String name,Runnable run,int threadNum,CountDownLatch count) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(run).start();
        }
        count.await();
        long end = System.currentTimeMillis();
        System.out.println(name+"->耗时："+(end-start));
    }
}
