package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("R:등록 L:전체출력");
			String protocol = input.next();
			if (protocol.equalsIgnoreCase("r")) {
				Student student = new Student();
				System.out.println("나이 : ");
				String nai = input.next();
				System.out.println("이름 : ");
				String irum = input.next();
				student.setNai(nai);
				student.setIrum(irum);
				studentList.add(student);
				System.out.println("학생이 등록되었습니다.");
			} else if (protocol.equalsIgnoreCase("l")) {
				for(int i = 0; i<studentList.size(); i++) {
					Student student = studentList.get(i);
					System.out.println(student);
				}
			}
		}
	}
}
