package com.zw.thread;

/**
 * �̵߳����ȼ�
 * @author ZW-cn
 *
 */
public class Test_03_Priority {
	public static void main(String[] args) {
		Something st = new Something();
		Thread eat = new Thread(st, "eating");
		Thread drink = new Thread(st, "drinking");
		Thread read = new Thread(st, "reading");
		//Ҫ���������ȼ���ִ��
		eat.setPriority(Thread.NORM_PRIORITY);
		drink.setPriority(Thread.MAX_PRIORITY);
		read.setPriority(Thread.MIN_PRIORITY);
		read.start();
		eat.start();
		drink.start();
	}
}
class Something implements Runnable{
	@Override
	public void run() {
		System.out.println("doing something, like "+Thread.currentThread().getName()
				+"! the Priority is "+Thread.currentThread().getPriority());
		
	}
}
