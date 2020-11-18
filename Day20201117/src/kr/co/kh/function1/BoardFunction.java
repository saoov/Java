package kr.co.kh.function1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//�������濡 �����ϱ����� method�� ���� ������
public class BoardFunction {
	public static void register(Scanner input, Connection conn) throws SQLException {

		System.out.print("����|���� : ");
		String titleContent = input.next();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);
		System.out.print("�ۼ��� �Է� : ");
		String author = input.next();
		System.out.print("��¥ �Է� : ");
		String nal = input.next();
		System.out.print("��ȸ�� : ");
		int readcount = input.nextInt();

		// 3.�غ�(Statement) 3-1 ������ �غ� 3-2 ���� �غ�
		// Statement�� sql(����)�� ����Ű�� ����
		Statement stmt = conn.createStatement();// �����غ�
		String sql = "INSERT INTO board (no,title,content,author,nal,readcount) VALUES(board_no.nextval,'"+title+ "', '" + content + "','" + author + "','" + nal + "'," + readcount + ")";
		// 4.����(execute)
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�.");

	}

	public static void search(Scanner input, Connection conn) throws SQLException {
		System.out.print("ã�� �Խñ� ������ �Է� : ");
		String titleSearch = input.next();
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t\t��ȸ��\n");

		Statement stmt = conn.createStatement();
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE='" + titleSearch + "'";
		ResultSet rs = stmt.executeQuery(sql);
		rs = stmt.executeQuery(sql);
		int readcount = 0;
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			readcount = rs.getInt("readcount");
			System.out.println(no+"\t"+title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
			readcount++;
		}
		stmt = conn.createStatement();
		sql = "UPDATE board SET readcount=" + readcount + " where title = '" + titleSearch + "'";
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt+"���� �˻��Ǿ����ϴ�.");
	}//search

	public static void delete(Scanner input, Connection conn) throws SQLException {
		System.out.print("������ �Խñ� ������ �Է� : ");
		String titleDelete = input.next();

		// 3. �غ�
		// 3.1 ������ �غ��Ѵ�.
		Statement stmt = conn.createStatement();
		// 3.2 ������ �غ��Ѵ�.
		String sql = "DELETE FROM board where title='" + titleDelete + "'";
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");

	}//delete

	public static char update(Scanner input, Connection conn) throws SQLException {
		System.out.print("������ �Խñ� ���� �Է� : ");
		String titleSearch = input.next();
		String sql = null;

		Statement stmt = conn.createStatement();
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE='" + titleSearch + "'";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("===�����ϱ� �� �Խñ��Դϴ�===");
		System.out.print("����\t����\t�ۼ���\t��¥\t\t��ȸ��\n");
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readcount = rs.getInt("readcount");
			System.out.println(no+"\t"+title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
		}
		System.out.println("������ �����Ͻðڽ��ϱ�?(y/n)");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			System.out.print("����|���� : ");
			String titleContent = input.next();
			int indexI = titleContent.indexOf("|");
			String titleUpdate = titleContent.substring(0, indexI);
			String contentUpdate = titleContent.substring(indexI + 1);
			System.out.print("�ۼ��� �Է� : ");
			String authorUpdate = input.next();
			System.out.print("��¥ �Է� : ");
			String nalUpdate = input.next();
			System.out.print("��ȸ�� : ");
			int readcountUpdate = input.nextInt();
			stmt = conn.createStatement();
			sql = "UPDATE board SET TITLE='" + titleUpdate + "', content='" + contentUpdate + "', author='"
					+ authorUpdate + "', nal='" + nalUpdate + "', readcount='" + readcountUpdate + "' where title='"
					+ titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
		}
		return option;
	}//update

	public static void list(Connection conn) throws SQLException {
		System.out.println("===�Խ��� ��ü ���===");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t\t��ȸ��\n");
		// 3.1 ���� �غ�

		Statement stmt = conn.createStatement();
		// 3.2 ���� �غ�
		String sql = "SELECT * FROM board";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readcount = rs.getInt("readcount");
			System.out.println(no+"\t"+title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
		}
	}//list
}
