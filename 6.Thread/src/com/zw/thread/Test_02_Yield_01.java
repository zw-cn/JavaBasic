package com.zw.thread;

/**
 * 使用yield()，让出cpu。由【运行】转为【就绪】
 * @author ZW-cn
 *
 */
public class Test_02_Yield_01 implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"start");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"end");
	}
	public static void main(String[] args) {
		Test_02_Yield_01 ty = new Test_02_Yield_01();
		new Thread(ty, "a").start();
		new Thread(ty, "b").start();
	}
}
