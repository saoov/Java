package kr.co.kh.obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExecute {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Register register = new Register();
		Search search = new Search();
		Delete delete = new Delete();
		Update update = new Update();
		List list = new List();
		Connection conn = null;

		while (true) {
			try {
				conn = Register.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			System.out.println("=======�Խ����ۼ�=======");
			System.out.println("R:��� S:�˻� D:���� U:���� L:���");

			char protocol = input.next().charAt(0); // ���� ���(protocol)��� �Է� �޴´�
			if (protocol == 'r' || protocol == 'R') {// ���
				try {
					register.setTitleContent();
					register.titleContentProcess();
					register.setAuthor();
					register.setNal();
					register.setReadcount();
					register.boardQuery();
					register.boardExecute();
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
					search.setTitleSearch();
					search.boardSearchTitle();
					search.boardStmtSql();
					search.boardSearchExecute();
					search.boardSearchProcess();
					search.boardSearchReadcount();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} // �˻�
			else if (protocol == 'D' || protocol == 'd') {// ����
				try {
					delete.boardDeleteTitle();
					delete.boardDeleteSql();
					delete.boardDeleteExecute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // ����
			else if (protocol == 'U' || protocol == 'u') {// ����
				char option = 'n';
				try {
					update.boardUpdateTitle();
					update.boardUpdateSearch();
					update.boardUpdateExecuteSql();
					update.boardUpdateOld();
					option = update.boardUpdateOption();
					if (option == 'N' || option == 'n') {
						continue;
					}
					update.boardUpdateConfirm();
					update.boardUpdateFinal();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} // ����
			else if (protocol == 'L' || protocol == 'l') {// ���(��ü���)
				try {
					list.listBoardTitle();
					list.listBoardSql();
					list.listBoardExecute();
					list.listBoardProcess();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // ���
		} // while
	}

}
