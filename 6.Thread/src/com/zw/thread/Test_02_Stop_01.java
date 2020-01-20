package com.zw.thread;

public class Test_02_Stop_01 implements Runnable{
	boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			System.out.println("running...");
		}
	}
	public void shutdown() {
		flag = false;
	}
	public static void main(String[] args) {
		Test_02_Stop_01 ts = new Test_02_Stop_01();
		new Thread(ts).start();
		Thread.yield();
		for(int i=0; i<200; i++) {
			System.out.println(i);
			if(i==90) {
				ts.shutdown();
			}
		}
	}

}
