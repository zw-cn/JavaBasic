package com.zw.thread;

public class Test_04_UnSafe_02 {

	public static void main(String[] args) {
		Account a = new Account(100, "彩礼");
		Draw hasband = new Draw(a, 80, "丈夫");
		Draw wife = new Draw(a, 90, "妻子");
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
		if(account.amount < 0) {//通过代码无法控制
			return;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		account.amount -= drawAmount;
		drawTotal += drawAmount;
		System.out.println(Thread.currentThread().getName()+"-->"+"取了"+drawAmount+",剩余:"+account.amount);
		System.out.println(Thread.currentThread().getName()+"口袋的钱："+drawTotal);
	}
}
