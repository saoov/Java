package kh;

public class Account {
//Field
	private static int balance = 1000; // �ܾ�
//�Աݽ������ ��ݽ����尡 �Բ� ����� �����ڿ��� ��
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
////����ϴ� �޼ҵ�  //�Ӱ迵��

	public static int getBalance() {
		return balance;
	}
}