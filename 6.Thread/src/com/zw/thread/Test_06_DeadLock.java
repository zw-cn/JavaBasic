package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: 线程死锁的例子
 * @author: zw-cn
 * @create: 2020-02-03 13:36
 */

public class Test_06_DeadLock {
    public static void main(String[] args) {
        System.out.println("start...");
        MakeUp m1 = new MakeUp("Li", 1);
        MakeUp m2 = new MakeUp("Wang", 2);
        m1.start();
        m2.start();
    }

}

class MakeUp extends Thread {
    static Mirror mirror = new Mirror();
    static Lipstick lipstick = new Lipstick();
    String name;
    int flag;

    public MakeUp(String name, int flag) {
        this.name = name;
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag % 2 == 0) {
            synchronized (mirror) {
                System.out.println(this.name+"get the mirror");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name+"start to search for the lipstick!");
                synchronized (lipstick) {
                    System.out.println(this.name+"get the lipstick!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.name+"finish the make up");
                }
            }
        } else {
            synchronized (lipstick) {
                System.out.println(this.name+"get the lipstick");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name+"start to search for the mirror!");
                synchronized (mirror) {
                    System.out.println(this.name+"get the mirror!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.name+"finish the make up");
                }
            }
        }
    }
}

/**
 * @program: Mirror
 * @description: 镜子
 * @author: zw-cn
 * @create: 2020/2/3 14:19
 */
class Mirror {

}

/**
 * @program: Lipstick
 * @description: 口红
 * @author: zw-cn
 * @create: 2020/2/3 14:22
 */
class Lipstick {

}
