package kr.co.kh.obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	
	public static Scanner input;
	public static Connection conn;
	private String titleContent;
	private int indexI;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readcount;
	private Statement stmt;
	private String sql;
	private int cnt;
	static {
		input = new Scanner(System.in);
	}

	public Register() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
		return conn;
	}

	public void setTitleContent() {
		System.out.println("����|����");
		titleContent = input.next();
	}

	public void titleContentProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}

	public void setAuthor() {
		System.out.print("�ۼ��� �Է� : ");
		author = input.next();
	}

	public void setNal() {
		System.out.print("��¥ �Է� : ");
		nal = input.next();
	}

	public void setReadcount() {
		System.out.print("��ȸ�� : ");
		readcount = input.nextInt();
	}

	public void boardQuery() throws SQLException {
		stmt = conn.createStatement();// �����غ�
		sql = "INSERT INTO board (no, title,content,author,nal,readcount) VALUES(board_no.nextval,'" + title + "', '" + content + "','"
				+ author + "','" + nal + "'," + readcount + ")";
	}

	public void boardExecute() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�.");
	}
	
//	public static void main(String[] args) {
//		
//		Register r = new Register();
//		
//		r.setTitleContent();
//		r.titleContentProcess();
//		r.setAuthor();
//		r.setNal();
//		r.setReadcount();
//		try {
//			conn = Register.getConnection();
//			r.boardQuery();
//			r.boardExecute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}