package com.zw.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaBasic
 * @description: 可重入锁的手工实现
 * @author: zw-cn
 * @create: 2020-02-06 10:26
 */
public class Test_07_Lock_02 {
    private enLock lock = new enLock();
    private ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Test_07_Lock_02 test_07_lock_02 = new Test_07_Lock_02();
        test_07_lock_02.watchTV();//验证手工可重入锁
        test_07_lock_02.watchTV2();//使用JDK中可重入锁
    }
    public void watchTV(){
        lock.lock();
        goBackHome();
        System.out.println("enjoy tv show");
        lock.unlock();
    }
    public void goBackHome(){
        lock.lock();
        System.out.println("go back home");
        lock.unlock();
    }
    public void watchTV2(){
        reentrantLock.lock();
        goBackHome2();
        System.out.println("enjoy tv show");
        reentrantLock.unlock();
    }
    public void goBackHome2(){
        reentrantLock.lock();
        System.out.println("go back home");
        reentrantLock.unlock();
    }
}
class enLock{
    private boolean isLock;
    private int useCount;
    private Thread useThread;
    public synchronized void lock(){
        if(isLock && Thread.currentThread() != useThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        useThread = Thread.currentThread();
        isLock = true;
        useCount++;
    }
    public synchronized void unlock(){
        if(Thread.currentThread() == useThread){
            useCount --;
            if(useCount == 0){
                useThread = null;
            }
        }
    }
}
