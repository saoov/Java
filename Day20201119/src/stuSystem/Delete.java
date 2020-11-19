package stuSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	private Connection conn;
	private Statement stmt;
	private String deleteName;
	private String sql;
	private ResultSet rs;
	private String option;

	public void deleteName() {
		System.out.println("삭제할 사람의 이름을 입력해 주세요.");
		System.out.println("이름 : ");
		deleteName = Register.input.next();
	}

	public void setStmtSql() throws SQLException {
		stmt = conn.createStatement();
		sql = "";
	}

	public void executeSql() throws SQLException {
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			deleteName = rs.getString("Name");
			System.out.println(deleteName + "님을 삭제하였습니다.");
		}
	}

	public String setContinue() {
		System.out.println("계속 하시려면 1, 종료 하시려면 0을 입력해 주세요 : ");
		option = Register.input.next();
		return option;
	}

}
