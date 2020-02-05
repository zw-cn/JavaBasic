package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: 单例模式：双重检查法实现单例
 * 1.私有化构造器
 * 2.私有静态成员
 * 3.提供公共静态方法
 * @author: zw-cn
 * @create: 2020-02-05 12:22
 */
public class Test_07_Singleton_DoubleChecking {
    //私有静态成员
    private static volatile Test_07_Singleton_DoubleChecking instance;//懒汉式
    //私有化构造器
    private Test_07_Singleton_DoubleChecking() {
    }
    public static Test_07_Singleton_DoubleChecking getInstance(){
        if (instance != null){//已经存在对象就不用再等待锁
            return instance;
        }
        synchronized (Test_07_Singleton_DoubleChecking.class){
            if(instance == null){
                try {
                    Thread.sleep(1000);//模拟延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //创建对象3部曲：1.开辟空间2.初始化对象3.返回引用--->为了避免指令重排导致的其他对象获取未初始化的成员，成员上添加volatile修饰
                instance = new Test_07_Singleton_DoubleChecking();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Test_07_Singleton_DoubleChecking.getInstance());
        });
        t1.start();
        System.out.println(Test_07_Singleton_DoubleChecking.getInstance());
    }
}
