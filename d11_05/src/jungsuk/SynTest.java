package jungsuk; 


public class SynTest {
	public static void main(String args[]) {
		Thread t1 = new RunnableEx13("1번");
		Thread t2 = new RunnableEx13("2번");
		t1.start();
		t2.start();
		
		
	}
	
}

class Account2 {
	private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

	public  int getBalance() {
		return balance;
	}

	public /*synchronized*/ void withdraw(int money){ // synchronized로 메서드를 동기화
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
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 9 + 1) * 100;
			acc.withdraw(money);
			System.out.println(name+" balance:"+acc.getBalance());
		}
	} // run()
}