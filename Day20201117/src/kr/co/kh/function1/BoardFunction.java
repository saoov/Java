package kr.co.kh.function1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//유지변경에 유리하기위해 method를 따로 빼놓음
public class BoardFunction {
	public static void register(Scanner input, Connection conn) throws SQLException {

		System.out.print("제목|내용 : ");
		String titleContent = input.next();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);
		System.out.print("작성자 입력 : ");
		String author = input.next();
		System.out.print("날짜 입력 : ");
		String nal = input.next();
		System.out.print("조회수 : ");
		int readcount = input.nextInt();

		// 3.준비(Statement) 3-1 공간을 준비 3-2 쿼리 준비
		// Statement는 sql(문장)을 가리키는 역할
		Statement stmt = conn.createStatement();// 공간준비
		String sql = "INSERT INTO board (no,title,content,author,nal,readcount) VALUES(board_no.nextval,'"+title+ "', '" + content + "','" + author + "','" + nal + "'," + readcount + ")";
		// 4.실행(execute)
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건 게시글이 등록되었습니다.");

	}

	public static void search(Scanner input, Connection conn) throws SQLException {
		System.out.print("찾는 게시글 제목을 입력 : ");
		String titleSearch = input.next();
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t\t조회수\n");

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
		System.out.println(cnt+"건이 검색되었습니다.");
	}//search

	public static void delete(Scanner input, Connection conn) throws SQLException {
		System.out.print("삭제할 게시글 제목을 입력 : ");
		String titleDelete = input.next();

		// 3. 준비
		// 3.1 공간을 준비한다.
		Statement stmt = conn.createStatement();
		// 3.2 쿼리를 준비한다.
		String sql = "DELETE FROM board where title='" + titleDelete + "'";
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건 게시글이 삭제되었습니다.");

	}//delete

	public static char update(Scanner input, Connection conn) throws SQLException {
		System.out.print("변경할 게시글 제목 입력 : ");
		String titleSearch = input.next();
		String sql = null;

		Statement stmt = conn.createStatement();
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE='" + titleSearch + "'";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("===변경하기 전 게시글입니다===");
		System.out.print("제목\t내용\t작성자\t날짜\t\t조회수\n");
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readcount = rs.getInt("readcount");
			System.out.println(no+"\t"+title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
		}
		System.out.println("정말로 변경하시겠습니까?(y/n)");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			System.out.print("제목|내용 : ");
			String titleContent = input.next();
			int indexI = titleContent.indexOf("|");
			String titleUpdate = titleContent.substring(0, indexI);
			String contentUpdate = titleContent.substring(indexI + 1);
			System.out.print("작성자 입력 : ");
			String authorUpdate = input.next();
			System.out.print("날짜 입력 : ");
			String nalUpdate = input.next();
			System.out.print("조회수 : ");
			int readcountUpdate = input.nextInt();
			stmt = conn.createStatement();
			sql = "UPDATE board SET TITLE='" + titleUpdate + "', content='" + contentUpdate + "', author='"
					+ authorUpdate + "', nal='" + nalUpdate + "', readcount='" + readcountUpdate + "' where title='"
					+ titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "건 게시글이 수정되었습니다.");
		}
		return option;
	}//update

	public static void list(Connection conn) throws SQLException {
		System.out.println("===게시판 전체 출력===");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t\t조회수\n");
		// 3.1 공간 준비

		Statement stmt = conn.createStatement();
		// 3.2 쿼리 준비
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
