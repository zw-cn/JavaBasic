package com.zw.thread;

/**
 * ʹ�ü̳������߳�
 * @author ZW-cn
 *
 */
public class Test_00_ExtendThread {

	public static void main(String[] args) {
		SpeakThread s1 = new SpeakThread();
		SpeakThread s2 = new SpeakThread();
		SpeakThread s3 = new SpeakThread();
		s1.start();
		s2.start();
		s3.start();
	}

}
class SpeakThread extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"˵");
	}
}
