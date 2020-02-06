package com.zw.thread;

/**
 * @program: JavaBasic
 * @description: 手写不可重入锁
 * @author: zw-cn
 * @create: 2020-02-05 20:50
 */
public class Test_07_Lock_01 {
    Lock lock = new Lock();
    public static void main(String[] args) {
        Test_07_Lock_01 lock_01 = new Test_07_Lock_01();
//        lock_01.watchTV();//不可重入锁
        lock_01.a();//synchronized默认为可重入的
    }
    public void watchTV(){
        lock.lock();
        goBackHome();
        System.out.println("enjoy tv show");
        lock.unlock();
    }
    public void goBackHome(){
        lock.lock();
        lock.unlock();
    }
    public synchronized void a(){
        b();
    }public synchronized void b(){
        c();
    }public synchronized void c(){
        System.out.println("into c()");
    }
}
class Lock{
    private boolean isLocked;
    public synchronized void lock(){
        if (isLocked){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
