package com.zw.thread;

import java.util.List;

public class Test_05_HappyTrainTicket_P {

	public static void main(String[] args) {

	}

}
class User implements Runnable{
	List<Integer> orderList;
	String name;
	
	@Override
	public void run() {
		
	}
}
class Web12306 implements Runnable{
	List<Integer> lastList;


	public Web12306(List<Integer> lastList) {
		super();
		this.lastList = lastList;
	}

	public synchronized boolean bookTicket(List<Integer> orderList) {
		List<Integer> temp = null;
		temp.addAll(lastList);
		temp.removeAll(orderList);
		if(lastList.size()-temp.size() == orderList.size()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}