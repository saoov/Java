package kh;

class Thread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(getName());
	}

}

class Thread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(Thread.currentThread().getName());
	}

}

public class ThreadTest {

	public static void main(String[] args) {

		Thread1 t1 = new Thread1();
		t1.start();

		Thread t2 = new Thread(new Thread2());
		
	}

}
