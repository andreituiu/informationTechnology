package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.controllers.admin.IAdminModifyUserController;
import com.model.Admin;
import com.model.Specialization;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.utils.UserType;
import com.views.admin.ModifyUser;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminModifyUsersController implements IAdminModifyUserController {

	private User selectedUser;
	
	private ModifyUser adminModifyUsers;

	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private TeacherDAO teacherDAO;

	@Autowired
	private StudentDAO studentDAO;
	
	private final int SELECTED_ADMIN = 0;
	private final int SELECTED_TEACHER = 1;
	private final int SELECTED_STUDENT = 2;

	private int selected;
	private String role;

	private SpecializationDAO specializationDAO;

//	@Autowired
	private Stage modifyUserStage;

	private User user;
	
	@FXML
	private TextField cnpTF;
		
	@FXML
	private RadioButton adminRBtn;
	
	@FXML
	private RadioButton teacherRBtn;
	
	@FXML
	private RadioButton studentRBtn;

	@FXML
	private TextField passwordTF;
	
	@Override
	public void selectSpecialization(Specialization specialization) {
		// TODO Auto-generated method stub
		
	}
	
//	public void openFrame() {
//		adminModifyUsers.ereaseAll();
//		
//		if(SELECTED_STUDENT == selected) {
//			adminModifyUsers.populateSpecializations(specializationDAO.getAllSpecializations());
//		}
//
//		itemsForSelectedUser();
//		adminModifyUsers.setVisible(true);
//		
//		
//	}
	@Override
	public void saveUser() {
		
			 
			//adminDAO.(selectedUser.);
		
			 
		   //  teacherDAO.updateUser(selectedUser);
	
			 
			//studentDAO.getStudent(selectedUser.getCnp());
		 
		
	}
	
	public void saveU() {
		
		selectedUser.setName(adminModifyUsers.getName());
		selectedUser.setSurname(adminModifyUsers.getSurname());
		selectedUser.setCnp(adminModifyUsers.getCNP());
		//selectedUser.setRole(adminModifyUsers.getRole());
	}

	@Override
	public void selectAdmin() {
		selected = SELECTED_ADMIN;
		role = "admin";
		
	}

	@Override
	public void selectStudent() {
		selected = SELECTED_STUDENT;
		role = "student";
	}

	@Override
	public void selectTeacher() {
		selected = SELECTED_TEACHER;
		role ="teacher";
		
	}
	
	private void itemsForSelectedUser() {
		adminModifyUsers.setName(selectedUser.getName());
		adminModifyUsers.setSurname(selectedUser.getSurname());
		adminModifyUsers.setCnp(selectedUser.getCnp());
		adminModifyUsers.setRole(selectedUser.getRole());
		
	}

//	@Qualifier("modifyUserStage")
//	@Autowired
	public void setStage(Stage stage) {
		this.modifyUserStage = stage;
	}
	
	public void openFrame() {
		modifyUserStage.show();
	}

	public void setUser(User user) {
		
		this.user = user;
		cnpTF.setText(user.getCnp());
		if (UserType.ADMIN.getName().equals(user.getRole())) {
			Admin admin = adminDAO.findByID(user.getCnp());
			adminRBtn.setSelected(true);
		} else if (UserType.TEACHER.getName().equals(user.getRole())) {
			Teacher teacher = teacherDAO.findByID(user.getCnp());
			teacherRBtn.setSelected(true);
		} else if (UserType.STUDENT.getName().equals(user.getRole())) {
			Student student = studentDAO.findByID(user.getCnp());
			studentRBtn.setSelected(true);
		}
	}
	
	public void clearFields() {
		cnpTF.setText("");
		passwordTF.setText("");
	}
	
	public void updateUser() {
//		user.setCnp(cnpTF.getText());
		user.setPassword(passwordTF.getText());
		if (UserType.ADMIN.getName().equals(user.getRole())) {
			Admin admin = adminDAO.findByID(user.getCnp());
//			admin.setCnp(user.getCnp());
			admin.setPassword(user.getPassword());
			adminDAO.update(admin);
		} else if (UserType.TEACHER.getName().equals(user.getRole())) {
			Teacher teacher = teacherDAO.findByID(user.getCnp());
			teacherRBtn.setSelected(true);
		} else if (UserType.STUDENT.getName().equals(user.getRole())) {
			Student student = studentDAO.findByID(user.getCnp());
			studentRBtn.setSelected(true);
		}
	}
}
