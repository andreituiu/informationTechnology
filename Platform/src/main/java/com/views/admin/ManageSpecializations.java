package com.views.admin;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;

import com.controllers.admin.IAdminManageSpecializationsController;
import com.model.Specialization;
import com.views.common.ILanguagePanel;
import java.awt.Font;

public class ManageSpecializations extends JPanel implements ILanguagePanel{
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;
	
	private JButton btnModify;
	private JButton btnCreate;
	
	private List<Specialization> specializationsList;
	
	private String[] tableColumns = {"Name"};
	protected IAdminManageSpecializationsController adminManageSpecializationsController;
	
	public ManageSpecializations(IAdminManageSpecializationsController adminManageSpecializationsController) {
		setBackground(new Color(215, 228, 242));
		this.adminManageSpecializationsController = adminManageSpecializationsController;
		initialize();
	}
	public void initialize() {
		
		setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);
		
		tablePanel.setLayout(null);
		
		tablePanel.setPreferredSize(new Dimension(536, 246));
		
		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(tableModel);
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(23, 28, 503, 449);
		add(scrollPanel);
		
		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModify.setBounds(163, 489, 209, 35);
		add(btnModify);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setBounds(565, 28, 209, 35);
		add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageSpecializationsController.openCreateSpecializationFrame();
			}
		});

		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageSpecializationsController.openModifySpecializationFrame(getSelectedSpecialization());
			}
		});

//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (adminManageSpecializationsController != null) {
//					adminManageSpecializationsController.specializationSelected(getSelectedSpecialization());
//				}
//			}
//		});
		
	}
	
	@Override
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      btnModify.setText(languageBundle.getString("modify"));
	      btnCreate.setText(languageBundle.getString("create"));
	  
	  
		}	

	public void populate(List<Specialization> specializationsList) {
        this.specializationsList = specializationsList;
		ereaseAll();
		if (specializationsList == null || specializationsList.isEmpty()) {
			return;
		}
		for (Specialization specialization : specializationsList) {
			Object[] newRow = { specialization.getName() };
			tableModel.addRow(newRow);
		}

	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	private void ereaseAll() {
		eraseTable();
	}

	public Specialization getSelectedSpecialization() {
		return specializationsList.get(table.getSelectedRow());
	}

}
