package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {
	private String titleSearch;
	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private int cnt;
	private int searchNo;
	private String searchTitle;
	private String searchContent;
	private String searchAuthor;
	private String searchNal;
	private int searchReadcount;

	public void setTitleSearch() {
		System.out.print("찾는 게시글 제목을 입력 : ");
		titleSearch = Register.input.next();
	}

	public void boardSearchTitle() throws SQLException {
		System.out.print("번호\t제목\t내용\t\t작성자\t날짜\t\t조회수\n");
		conn = Register.getConnection();
	}

	public void boardStmtSql() throws SQLException {
		stmt = conn.createStatement();
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE='" + titleSearch + "'";
	}

	public void boardSearchExecute() throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	public void boardSearchProcess() throws SQLException {
		while (rs.next()) {
			searchNo = rs.getInt("no");
			searchTitle = rs.getString("title");
			searchContent = rs.getString("content");
			searchAuthor = rs.getString("author");
			searchNal = rs.getString("nal");
			searchReadcount = rs.getInt("readcount");
			System.out.println(searchNo + "\t" + searchTitle + "\t" + searchContent + "\t" + searchAuthor + "\t"
					+ searchNal + "\t" + searchReadcount);
			searchReadcount++;
		}
	}

	public void boardSearchReadcount() throws SQLException {

		stmt = Register.conn.createStatement();
		sql = "UPDATE board SET readcount=" + searchReadcount + " where title = '" + titleSearch + "'";
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건이 검색되었습니다.");
	}

//	public static void main(String[] args) {
//		Search s = new Search();
//		s.setTitleSearch();
//
//		try {
//			s.boardSearchTitle();
//			s.boardStmtSql();
//			s.boardSearchExecute();
//			s.boardSearchProcess();
//			s.boardSearchReadcount();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
