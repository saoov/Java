package kh;

public class PriorityTest extends Thread {

	private String threadName;

	public PriorityTest(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(threadName + "가 구동됨");
		}
	}

	public static void main(String[] args) {
		
		Thread t1 = new PriorityTest("제일 높은 스래드");
		Thread t2 = new PriorityTest("보통 스래드");
		Thread t3 = new PriorityTest("제일 낮은 스래드");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
