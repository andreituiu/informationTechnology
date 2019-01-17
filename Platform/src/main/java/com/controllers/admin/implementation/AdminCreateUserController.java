package com.controllers.admin.implementation;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateUserController;
import com.model.Admin;
import com.model.Specialization;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.dao.UserDAO;
import com.model.repository.AdminRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.StudentRepository;
import com.model.repository.TeacherRepository;
import com.model.repository.UserRepository;
import com.model.utils.UserType;
import com.views.admin.CreateUser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

@Component
public class AdminCreateUserController implements IAdminCreateUserController, Initializable{
	
	@Autowired
	private CreateUser adminCreateUsers;
//	
	@Autowired
	private TeacherRepository teacherRepository;
//	
	@Autowired
	private StudentRepository studentRepository;
//	
	@Autowired
	private AdminRepository adminRepository;
//	
	@Autowired
	private UserRepository userRepository;
//
	private UserType selected;
//	private String role;
//	
	@Autowired
	private SpecializationRepository specializationRepository;
	private Specialization selectedSpecialization;
//
//	@FXML
//	private TextField cnpTF;
//	
//	@FXML
//	private TextField nameTF;
//	
//	@FXML
//	private TextField passwordTF;
//	
//	@FXML
//	private TextField yearTF;
//	
//	@FXML
//	private ComboBox<Specialization> specializationCmb;
	
	public AdminCreateUserController(TeacherDAO teacherDAO, StudentDAO studentDAO, AdminDAO adminDAO, UserDAO userDAO,
			SpecializationDAO specializationDAO) {
		super();
//		this.teacherRepository = teacherDAO;
//		this.studentRepository = studentDAO;
//		this.adminRepository = adminDAO;
//		this.userRepository = userDAO;
//		this.specializationRepository = specializationDAO;
	}
	
	
	
	public AdminCreateUserController() {
		super();
	}



	@Override
	public void setAdminCreateUsers(CreateUser adminCreateUsers) {
		this.adminCreateUsers = adminCreateUsers;
	}


	@Override
	public void saveUser() {

		 if(UserType.ADMIN == selected) {
			 Admin admin = new Admin();
			 admin.setName(adminCreateUsers.getName());
			 admin.setSurname(adminCreateUsers.getSurname());
			 admin.setCnp(adminCreateUsers.getCNP());
			 admin.setInternalEmail(adminCreateUsers.getInternalEmail());
			 admin.setInternalEmail(adminCreateUsers.getExternalEmail());
			 admin.setPassword(adminCreateUsers.getPassword());
			 userRepository.save(admin);
		 }
		 else if(UserType.TEACHER == selected) {
			 
			 Teacher teacher = new Teacher();
			 teacher.setName(adminCreateUsers.getName());
			 teacher.setSurname(adminCreateUsers.getSurname());
			 teacher.setCnp(adminCreateUsers.getCNP());
			 teacher.setInternalEmail(adminCreateUsers.getInternalEmail());
			 teacher.setInternalEmail(adminCreateUsers.getExternalEmail());
			 teacher.setPassword(adminCreateUsers.getPassword());
			 userRepository.save(teacher);
		 }
		 else {
			 Student student = new Student();
			 
			 student.setName(adminCreateUsers.getName());
			 student.setSurname(adminCreateUsers.getSurname());
			 student.setCnp(adminCreateUsers.getCNP());
			 student.setInternalEmail(adminCreateUsers.getInternalEmail());
			 student.setInternalEmail(adminCreateUsers.getExternalEmail());
			 student.setPassword(adminCreateUsers.getPassword());
			 student.setStudyYear(adminCreateUsers.getStudyYear());
			 student.setSpecialization(selectedSpecialization);
			 
			 
			 userRepository.save(student);
		 }
	}
	
	public void saveU() {
		
		User user = new User();
		user.setName(adminCreateUsers.getName());
		user.setSurname(adminCreateUsers.getSurname());
		user.setCnp(adminCreateUsers.getCNP());

		user.setRole(selected.getName());
		userRepository.save(user);
//		 if(UserType.ADMIN == selected) {
//
//		 }
//		 else if(UserType.TEACHER == selected) {
//			 
//			 user.setRole(role);
//			 userRepository.save(user);
//		 }
//		 else {
//			 	user.setRole(role);
//			 	userRepository.save(user);
//		 }
	}
	
	
	public void openFrame() {
		adminCreateUsers.ereaseAll();
		adminCreateUsers.populateSpecializations(specializationRepository.findAll());
		adminCreateUsers.setVisible(true);
		
	}

	@Override
	public void selectAdmin() {
		selected = UserType.ADMIN;
		
	}

	@Override
	public void selectStudent() {
		selected = UserType.STUDENT;
	}

	@Override
	public void selectTeacher() {
		selected = UserType.TEACHER;
	}

	@Override
	public void selectSpecialization(Specialization specialization) {
		selectedSpecialization = specialization;
		
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
