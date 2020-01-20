package com.zw.thread;

public class Test_02_Join_FatherAndCigarette_P {
	public static void main(String[] args) {
		Father f = new Father();
		f.start();
	}
}
class Father extends Thread{
	@Override
	public void run() {
		System.out.println("没烟了，呼叫儿子买烟。。.");
		Son s = new Son();
		try {
			s.start();
			s.join();
			System.out.println("爸爸拿着烟，把零钱给了儿子");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("儿子不见了，去找儿子");
		}
	}
}
class Son extends Thread{
	@Override
	public void run() {
		System.out.println("儿子拿着钱，出门了...");
		try {
			for(int i=1; i<=10; i++) {
				Thread.sleep(1000);
				System.out.println(i+"秒过去了");
			}
			System.out.println("儿子买烟回来了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}