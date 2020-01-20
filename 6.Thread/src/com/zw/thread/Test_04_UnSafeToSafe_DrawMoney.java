package com.zw.thread;

public class Test_04_UnSafeToSafe_DrawMoney {
	public static void main(String[] args) {
		Accounts accounts = new Accounts(1000, "招商银行信用卡");
		ATM hasband = new ATM(accounts, 80, "hasband");
		ATM wife = new ATM(accounts, 90, "wife");
		wife.start();
		hasband.start();
	}

}
class Accounts{
	int balance;
	String name;
	public Accounts(int balance, String name) {
		this.balance = balance;
		this.name = name;
	}
	
}
class ATM extends Thread{
	Accounts accounts;
	int drawMoney;
	int totalMoney;
	public ATM(Accounts accounts, int money, String name) {
		super(name);
		this.accounts = accounts;
		this.drawMoney = money;
	}
	@Override
	public void run() {
		draw();
	}
	public void draw() {
		synchronized(accounts) {
			if(accounts.balance - drawMoney <= 0) {
				return;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			accounts.balance -= drawMoney;
			totalMoney += drawMoney;
			System.out.println(Thread.currentThread().getName()+"取出"+drawMoney+"，共取出"+totalMoney+"，账户余额"+accounts.balance);
	
		}
	}
	
}
