package kh;

public class TestSynchronized {
	public static void main(String[] args) {
// ����ȭó�� �׽�Ʈ
		Runnable r = new AccountManager();
		Thread t1 = new Thread(r,"�ڵ�ȭ���");
		Thread t2 = new Thread(r,"���ͳݹ�ŷ");
		
		
//		Thread t3 = new AccountManager("����Ͼ�");
		t1.start();
		t2.start();
		
//		t3.start();
	}
}