package jungsuk;

@FunctionalInterface
interface MyFunction{
	abstract void run();
}

public class LambdaTest {
	
	static void execute(MyFunction f) {
		f.run();
	}
	
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("함수형 인터페이스");
		return f;
	}
	
	public static void main(String[] args) {

		MyFunction f1 = () -> System.out.println("f1");
		
		MyFunction f2 = new MyFunction() {
			
			@Override
			public void run() {
				System.out.println("f2");
			}
		};
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( ()->System.out.println("run()"));

	}//main

}
