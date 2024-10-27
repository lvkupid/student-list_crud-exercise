package com.kupid.student_list;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
	
	public void ListStudents(JTable studentsTable) {
		
		DatabaseConnection con = new DatabaseConnection();
		DefaultTableModel model = new DefaultTableModel();
		
		TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
		studentsTable.setRowSorter(orderTable);
		
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Lastname");
		
		studentsTable.setModel(model);
		
		String query = "SELECT * FROM students_list";
		
		String[] data  = new String[3];
		Statement st;
		
		try {
			st = con.connect().createStatement();
			
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				data[0] = rs.getString(1);
				data[1] = rs.getString(2);
				data[2] = rs.getString(3);
				
				model.addRow(data);
			}
			
			studentsTable.setModel(model);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "LISTTABLE Error: " + e.toString());
		}
		
	}
	
}
