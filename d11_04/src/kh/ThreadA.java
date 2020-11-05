package kh;

public class ThreadA implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.print(new String("A"));
		}
		System.out.println();
		System.out.println("걸린시간 : " + (System.currentTimeMillis() - ThreadTest.start)/1000.0+"초");
	}

}
