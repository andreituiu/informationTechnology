package com.views.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.controllers.admin.IAdminManageUsersController;
import com.controllers.common.ILanguageController;
import com.model.Course;
import com.model.User;
import com.views.common.ILanguagePanel;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ManageUsers extends JPanel implements ILanguagePanel{
	
	private JTextField searchTextField;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;
	
	private String[] tableColumns = {"Name", "Surname", "CNP", "Role"};
	
	private JButton btnDelete;
	private JButton btnModify;
	private JButton btnCreate;
	private JButton btnSearch;
	
	private IAdminManageUsersController adminManageUsersController;
	
	private List<User> usersList;
	
	public ManageUsers(final IAdminManageUsersController adminManageUsersController) {
		setBackground(new Color(215, 228, 242));
		this.adminManageUsersController = adminManageUsersController;
		setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(12, 42, 525, 35);
		add(searchTextField);
		searchTextField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(560, 41, 209, 35);
		add(btnSearch);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);
		
		tablePanel.setLayout(null);
		
		tablePanel.setPreferredSize(new Dimension(536, 246));
		
		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "CNP", "Role"
			}
		));
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(12, 119, 525, 360);
		add(scrollPanel);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(55, 492, 209, 35);
		add(btnDelete);
		
		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModify.setBounds(295, 492, 209, 35);
		add(btnModify);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setBounds(560, 110, 209, 35);
		add(btnCreate);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        
		    }
		});
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageUsersController.openCreateUserFrame();
			}
		});

		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageUsersController.openModifyUserFrame(getSelectedUser());
			}

		});
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageUsersController.deleteUser(getSelectedUser());
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageUsersController.search();
			}
		});
	}
	
	@Override
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      btnModify.setText(languageBundle.getString("modify"));
	      btnCreate.setText(languageBundle.getString("create"));
	      btnDelete.setText(languageBundle.getString("delete"));
	      btnSearch.setText(languageBundle.getString("search"));
	  
		}	
	
	public void populate(List<User> usersList) {
        this.usersList = usersList;
		ereaseAll();
		if (usersList == null || usersList.isEmpty()) {
			return;
		}
		for (User user : usersList) {
			Object[] newRow = { user.getName(), user.getSurname(), user.getCnp(), user.getRole() };
			tableModel.addRow(newRow);
		}
		table.setModel(tableModel);
		adminManageUsersController.userSelected(usersList.get(0));

	}
	
	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	private void ereaseAll() {
		eraseTable();
	}

	public User getSelectedUser() {
		return usersList.get(table.getSelectedRow());
	}
	public String getSearchString() {
		return searchTextField.getText();
	}
	
}
