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

			System.out.println("=======게시판작성=======");
			System.out.println("R:등록 S:검색 D:삭제 U:수정 L:목록");

			char protocol = input.next().charAt(0); // 정한 약속(protocol)대로 입력 받는다
			if (protocol == 'r' || protocol == 'R') {// 등록
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
			} // 등록
			else if (protocol == 'S' || protocol == 's') {// 검색
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

			} // 검색
			else if (protocol == 'D' || protocol == 'd') {// 삭제
				try {
					delete.boardDeleteTitle();
					delete.boardDeleteSql();
					delete.boardDeleteExecute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 삭제
			else if (protocol == 'U' || protocol == 'u') {// 수정
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
				
			} // 수정
			else if (protocol == 'L' || protocol == 'l') {// 목록(전체출력)
				try {
					list.listBoardTitle();
					list.listBoardSql();
					list.listBoardExecute();
					list.listBoardProcess();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 목록
		} // while
	}

}
