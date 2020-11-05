package kh;

public class TestSynchronized {
	public static void main(String[] args) {
// 동기화처리 테스트
		Runnable r = new AccountManager();
		Thread t1 = new Thread(r,"자동화기기");
		Thread t2 = new Thread(r,"인터넷뱅킹");
		
		
//		Thread t3 = new AccountManager("모바일앱");
		t1.start();
		t2.start();
		
//		t3.start();
	}
}