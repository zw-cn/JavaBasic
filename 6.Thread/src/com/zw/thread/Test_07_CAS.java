package com.zw.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: JavaBasic
 * @description: CAS原子操作-乐观锁
 * @author: zw-cn
 * @create: 2020-02-07 13:02
 */
public class Test_07_CAS {
    private static AtomicInteger last = new AtomicInteger(4);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = last.decrementAndGet();
                if (left < 0) {
                    System.out.println("nothing left");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "get-->" + (left+1));
            }).start();
        }
    }

}
