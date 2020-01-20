package com.zw.thread;

import java.lang.Thread.State;

public class Test_03_AllStates {
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for (int i = 0; i < 20; i++) {
				if(i%5 == 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		System.out.println("当前活跃线程数："+Thread.activeCount());
		while(t.getState() != State.TERMINATED) {
			System.out.println("当前活跃线程数："+Thread.activeCount());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getState());
			if(t.getState() == State.NEW) {
				t.start();
				System.out.println(t.getState());
			}
		}
		System.out.println("当前活跃线程数："+Thread.activeCount());
		System.out.println(t.getState());
	}
}
