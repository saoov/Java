package kh;

public class MainThreadTest {

	public static void main(String[] args) {
		
		long id = Thread.currentThread().getId();
		int pri = Thread.currentThread().getPriority();
		String name = Thread.currentThread().getName();
		
		Thread.State state = Thread.currentThread().getState();
		
		System.out.println("아이디 : "+id);
		System.out.println("우선순위 : "+pri);
		System.out.println("이름 : "+name);
		System.out.println("상태 : "+state);

	}

}
