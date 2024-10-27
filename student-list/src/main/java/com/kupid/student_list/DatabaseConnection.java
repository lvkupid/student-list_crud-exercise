package com.kupid.student_list;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseConnection {
	private Connection con = null;
	private static final String URL = "jdbc:mysql://localhost:3306/bdstudents";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 
	
    public Connection connect() {
    	
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database: "+ e.toString());
        }
        return con;
    	
    }
}
