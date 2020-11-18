package kr.co.kh.obj1;

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
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8", "root", "");
		return conn;
	}

	public void setTitleContent() {
		System.out.println("제목|내용");
		titleContent = input.next();
	}

	public void titleContentProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
	}

	public void setAuthor() {
		System.out.print("작성자 입력 : ");
		author = input.next();
	}

	public void setNal() {
		System.out.print("날짜 입력 : ");
		nal = input.next();
	}

	public void setReadcount() {
		System.out.print("조회수 : ");
		readcount = input.nextInt();
	}

	public void boardQuery() throws SQLException {
		stmt = conn.createStatement();// 공간준비
		sql = "INSERT INTO board (title,content,author,nal,readcount) VALUES('" + title + "', '" + content + "','"
				+ author + "','" + nal + "'," + readcount + ")";
	}

	public void boardExecute() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건 게시글이 등록되었습니다.");
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