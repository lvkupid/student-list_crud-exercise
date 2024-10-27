package com.kupid.student_list;

import java.sql.CallableStatement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Alumnos {
	
	private int id;
	private String studentName;
	private String studentLastName;
	
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
	
	public void InsertStudent(JTextField name, JTextField last) {
		
		setStudentName(name.getText());
		setStudentLastName(last.getText());
		
		DatabaseConnection con = new DatabaseConnection();
		
		String query = "INSERT INTO students_list (name, lastname) VALUES (?,?);";
		
		try {
			CallableStatement cs = con.connect().prepareCall(query);
			cs.setString(1, getStudentName());
			cs.setString(2, getStudentLastName());
			cs.execute();
			JOptionPane.showMessageDialog(null, "INSERT Success");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "INSERT Error: " + e.toString());
		}
		
	}
	
}
