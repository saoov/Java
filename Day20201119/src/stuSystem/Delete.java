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
		System.out.println("������ ����� �̸��� �Է��� �ּ���.");
		System.out.println("�̸� : ");
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
			System.out.println(deleteName + "���� �����Ͽ����ϴ�.");
		}
	}

	public String setContinue() {
		System.out.println("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է��� �ּ��� : ");
		option = Register.input.next();
		return option;
	}

}
