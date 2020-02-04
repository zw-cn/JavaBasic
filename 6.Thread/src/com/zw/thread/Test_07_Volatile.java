package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: Volatile关键字同步数据
 * @author: zw-cn
 * @create: 2020-02-04 20:37
 */
public class Test_07_Volatile {
    private static int num = 0;
    private volatile static int num2 = 0;//volatile 关键字实现数据同步
    public static void main(String[] args) {
        notVolatile();//数据修改后不会停止
        //doVolatile();//数据修改后会停止
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        num2 = 1;

    }

    public static void notVolatile() {
        new Thread(()->{
            while (num == 0){
                ;
            }
        }).start();
    }
    public static void doVolatile() {
        new Thread(()->{
            while (num2 == 0){
                ;
            }
        }).start();
    }
}
