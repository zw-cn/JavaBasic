package com.zw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test_00_CallableThread {

	public static void main(String[] args) {
		Eat e1 = new Eat();
		Eat e2 = new Eat();
		ExecutorService s = Executors.newFixedThreadPool(2);
		Future<String> f1 = s.submit(e1);
		Future<String> f2 = s.submit(e2);
		try {
			String s1 = f1.get();
			String s2 = f2.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		s.shutdownNow();
	}

}
class Eat implements Callable<String>{
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"eating");
		return null;
	}
}