package kh;

public class Account {
//Field
	private static int balance = 1000; // 잔액
//입금스래드와 출금스래드가 함께 사용할 공유자원이 됨
//Method

	public synchronized void withDraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;

		}

	}
////출금하는 메소드  //임계영역

	public static int getBalance() {
		return balance;
	}
}