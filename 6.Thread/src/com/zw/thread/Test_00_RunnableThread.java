package com.zw.thread;

public class Test_00_RunnableThread {

	public static void main(String[] args) {
		new Thread(new Run(),"p1").start();
		new Thread(new Run(),"p2").start();
		new Thread(new Run(),"p3").start();
	}

}
class Run implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running!");
	}
}