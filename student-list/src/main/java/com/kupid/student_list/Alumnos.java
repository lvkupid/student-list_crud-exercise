package com.kupid.student_list;

public class Alumnos {
	
	private int id;
	private String studentName;
	private String studentLastName;
	
	public Alumnos(int id, String studentName, String studentLastName) {
		this.id = id;
		this.studentName = studentName;
		this.studentLastName = studentLastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	
	@Override
	public String toString() {
		return "Alumnos [id=" + id + ", studentName=" + studentName + ", studentLastName=" + studentLastName + "]";
	}
	
}
