package com.zw.thread;

/**
 * �������߳�Ĭ��Ϊ�û��̣߳�JVM��ȴ��û��߳�ִ����Ϻ�Ż�ֹͣ
 * ����JVM����ȴ��ػ��߳�ִ�����
 * @author ZW-cn
 *
 */
public class Test_03_Daemon {

	public static void main(String[] args) {
		Thread god = new Thread(new God(), "�ϵ�");
		Thread human = new Thread(new Person(), "����");
		god.setDaemon(true);//��Ϊ�ػ��߳�
		god.start();
		human.start();
	}

}
class God implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("�ϵ�����ͬ��~");
		}
	}
}
class Person implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<36;i++) {
			System.out.println("���������Ҫ����~"+i);
		}
	}
}