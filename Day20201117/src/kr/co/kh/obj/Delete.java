package kr.co.kh.obj;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	private Connection conn;
	private String titleDelete;
	private Statement stmt;
	private String sql;
	private int cnt;
	
	
	public void boardDeleteTitle() {
		System.out.print("������ �Խñ� ������ �Է� : ");
		titleDelete = Register.input.next();
	}
	
	public void boardDeleteSql() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "DELETE FROM board where title='" + titleDelete + "'";
	}
	
	public void boardDeleteExecute() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
	}
	
//	public static void main(String[] args) {
//		Delete d = new Delete();
//		d.boardDeleteTitle();
//		try {
//			d.boardDeleteSql();
//			d.boardDeleteExecute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}


