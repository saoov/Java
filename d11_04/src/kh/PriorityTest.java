package kh;

public class PriorityTest extends Thread {

	private String threadName;

	public PriorityTest(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(threadName + "�� ������");
		}
	}

	public static void main(String[] args) {
		
		Thread t1 = new PriorityTest("���� ���� ������");
		Thread t2 = new PriorityTest("���� ������");
		Thread t3 = new PriorityTest("���� ���� ������");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
