package com.zw.thread;

/**
 * ʵ������join()������ӵ���ǰ�߳�֮ǰ������ӵķ���ֻ�ܵȵ���ӷ���ִ����ɺ���ִ��
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
