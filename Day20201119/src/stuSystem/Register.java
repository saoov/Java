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
		System.out.println("======메뉴 선택======");
		System.out.printf("%s%n%s%n%s%n%s%n", "1. 학생", "2. 교수", "3. 관리자", "4. 이전메뉴");
		System.out.println("번호를 선택해주세요 : ");
		option = input.next();
	}

	public void option() {
		if (option.equals("1")) { // 학생
			code = "1";
			setAge();
			setName();
			setCode();
		} // 학생
		else if (option.equals("2")) { // 교수
			code = "2";
			setAge();
			setName();
			setCode();
		} // 교수
		else if (option.equals("3")) { // 관리자
			code = "3";
			setAge();
			setName();
			setCode();
		} // 관리자
		else if (option.equals("4")) { // 이전메뉴
			code = "4";
			setAge();
			setName();
			setCode();
		} // 이전메뉴
	}

	public void setAge() {
		System.out.println("나이 : ");
		age = input.next();
	}

	public void setName() {
		System.out.println("이름 : ");
		name = input.next();
	}

	public void setCode() {
		System.out.println("학번 : ");
		value = input.next();
	}

	public void setStmtSql() throws SQLException {
		stmt = conn.createStatement();
		sql = "INSERT INTO schoolpj(Name,Age,Value,Code) VALUES('"+name+"'," + age + ",'" + value + "'," + code + ")";
	}

	public void executeSql() throws SQLException {
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건이 등록되었습니다.");
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
