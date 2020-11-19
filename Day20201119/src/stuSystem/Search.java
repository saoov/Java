package stuSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {

	private Connection conn;
	private Statement stmt;
	private String searchName;
	private String sql;
	private ResultSet rs;
	private int age;
	private String name;
	private int code;
	private String value;
	private String option;

	public void setOption() {
		System.out.println("찾을 이름을 입력해 주세요");
		System.out.println("이름 : ");
		searchName = Register.input.next();
	}

	public void setStmtSql() throws SQLException {
		stmt = conn.createStatement();
		sql = "SELECT * FROM schoolpj WHERE Name='" + searchName + "'";
	}

	public void executeSql() throws SQLException {
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			age = rs.getInt("Age");
			name = rs.getString("Name");
			code = rs.getInt("Code");

			System.out.println("나이 : " + age + "\t" + "이름 : " + name + "\t" + "학번 : " + value);
		}
	}

	public String setContinue() {
		System.out.println("계속 하시려면 1, 종료 하시려면 0을 입력해 주세요 : ");
		option = Register.input.next();
		return option;
	}

}
