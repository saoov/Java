package kh;

import javax.swing.JOptionPane;

public class InterruptTest {
	public static void main(String[] args) throws Exception {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();
		//
//		System.out.println("isInterrupted():"+ th1.isInterrupted()); // false		

		String input = JOptionPane.showInputDialog("�̾ ������ �Ϸ��� ������ �ְų� 'Continue'��� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");

		th1.interrupt(); // interrupt()�� ȣ���ϸ�, interrupted���°� true�� �ȴ�.
		//
//		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true(���°� ��ȯ)

	}
}

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;

		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for (long x = 0; x < 5_500_000_000L; x++)
				; // �ð� ����
		}

		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}
}
