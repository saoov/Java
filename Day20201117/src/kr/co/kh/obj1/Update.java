package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	private Connection conn;
	private String titleSearch;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private int no;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readcount;
	private char option;
	private String titleContent;
	private int indexI;
	private String titleUpdate;
	private String contentUpdate;
	private String authorUpdate;
	private String nalUpdate;
	private int readcountUpdate;

	public void boardUpdateTitle() {
		System.out.print("������ �Խñ� ���� �Է� : ");
		titleSearch = Register.input.next();
	}

	public void boardUpdateSearch() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE='" + titleSearch + "'";
	}

	public void boardUpdateExecuteSql() throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	public void boardUpdateOld() throws SQLException {
		System.out.println("===�����ϱ� �� �Խñ��Դϴ�===");
		System.out.print("����\t����\t\t�ۼ���\t��¥\t\t��ȸ��\n");
		while (rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readcount = rs.getInt("readcount");
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
		}
	}

	public char boardUpdateOption() {
		System.out.println("������ �����Ͻðڽ��ϱ�?(y/n)");
		option = Register.input.next().charAt(0);
		return option;
	}

	public char boardUpdateConfirm() {
		if (option == 'Y' || option == 'y') {
			System.out.print("����|���� : ");
			titleContent = Register.input.next();
			indexI = titleContent.indexOf("|");
			titleUpdate = titleContent.substring(0, indexI);
			contentUpdate = titleContent.substring(indexI + 1);
			System.out.print("�ۼ��� �Է� : ");
			authorUpdate = Register.input.next();
			System.out.print("��¥ �Է� : ");
			nalUpdate = Register.input.next();
			System.out.print("��ȸ�� : ");
			readcountUpdate = Register.input.nextInt();
		}
		return option;
	}

	public void boardUpdateFinal() throws SQLException {
		stmt = conn.createStatement();
		sql = "UPDATE board SET TITLE='" + titleUpdate + "', content='" + contentUpdate + "', author='" + authorUpdate
				+ "', nal='" + nalUpdate + "', readcount='" + readcountUpdate + "' where title='" + titleSearch + "'";
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
	}

//	public static void main(String[] args) {
//		Update u = new Update();
//		u.boardUpdateTitle();
//		try {
//			u.boardUpdateSearch();
//			u.boardUpdateExecuteSql();
//			u.boardUpdateOld();
//			u.boardUpdateOption();
//			u.boardUpdateConfirm();
//			u.boardUpdateFinal();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
