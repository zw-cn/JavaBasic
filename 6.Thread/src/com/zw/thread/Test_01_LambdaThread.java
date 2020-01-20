package com.zw.thread;

public class Test_01_LambdaThread {

	public static void main(String[] args) {
		new Thread(()-> {
			int k = 100;
			while(k-->0) {
				System.out.println(Thread.currentThread().getName()+"is running!");
			}
		},"张三").start();
		new Thread(()-> {
			int k = 100;
			while(k-->0) {
				System.out.println(Thread.currentThread().getName()+"is running!");
			}
		},"李四").start();
	}
}
