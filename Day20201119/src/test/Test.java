package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<>();

		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("R:��� L:��ü���");
			String protocol = input.next();
			if (protocol.equalsIgnoreCase("r")) {
				HashMap<String, String> haksaHash = new HashMap<>();
				System.out.println("���� �Է� : ");
				String age = input.next();
				System.out.println("�̸� �Է� : ");
				String irum = input.next();
				haksaHash.put("age", age);
				haksaHash.put("irum", irum);
				haksaList.add(haksaHash);
				System.out.println("�л��� ��ϵǾ����ϴ�.");
			} else if (protocol.equalsIgnoreCase("l")) {
				Iterator<HashMap<String,String>> it = haksaList.iterator();
				while(it.hasNext()) {
					HashMap<String, String> haksaHash = it.next();
					System.out.println(haksaHash.get("age"));
					System.out.println(haksaHash.get("irum"));
				}
			}
		}
	}
}
