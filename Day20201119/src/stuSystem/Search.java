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
		System.out.println("ã�� �̸��� �Է��� �ּ���");
		System.out.println("�̸� : ");
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

			System.out.println("���� : " + age + "\t" + "�̸� : " + name + "\t" + "�й� : " + value);
		}
	}

	public String setContinue() {
		System.out.println("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է��� �ּ��� : ");
		option = Register.input.next();
		return option;
	}

}
