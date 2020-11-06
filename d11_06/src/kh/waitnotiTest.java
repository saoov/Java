package kh;

import java.util.ArrayList;
import java.util.List;

class Table {
	String[] dishName = { "Burger", "Donut", "Donut" };
	private int MAX_DISHES = 6;
	private List<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if (dishes.size() >= MAX_DISHES) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting...");
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
		notify();
	}

	public synchronized void remove(String dishName) {
			String name = Thread.currentThread().getName();
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting...");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			while (true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				} // for

				
				try {
					System.out.println(name + " is waiting...");
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
			} // while
	}//method

	public int dishNum() {
		return dishName.length;
	}

}

class Cook implements Runnable {
	private Table table;

	public Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {

		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishName[idx]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

	}

}

class Cus implements Runnable {
	private Table table;
	private String food;

	public Cus(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {

		while (true) {
			String name = Thread.currentThread().getName();
			table.remove(food);
			System.out.println(name + " ate a " + food);
		}

	}

}

public class waitnotiTest {

	public static void main(String[] args) {
		Table table = new Table();

		new Thread(new Cook(table), "COOK").start();
		new Thread(new Cus(table, "Burger"), "Tomas").start();
		new Thread(new Cus(table, "Donut"), "James").start();
		new Thread(new Cus(table, "Donut"), "Paul").start();
		new Thread(new Cus(table, "Pizza"), "PizzaKing").start();

	}

}
