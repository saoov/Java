package debug;

import java.util.*;

public class RunInherit {
	public static void main(String[] args) {
		Student st = new Student("ȫ�浿", 19, '��', "2017213", "�İ�", 3);
		System.out.println(st); // Breakpoint ����
		Person p = new Student("ȫ�浿", 19, '��', "2017213", "�İ�", 3);
		System.out.println(p); // Breakpoint ����
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("ȫ�浿", 19, '��', "2016213", "�İ�", 3));
		list.add(new Student("�踻��", 20, '��', "2013123", "����", 4));
		list.add(new Student("��Ҷ�", 22, '��', "2018123", "�İ�", 1));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	}
}
