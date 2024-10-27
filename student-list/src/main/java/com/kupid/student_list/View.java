package com.kupid.student_list;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblId;
	private JTextField txtId;
	private JTextField txtLastName;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public View() {
		
		DatabaseConnection obj = new DatabaseConnection();
		obj.connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 383);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 194, 322);
		panel.setBorder(new TitledBorder(null, "Students Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(20, 45, 104, 14);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(92, 42, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 87, 86, 14);
		panel.add(lblName);
		
		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setBounds(20, 136, 60, 14);
		panel.add(lblLastname);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(92, 133, 86, 20);
		txtLastName.setColumns(10);
		panel.add(txtLastName);
		
		txtName = new JTextField();
		txtName.setBounds(92, 84, 86, 20);
		txtName.setColumns(10);
		panel.add(txtName);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumnos objStudent = new Alumnos();
				objStudent.InsertStudent(txtName, txtLastName);
			}
		});
		btnSave.setBounds(39, 193, 119, 23);
		panel.add(btnSave);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(39, 227, 119, 23);
		panel.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(39, 263, 119, 23);
		panel.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Students List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(214, 11, 480, 322);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 21, 460, 290);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		panel_1.add(table);
		
		Alumnos objAlu = new Alumnos();
		objAlu.ListStudents(table);
		
	}
}
