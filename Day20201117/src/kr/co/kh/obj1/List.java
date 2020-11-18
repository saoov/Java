package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class List {
	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private String listTitle;
	private String listContent;
	private String listAuthor;
	private String listNal;
	private int listReadcount;
	private int listNo;

	public void listBoardTitle() {
		System.out.println("=========게시판 전체 출력=========");
		System.out.print("번호\t제목\t내용\t\t작성자\t날짜\t\t조회수\n");
	}

	public void listBoardSql() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board ORDER BY NO";
	}

	public void listBoardExecute() throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	public void listBoardProcess() throws SQLException {
		while (rs.next()) {
			listNo = rs.getInt("no");
			listTitle = rs.getString("title");
			listContent = rs.getString("content");
			listAuthor = rs.getString("author");
			listNal = rs.getString("nal");
			listReadcount = rs.getInt("readcount");
			System.out.println(listNo + "\t" + listTitle + "\t" + listContent + "\t\t" + listAuthor + "\t" + listNal + "\t" + listReadcount);
		}
	}

//	public static void main(String[] args) {
//		List l = new List();
//		l.listBoardTitle();
//		try {
//			l.listBoardSql();
//			l.listBoardExecute();
//			l.listBoardProcess();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
