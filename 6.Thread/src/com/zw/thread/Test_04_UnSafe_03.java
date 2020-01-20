package com.zw.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 容器操作的同步问题
 * 视频上说是被覆盖了，我认为是线程还未执行完，让主线程睡眠1秒后即正常
 * @author ZW-cn
 *
 */
public class Test_04_UnSafe_03 {

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println(list.size());
		while(Thread.activeCount() !=1) {
			System.out.println(list.size());
		}
		Thread.sleep(20000);
		System.out.println(list.size());
		System.out.println("###############");
		List<String> v = new Vector<>();
		for(int i=0;i<100;i++) {
			new Thread(()->{
				v.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println(v.size());
	}

}
