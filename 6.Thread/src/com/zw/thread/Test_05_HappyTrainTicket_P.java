package com.zw.thread;

import java.util.ArrayList;
import java.util.List;

public class Test_05_HappyTrainTicket_P {

	public static void main(String[] args) {
		List<Integer> lastList = new ArrayList<Integer>();
		lastList.add(1);
		lastList.add(2);
		lastList.add(3);
		List<Integer> orderSeat = new ArrayList<Integer>();
		orderSeat.add(2);
		Web12306 w = new Web12306(lastList);
		new User(w, orderSeat, "Li").start();
		new User(w, orderSeat, "Wang").start();
	}

}

class User extends Thread {
	List<Integer> orderList;

	public User(Runnable target, List<Integer> orderSeat, String customName) {
		super(target, customName);
		orderList = orderSeat;
	}
}

class Web12306 implements Runnable {
	List<Integer> lastList;

	public Web12306(List<Integer> lastList) {
		super();
		this.lastList = lastList;
	}

	public synchronized boolean bookTicket(List<Integer> orderList) {

		List<Integer> temp = new ArrayList<>();
		temp.addAll(lastList);
		temp.removeAll(orderList);
		if (lastList.size() - temp.size() == orderList.size()) {
			lastList = temp;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void run() {
		// ע��˴���User��Ϊ������,ʵ�ʵ��߳�ΪWeb12306��ͨ��ǿת��ȡUser���orderList
		User u = (User) Thread.currentThread();
		Thread.yield();
		boolean b = bookTicket(u.orderList);
		if (b) {
			System.out.println(Thread.currentThread().getName() + "�ɹ���");
		} else {
			System.out.println(Thread.currentThread().getName() + "ʧ�ܣ�");
		}

	}
}