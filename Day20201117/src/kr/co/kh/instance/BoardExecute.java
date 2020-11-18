package kr.co.kh.instance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardExecute {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		BoardFunction boardObj = new BoardFunction();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection conn = null;
		while (true) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8", "root",
						"");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			System.out.println("=======�Խ����ۼ�=======");
			System.out.println("R:��� S:�˻� D:���� U:���� L:���");

			char protocol = input.next().charAt(0); // ���� ���(protocol)��� �Է� �޴´�
			if (protocol == 'r' || protocol == 'R') {// ���
				try {
					boardObj.register(input, conn);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} // ���
			else if (protocol == 'S' || protocol == 's') {// �˻�
				try {
					boardObj.search(input, conn);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} // �˻�
			else if (protocol == 'D' || protocol == 'd') {// ����
				try {
					boardObj.delete(input, conn);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} // ����
			else if (protocol == 'U' || protocol == 'u') {// ����
				char option = 'n';
				try {
					option = boardObj.update(input, conn);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (option == 'N' || option == 'n')
					continue;
			} // ����
			else if (protocol == 'L' || protocol == 'l') {// ���(��ü���)
				try {
					boardObj.list(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} // ���
		} // while
	}

}
