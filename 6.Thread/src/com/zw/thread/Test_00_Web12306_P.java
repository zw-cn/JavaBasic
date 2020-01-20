package com.zw.thread;

public class Test_00_Web12306_P implements Runnable{
	private int tickit = 99;
	@Override
	public void run() {
		while(true) {
			if(tickit < 0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+tickit--);
		}
	}
	public static void main(String[] args) {
		Test_00_Web12306_P thread = new Test_00_Web12306_P();
		new Thread(thread,"»ÆÅ£1").start();
		new Thread(thread,"»ÆÅ£2").start();
		new Thread(thread,"»ÆÅ£3").start();
	}
}
