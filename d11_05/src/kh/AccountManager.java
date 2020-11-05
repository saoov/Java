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
			System.out.println(Thread.currentThread().getName()+", ���� �ܾ� : " + ac.getBalance());
//����� ���� �������� ó���� : ��� ������ ��
			int money = new java.util.Random().nextInt(10) * 100;
			System.out.println(Thread.currentThread().getName() + "��/�� ����� �� : " + money);
			ac.withDraw(money);
		}
	}
}