package com.zw.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快乐电影院
 * 
 * @author ZW-cn
 *
 */
public class Test_05_HappyCinema_P {

	public static void main(String[] args) {
		Integer[] seatsArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> cinemaSeats = Arrays.asList(seatsArray);

		Cinema cinema = new Cinema("欢乐喜剧人", cinemaSeats);
		List<Integer> c1BookSeats = new ArrayList<>();
		c1BookSeats.add(1);
		c1BookSeats.add(2);
		c1BookSeats.add(3);
		List<Integer> c2BookSeats = new ArrayList<>();
		c2BookSeats.add(4);
		c2BookSeats.add(5);
		Customer c1 = new Customer("Wang", c1BookSeats, cinema);
		Customer c2 = new Customer("Li", c2BookSeats, cinema);
		new Thread(c1).start();
		new Thread(c2).start();
	}
}

class Cinema {
	String name;
	List<Integer> seats;

	public Cinema(String name, List<Integer> seats) {
		super();
		this.name = name;
		this.seats = seats;
	}

	public boolean book(List<Integer> seatscustomer) {
		System.out.println("可定位置" + seats);
		List<Integer> temp = new ArrayList<>();
		temp.addAll(seats);
		temp.removeAll(seatscustomer);
		if (seats.size() - temp.size() != seatscustomer.size()) {
			return false;
		}
		seats = temp;
		return true;
	}
}

class Customer implements Runnable {
	String name;
	List<Integer> seats;
	Cinema cinema;

	public Customer(String name, List<Integer> seats, Cinema cinema) {
		super();
		this.name = name;
		this.seats = seats;
		this.cinema = cinema;
	}

	@Override
	public void run() {
		synchronized (cinema) {
			System.out.println(name + "预定：" + seats);
			if (cinema.book(seats)) {
				System.out.println(name + "您订票成功");
			} else {
				System.out.println(name + "您订票失败");
			}
		}
	}
}