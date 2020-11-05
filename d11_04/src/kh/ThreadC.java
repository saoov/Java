package kh;

public class ThreadC extends Thread {

	@Override
	public void run() {

		for (int i = 1; i <= 100; i++) {
			System.out.print(new String("C"));
		}
		System.out.println();
	}
}