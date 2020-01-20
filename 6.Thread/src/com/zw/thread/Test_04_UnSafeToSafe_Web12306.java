package com.zw.thread;

public class Test_04_UnSafeToSafe_Web12306 {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t, "大牛").start();
		new Thread(t, "二牛").start();
		new Thread(t, "小牛").start();
	}
}

class Ticket implements Runnable {
	private int num = 5;
	boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			sell5();
		}
	}

	/**
	 * 线程不安全
	 */
	public void sell0() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + num--);
	}

	/**
	 * 线程安全：修改共享的变量都是this的成员变量
	 */
	public synchronized void sell1() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + num--);
	}

	/**
	 * 线程安全，但是无论进行什么操作都要等锁，效率低
	 */
	public void sell2() {
		synchronized (this) {
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + num--);
		}
	}

	/**
	 * 线程不安全：锁定的是num，数值是不同的对象
	 */
	public void sell3() {
		synchronized ((Integer) num) {
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + num--);
		}
	}

	/**
	 * 线程不安全：当临界值时，会出现负数
	 */
	public void sell4() {
		// 只锁定一部分，当临界值时，会出现负数
		synchronized ((Integer) num) {
			if (num <= 0) {
				flag = false;
				return;
			}
		}

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + num--);
	}

	/**
	 * 线程安全：双重检测，提高效率
	 */
	public void sell5() {
		// 双重检测：判断有票
		if (num <= 0) {
			flag = false;
			return;
		}
		// 双重检测：临界值
		synchronized (this) {
			if (num <= 0) {
				flag = false;
				return;
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + num--);
		}
	}
}
