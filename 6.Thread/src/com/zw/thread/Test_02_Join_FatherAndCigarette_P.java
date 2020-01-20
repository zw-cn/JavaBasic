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
		System.out.println("û���ˣ����ж������̡���.");
		Son s = new Son();
		try {
			s.start();
			s.join();
			System.out.println("�ְ������̣�����Ǯ���˶���");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("���Ӳ����ˣ�ȥ�Ҷ���");
		}
	}
}
class Son extends Thread{
	@Override
	public void run() {
		System.out.println("��������Ǯ��������...");
		try {
			for(int i=1; i<=10; i++) {
				Thread.sleep(1000);
				System.out.println(i+"���ȥ��");
			}
			System.out.println("�������̻�����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}