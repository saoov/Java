package kh;

import java.lang.reflect.Method;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {

		
		Class uClass = Class.forName("java.net.URL");
		
		Method[] methods = uClass.getMethods();
		
		for(Method m : methods) {
			System.out.println(m);
		}
		
	}

}
