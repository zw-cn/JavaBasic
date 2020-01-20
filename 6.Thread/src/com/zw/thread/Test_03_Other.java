package com.zw.thread;

public class Test_03_Other {
	public static void main(String[] args) {
		Thread t = new Thread(new Info("ս����"),"����");
		//���ض����Ƿ����
		System.out.println(t.isAlive());
		//���ô�����������
		System.out.println(t.getName());
		t.setName("���ʹ���");
		System.out.println(t.getName());
		
		t.start();//start֮�󣬶���ֻҪ��û�н�������״̬ǰΪ���ŵ�״̬
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