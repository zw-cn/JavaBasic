package com.zw.thread;

public class Test_01_Lambda {
	public static void main(String[] args) {
		Meat k = ()->{
			System.out.println("111");
		};
		Bread b = (int a)->{
			System.out.println("�۸��ǣ�"+ a);
		};
		b.eat(15);
		Water cola = (int w)->{
			System.out.println("����"+w+"����ˮ");
			return w>0?true:false;
		};
		System.out.println(cola.drink(-6));
	}
}
interface Meat{
	void eat();
}
interface Bread{
	void eat(int price);
}
interface Water{
	boolean drink(int ml);
}