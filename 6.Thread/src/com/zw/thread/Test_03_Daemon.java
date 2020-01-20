package com.zw.thread;

/**
 * 创建的线程默认为用户线程，JVM会等待用户线程执行完毕后才会停止
 * 但是JVM不会等待守护线程执行完毕
 * @author ZW-cn
 *
 */
public class Test_03_Daemon {

	public static void main(String[] args) {
		Thread god = new Thread(new God(), "上帝");
		Thread human = new Thread(new Person(), "百姓");
		god.setDaemon(true);//作为守护线程
		god.start();
		human.start();
	}

}
class God implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("上帝与你同在~");
		}
	}
}
class Person implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<36;i++) {
			System.out.println("做人嘛，就是要快乐~"+i);
		}
	}
}