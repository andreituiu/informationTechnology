package com.views.student;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.INITIALIZE;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;

public class StudentFindCoursePannel extends JPanel {

	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;

	private String[] tableColumns = { "Enrolled", "Course name", "Teacher name", "Specialization" };

	public StudentFindCoursePannel() {
		initialize();
	}

	private void initialize() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 11, 317, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(360, 10, 80, 23);
		add(btnSearch);

		JButton btnEnrole = new JButton("Enrole");
		btnEnrole.setBounds(360, 146, 80, 23);
		add(btnEnrole);

		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);

		tablePanel.setLayout(null);

		tablePanel.setPreferredSize(new Dimension(536, 246));

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(tableModel);
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(10, 69, 317, 220);
		add(scrollPanel);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();

			}
		});
	}
}
