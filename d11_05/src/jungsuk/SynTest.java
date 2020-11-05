package jungsuk; 


public class SynTest {
	public static void main(String args[]) {
		Thread t1 = new RunnableEx13("1��");
		Thread t2 = new RunnableEx13("2��");
		t1.start();
		t2.start();
		
		
	}
	
}

class Account2 {
	private int balance = 1000; // private���� �ؾ� ����ȭ�� �ǹ̰� �ִ�.

	public  int getBalance() {
		return balance;
	}

	public /*synchronized*/ void withdraw(int money){ // synchronized�� �޼��带 ����ȭ
		if(balance >= money) {
			try { Thread.sleep(10);} catch(InterruptedException e) {}
			balance -= money;
		}
	} // withdraw
}

class RunnableEx13 extends Thread {
	String name;
	RunnableEx13(String name){
		this.name = name;
	}
	Account2 acc = new Account2();

	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300���� �� ���� ������ �����ؼ� ���(withdraw)
			int money = (int)(Math.random() * 9 + 1) * 100;
			acc.withdraw(money);
			System.out.println(name+" balance:"+acc.getBalance());
		}
	} // run()
}