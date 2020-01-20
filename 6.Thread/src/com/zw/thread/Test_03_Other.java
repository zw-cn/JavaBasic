package com.zw.thread;

public class Test_03_Other {
	public static void main(String[] args) {
		Thread t = new Thread(new Info("战斗机"),"公鸡");
		//返回对象是否活着
		System.out.println(t.isAlive());
		//设置代理对象的名字
		System.out.println(t.getName());
		t.setName("铁质公鸡");
		System.out.println(t.getName());
		
		t.start();//start之后，对象只要还没有进入死亡状态前为活着的状态
		System.out.println(t.isAlive());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.isAlive());
	}
}
class Info implements Runnable{
	private String name;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->"+name);
	}
	public Info(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}