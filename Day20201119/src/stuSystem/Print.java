package stuSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Print {

	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private String name;
	private int age;
	private String value;

	public void showInfoAll() throws SQLException {
		stmt = conn.createStatement();
		sql = "";
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			name = rs.getString("Name");
			age = rs.getInt("Age");
			value = rs.getString("Value");
			
			System.out.println("�̸� : "+name+"\t"+"���� : "+age+"\t\t"+"�й� : "+value);
		}
	}
}
