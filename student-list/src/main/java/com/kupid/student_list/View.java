package com.kupid.student_list;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.BoxLayout;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		textField = new JTextField();
		textField.setBounds(92, 42, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 87, 86, 14);
		panel.add(lblName);
		
		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setBounds(20, 136, 60, 14);
		panel.add(lblLastname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 133, 86, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 84, 86, 20);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	}
}
