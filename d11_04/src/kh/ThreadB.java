package kh;

public class ThreadB implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 100; i++) {
			System.out.print(new String("B"));
		}
		System.out.println();
	}
}