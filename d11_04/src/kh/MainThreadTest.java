package kh;

public class MainThreadTest {

	public static void main(String[] args) {
		
		long id = Thread.currentThread().getId();
		int pri = Thread.currentThread().getPriority();
		String name = Thread.currentThread().getName();
		
		Thread.State state = Thread.currentThread().getState();
		
		System.out.println("���̵� : "+id);
		System.out.println("�켱���� : "+pri);
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+state);

	}

}
