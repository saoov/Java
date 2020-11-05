package kh;

import java.util.Calendar;
import java.util.Date;

public class ThreadTest {

	static long start = System.currentTimeMillis();

	public static void main(String[] args) {

//		ThreadA a = new ThreadA();
//		ThreadB b = new ThreadB();

		Thread a = new Thread(new ThreadA());
		Thread b = new Thread(new ThreadB());
		ThreadC c = new ThreadC();

		System.out.println("Thread A info");
		System.out.println("id : " + a.getId());
		System.out.println("name : " + a.getName());
		System.out.println("priority : " + a.getPriority());
		System.out.println("state : " + a.getState());
		System.out.println();

		b.setPriority(9);
		System.out.println("Thread B info");
		System.out.println("id : " + b.getId());
		System.out.println("name : " + b.getName());
		System.out.println("priority : " + b.getPriority());
		System.out.println("state : " + b.getState());
		System.out.println();

		c.setPriority(3);
		System.out.println("Thread C info");
		System.out.println("id : " + c.getId());
		System.out.println("name : " + c.getName());
		System.out.println("priority : " + c.getPriority());
		System.out.println("state : " + c.getState());

	}

}
