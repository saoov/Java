package debug;

public class Student extends Person {
	private String studentId;
	private String major;
	private int grade;

	public Student() {
		System.out.println("Student");
	}

	public Student(String studentId, String major, int grade) {
		this.grade = grade;
		this.studentId = studentId;
		this.major = major;
	}

	public Student(String name, int age, char gender, String studentId, String major, int grade) {
		super(name, age, gender);
		this.grade = grade;
		this.studentId = studentId;
		this.major = major;
		super.setAge(age);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String toString() {
		return super.toString() + studentId + grade + major;
	}
}