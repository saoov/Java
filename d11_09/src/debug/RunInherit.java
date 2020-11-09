package debug;

import java.util.*;

public class RunInherit {
	public static void main(String[] args) {
		Student st = new Student("홍길동", 19, '남', "2017213", "컴공", 3);
		System.out.println(st); // Breakpoint 설정
		Person p = new Student("홍길동", 19, '남', "2017213", "컴공", 3);
		System.out.println(p); // Breakpoint 설정
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", 19, '남', "2016213", "컴공", 3));
		list.add(new Student("김말똥", 20, '여', "2013123", "생명", 4));
		list.add(new Student("김소똥", 22, '남', "2018123", "컴공", 1));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	}
}
