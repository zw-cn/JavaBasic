package com.zw.thread;

public class Test_00_RabbitVSTortoise_P implements Runnable{
	String	winner;
	@Override
	public void run() {
		for(int step=0; step<=100; step++) {
			if(Thread.currentThread().getName().equals("Rabbit") && step%10 == 0) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+step);
			if(gameOver(step)) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner != null) {
			return true;
		}else{
			if(steps == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner-->"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Test_00_RabbitVSTortoise_P runner = new Test_00_RabbitVSTortoise_P();
		new Thread(runner, "Rabbit").start();
		new Thread(runner, "Tortoise").start();
	}

}
