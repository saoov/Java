package kh;

public class ThreadA implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.print(new String("A"));
		}
		System.out.println();
		System.out.println("�ɸ��ð� : " + (System.currentTimeMillis() - ThreadTest.start)/1000.0+"��");
	}

}
