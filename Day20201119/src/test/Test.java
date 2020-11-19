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
			System.out.println("R:등록 L:전체출력");
			String protocol = input.next();
			if (protocol.equalsIgnoreCase("r")) {
				HashMap<String, String> haksaHash = new HashMap<>();
				System.out.println("나이 입력 : ");
				String age = input.next();
				System.out.println("이름 입력 : ");
				String irum = input.next();
				haksaHash.put("age", age);
				haksaHash.put("irum", irum);
				haksaList.add(haksaHash);
				System.out.println("학생이 등록되었습니다.");
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
