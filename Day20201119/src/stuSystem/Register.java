package stuSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	public static Scanner input;
	public static Connection conn;
	private Statement stmt;
	private String name;
	private String age;
	private String value;
	private String code;
	private String sql;
	private String option;

	static {
		input = new Scanner(System.in);
	}

	public Register() {
	}

	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
		return conn;
	}

	public void showMenu() {
		System.out.println("======�޴� ����======");
		System.out.printf("%s%n%s%n%s%n%s%n", "1. �л�", "2. ����", "3. ������", "4. �����޴�");
		System.out.println("��ȣ�� �������ּ��� : ");
		option = input.next();
	}

	public void option() {
		if (option.equals("1")) { // �л�
			code = "1";
			setAge();
			setName();
			setCode();
		} // �л�
		else if (option.equals("2")) { // ����
			code = "2";
			setAge();
			setName();
			setCode();
		} // ����
		else if (option.equals("3")) { // ������
			code = "3";
			setAge();
			setName();
			setCode();
		} // ������
		else if (option.equals("4")) { // �����޴�
			code = "4";
			setAge();
			setName();
			setCode();
		} // �����޴�
	}

	public void setAge() {
		System.out.println("���� : ");
		age = input.next();
	}

	public void setName() {
		System.out.println("�̸� : ");
		name = input.next();
	}

	public void setCode() {
		System.out.println("�й� : ");
		value = input.next();
	}

	public void setStmtSql() throws SQLException {
		stmt = conn.createStatement();
		sql = "INSERT INTO schoolpj(Name,Age,Value,Code) VALUES('"+name+"'," + age + ",'" + value + "'," + code + ")";
	}

	public void executeSql() throws SQLException {
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "���� ��ϵǾ����ϴ�.");
	}

	public static void main(String[] args) {
		Register r = new Register();
		try {
			Register.getConnection();
			r.showMenu();
			r.option();
			r.setStmtSql();
			r.executeSql();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
