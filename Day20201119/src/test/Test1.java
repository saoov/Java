package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("R:��� L:��ü���");
			String protocol = input.next();
			if (protocol.equalsIgnoreCase("r")) {
				Student student = new Student();
				System.out.println("���� : ");
				String nai = input.next();
				System.out.println("�̸� : ");
				String irum = input.next();
				student.setNai(nai);
				student.setIrum(irum);
				studentList.add(student);
				System.out.println("�л��� ��ϵǾ����ϴ�.");
			} else if (protocol.equalsIgnoreCase("l")) {
				for(int i = 0; i<studentList.size(); i++) {
					Student student = studentList.get(i);
					System.out.println(student);
				}
			}
		}
	}
}
