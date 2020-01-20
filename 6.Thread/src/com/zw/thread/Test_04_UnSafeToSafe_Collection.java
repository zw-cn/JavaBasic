package com.zw.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 锁定需要修改的对象
 * @author ZW-cn
 *
 */
public class Test_04_UnSafeToSafe_Collection {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				//同步块->list
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}
