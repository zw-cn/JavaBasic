package com.zw.thread;

public class Test_04_UnSafe_02 {

	public static void main(String[] args) {
		Account a = new Account(100, "����");
		Draw hasband = new Draw(a, 80, "�ɷ�");
		Draw wife = new Draw(a, 90, "����");
		hasband.start();
		wife.start();
	}

}
class Account{
	int amount;
	String name;
	int balance;
	public Account(int amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}
	
}
class Draw extends Thread{
	Account account;
	int drawAmount;
	int drawTotal;
	
	public Draw(Account account, int drawAmount, String name) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	@Override
	public void run() {
		if(account.amount < 0) {//ͨ�������޷�����
			return;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		account.amount -= drawAmount;
		drawTotal += drawAmount;
		System.out.println(Thread.currentThread().getName()+"-->"+"ȡ��"+drawAmount+",ʣ��:"+account.amount);
		System.out.println(Thread.currentThread().getName()+"�ڴ���Ǯ��"+drawTotal);
	}
}
