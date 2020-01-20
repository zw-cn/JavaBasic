package com.zw.thread;

public class Test_00_Proxy {

	public static void main(String[] args) {
		Driver proxy = new ProxyDriver(new Man());
		proxy.drive();
	}

}
interface Driver{
	void drive(); 
}
class Man implements Driver{
	@Override
	public void drive() {
		System.out.println("A man is driving!");
	}
}
class ProxyDriver implements Driver{
	private Man someone;
	public ProxyDriver(Man someone) {
		this.someone = someone;
	}
	@Override
	public void drive() {
		someone.drive();
	}
}