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

			System.out.println("=======게시판작성=======");
			System.out.println("R:등록 S:검색 D:삭제 U:수정 L:목록");

			char protocol = input.next().charAt(0); // 정한 약속(protocol)대로 입력 받는다
			if (protocol == 'r' || protocol == 'R') {// 등록
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
			} // 등록
			else if (protocol == 'S' || protocol == 's') {// 검색
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
			} // 검색
			else if (protocol == 'D' || protocol == 'd') {// 삭제
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
			} // 삭제
			else if (protocol == 'U' || protocol == 'u') {// 수정
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
			} // 수정
			else if (protocol == 'L' || protocol == 'l') {// 목록(전체출력)
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
			} // 목록
		} // while
	}

}
