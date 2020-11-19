package test;

import java.io.Serializable;

public class Student implements Serializable {

	private String irum;
	private String nai;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String irum, String nai) {
		super();
		this.irum = irum;
		this.nai = nai;
	}

	@Override
	public String toString() {
		return "Student [irum=" + irum + ", nai=" + nai + "]";
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public String getNai() {
		return nai;
	}

	public void setNai(String nai) {
		this.nai = nai;
	}

}
