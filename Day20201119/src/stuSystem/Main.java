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
			System.out.println("======�޴� ����======");
			System.out.printf("%s%n%s%n%s%n%s%n", "1. ���", "2. ã��", "3. ����", "4. ��ü���");
			System.out.println("��ȣ�� �������ּ��� : ");
			String protocol = input.next();
			if (protocol.equals("1")) { // ���
				r.showMenu();
			} // ���
			else if (protocol.equals("2")) { // ã��

			} // ã��
			else if (protocol.equals("3")) { // ����

			} // ����
			else if (protocol.equals("4")) { // ��ü���

			} // ��ü���
			else if (protocol.equals("0")) { // ����

			} // ����

		}

	}

}
