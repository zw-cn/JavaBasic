package com.zw.thread;

/**
 * 实例调用join()方法插队到当前线程之前，被插队的方法只能等到插队方法执行完成后再执行
 * @author ZW-cn
 *
 */
public class Test_02_Join_01 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda"+i);
			}
		});
		t.start();
		for (int i = 0; i < 100; i++) {
			if(i==40) {
				t.join();
			}
			System.out.println("main"+i);
		}
	}

}
