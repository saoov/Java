package kh;

public class AccountManager implements Runnable {
	private Account ac;
	private String threadName;

	public AccountManager() {
	}

	public AccountManager(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		ac = new Account();
		while (ac.getBalance() > 0) {
			System.out.println(Thread.currentThread().getName()+", 현재 잔액 : " + ac.getBalance());
//출금할 돈을 랜덤으로 처리함 : 백원 단위로 함
			int money = new java.util.Random().nextInt(10) * 100;
			System.out.println(Thread.currentThread().getName() + "이/가 출금할 돈 : " + money);
			ac.withDraw(money);
		}
	}
}