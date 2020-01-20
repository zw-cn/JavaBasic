package com.zw.thread;

public class Test_04_UnSafeToSafe_Web12306 {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t, "��ţ").start();
		new Thread(t, "��ţ").start();
		new Thread(t, "Сţ").start();
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
	 * �̲߳���ȫ
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
	 * �̰߳�ȫ���޸Ĺ���ı�������this�ĳ�Ա����
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
	 * �̰߳�ȫ���������۽���ʲô������Ҫ������Ч�ʵ�
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
	 * �̲߳���ȫ����������num����ֵ�ǲ�ͬ�Ķ���
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
	 * �̲߳���ȫ�����ٽ�ֵʱ������ָ���
	 */
	public void sell4() {
		// ֻ����һ���֣����ٽ�ֵʱ������ָ���
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
	 * �̰߳�ȫ��˫�ؼ�⣬���Ч��
	 */
	public void sell5() {
		// ˫�ؼ�⣺�ж���Ʊ
		if (num <= 0) {
			flag = false;
			return;
		}
		// ˫�ؼ�⣺�ٽ�ֵ
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
