package stuSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Register r = new Register();
		Search s = new Search();
		Delete d = new Delete();
		Print p = new Print();

		// Class.forName("oracle.jdbc.OracleDriver");

		while (true) {
			try {
				Register.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("======메뉴 선택======");
			System.out.printf("%s%n%s%n%s%n%s%n", "1. 등록", "2. 찾기", "3. 삭제", "4. 전체출력");
			System.out.println("번호를 선택해주세요 : ");
			String protocol = input.next();
			if (protocol.equals("1")) { // 등록
				r.showMenu();
			} // 등록
			else if (protocol.equals("2")) { // 찾기

			} // 찾기
			else if (protocol.equals("3")) { // 삭제

			} // 삭제
			else if (protocol.equals("4")) { // 전체출력

			} // 전체출력
			else if (protocol.equals("0")) { // 종료

			} // 종료

		}

	}

}
