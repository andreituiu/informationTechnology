package com.controllers.admin.implementation;

import javax.management.relation.Role;

import com.controllers.admin.IAdminModifyUserController;
import com.controllers.common.implementation.ROLE;
import com.model.Admin;
import com.model.Specialization;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.views.admin.ModifyUser;

public class AdminModifyUsersController implements IAdminModifyUserController {

	private User selectedUser;
	
	private ModifyUser adminModifyUsers;

	private AdminDAO adminDAO;

	private TeacherDAO teacherDAO;

	private StudentDAO studentDAO;
	
	private ROLE selected = ROLE.STUDENT;
	private String role;

	private SpecializationDAO specializationDAO;
	
	
	
	public AdminModifyUsersController(AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO,
			SpecializationDAO specializationDAO) {
		super();
		this.adminDAO = adminDAO;
		this.teacherDAO = teacherDAO;
		this.studentDAO = studentDAO;
		this.specializationDAO = specializationDAO;
	}
	@Override
	public void openFrame(User selectedUser) {
		this.selectedUser = selectedUser;
		adminModifyUsers.ereaseAll();
		adminModifyUsers.populateSpecializations(specializationDAO.getAllSpecializations());
		itemsForSelectedUser();
		

		adminModifyUsers.setVisible(true);
		
		
	}
	@Override
	public void saveUser() {
		 if(ROLE.ADMIN == selected) {
			 Admin admin = new Admin();
			 admin.setName(adminModifyUsers.getName());
			 admin.setSurname(adminModifyUsers.getSurname());
			 admin.setCnp(adminModifyUsers.getCNP());
			 admin.setInternalEmail(adminModifyUsers.getInternalEmail());
			 admin.setExternalEmail(adminModifyUsers.getExternalEmail());
			 admin.setPassword(adminModifyUsers.getPassword());
			 
			 adminDAO.save(admin);
		 }
		 else if(ROLE.TEACHER == selected) {
			 
			 Teacher teacher = new Teacher();
			 teacher.setName(adminModifyUsers.getName());
			 teacher.setSurname(adminModifyUsers.getSurname());
			 teacher.setCnp(adminModifyUsers.getCNP());
			 teacher.setInternalEmail(adminModifyUsers.getInternalEmail());
			 teacher.setExternalEmail(adminModifyUsers.getExternalEmail());
			 teacher.setPassword(adminModifyUsers.getPassword());
			 
			 teacherDAO.save(teacher);
		 }
		 else {
			 Student student = new Student();
			 student.setName(adminModifyUsers.getName());
			 student.setSurname(adminModifyUsers.getSurname());
			 student.setCnp(adminModifyUsers.getCNP());
			 student.setInternalEmail(adminModifyUsers.getInternalEmail());
			 student.setExternalEmail(adminModifyUsers.getExternalEmail());
			 student.setPassword(adminModifyUsers.getPassword());
			 student.setStudyYear(adminModifyUsers.getStudyYear());
			 
			 
			 studentDAO.save(student);
		 }
	}
	
	private void itemsForSelectedUser() {
		
		if(selectedUser.getRole().equals(ROLE.ADMIN.getName())) {
			Admin admin = adminDAO.getAdmin(selectedUser.getCnp());
		
			adminModifyUsers.setName(admin.getName());
			adminModifyUsers.setSurname(admin.getSurname());
			adminModifyUsers.setCnp(admin.getCnp());
			adminModifyUsers.setExternalEmail(admin.getExternalEmail());
			adminModifyUsers.setInternalEmail(admin.getInternalEmail());
			adminModifyUsers.setPassword(admin.getPassword());
			adminModifyUsers.setRole(ROLE.ADMIN);
			selected = ROLE.ADMIN;
		}
		else if (selectedUser.getRole().equals(ROLE.TEACHER.getName())) {
			Teacher teacher = teacherDAO.getTeacher(selectedUser.getCnp());
		
			adminModifyUsers.setName(teacher.getName());
			adminModifyUsers.setSurname(teacher.getSurname());
			adminModifyUsers.setCnp(teacher.getCnp());
			adminModifyUsers.setExternalEmail(teacher.getExternalEmail());
			adminModifyUsers.setInternalEmail(teacher.getInternalEmail());
			adminModifyUsers.setPassword(teacher.getPassword());
			adminModifyUsers.setRole(ROLE.TEACHER);
			selected = ROLE.TEACHER;
		}
		else {
			Student student = studentDAO.getStudent(selectedUser.getCnp());

			adminModifyUsers.setName(student.getName());
			adminModifyUsers.setSurname(student.getSurname());
			adminModifyUsers.setCnp(student.getCnp());
			adminModifyUsers.setExternalEmail(student.getExternalEmail());
			adminModifyUsers.setInternalEmail(student.getInternalEmail());
			adminModifyUsers.setPassword(student.getPassword());
			adminModifyUsers.setStudyYear(student.getStudyYear());
			adminModifyUsers.setSpecialization(student.getSpecialization());
			adminModifyUsers.setRole(ROLE.STUDENT);
			selected = ROLE.STUDENT;
		}
		
	}
	
	@Override
	public void setAdminModifyUsers(ModifyUser adminModifyUsers) {
		this.adminModifyUsers = adminModifyUsers;
	}

	
}
