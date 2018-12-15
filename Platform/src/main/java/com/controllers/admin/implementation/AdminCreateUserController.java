package com.controllers.admin.implementation;

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
import com.views.admin.CreateUser;

public class AdminCreateUserController implements IAdminCreateUserController {
	

	private CreateUser adminCreateUsers;
	
	private TeacherDAO teacherDAO;
	private StudentDAO studentDAO;
	private AdminDAO adminDAO;
	private UserDAO userDAO;
	
	private final int SELECTED_ADMIN = 0;
	private final int SELECTED_TEACHER = 1;
	private final int SELECTED_STUDENT = 2;
	
	private int selected = SELECTED_STUDENT;
	private String role;
	
	private SpecializationDAO specializationDAO;
	private Specialization selectedSpecialization;

	
	
	public AdminCreateUserController(TeacherDAO teacherDAO, StudentDAO studentDAO, AdminDAO adminDAO, UserDAO userDAO,
			SpecializationDAO specializationDAO) {
		super();
		this.teacherDAO = teacherDAO;
		this.studentDAO = studentDAO;
		this.adminDAO = adminDAO;
		this.userDAO = userDAO;
		this.specializationDAO = specializationDAO;
	}
	
	
	@Override
	public void setAdminCreateUsers(CreateUser adminCreateUsers) {
		this.adminCreateUsers = adminCreateUsers;
	}



	@Override
	public void saveUser() {

		 if(SELECTED_ADMIN == selected) {
			 Admin admin = new Admin();
			 admin.setName(adminCreateUsers.getName());
			 admin.setSurname(adminCreateUsers.getSurname());
			 admin.setCnp(adminCreateUsers.getCNP());
			 admin.setInternalEmail(adminCreateUsers.getInternalEmail());
			 admin.setExternalEmail(adminCreateUsers.getExternalEmail());
			 admin.setPassword(adminCreateUsers.getPassword());
			 
			 adminDAO.save(admin);
		 }
		 else if(SELECTED_TEACHER == selected) {
			 
			 Teacher teacher = new Teacher();
			 teacher.setName(adminCreateUsers.getName());
			 teacher.setSurname(adminCreateUsers.getSurname());
			 teacher.setCnp(adminCreateUsers.getCNP());
			 teacher.setInternalEmail(adminCreateUsers.getInternalEmail());
			 teacher.setExternalEmail(adminCreateUsers.getExternalEmail());
			 teacher.setPassword(adminCreateUsers.getPassword());
			 
			 teacherDAO.save(teacher);
		 }
		 else {
			 Student student = new Student();
			 student.setName(adminCreateUsers.getName());
			 student.setSurname(adminCreateUsers.getSurname());
			 student.setCnp(adminCreateUsers.getCNP());
			 student.setInternalEmail(adminCreateUsers.getInternalEmail());
			 student.setExternalEmail(adminCreateUsers.getExternalEmail());
			 student.setPassword(adminCreateUsers.getPassword());
			 student.setStudyYear(adminCreateUsers.getStudyYear());
			 student.setSpecialization(selectedSpecialization);
			 
			 
			 studentDAO.save(student);
		 }
	}
	
	public void saveU() {
		
		User user = new User();
		user.setName(adminCreateUsers.getName());
		user.setSurname(adminCreateUsers.getSurname());
		user.setCnp(adminCreateUsers.getCNP());

		 if(SELECTED_ADMIN == selected) {

			 user.setRole(role);
			 userDAO.save(user);
		 }
		 else if(SELECTED_TEACHER == selected) {
			 
			 user.setRole(role);
			 userDAO.save(user);
		 }
		 else {
			 	user.setRole(role);
			 	userDAO.save(user);
		 }
	}
	
	
	public void openFrame() {
		adminCreateUsers.ereaseAll();
		adminCreateUsers.populateSpecializations(specializationDAO.getAllSpecializations());
		adminCreateUsers.setVisible(true);
		
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

	@Override
	public void selectSpecialization(Specialization specialization) {
		selectedSpecialization = specialization;
		
	}

}
