package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateUserController;
import com.controllers.admin.IAdminManageUsersController;
import com.model.Admin;
import com.model.Specialization;
import com.model.Student;
import com.model.Teacher;
import com.model.repository.SpecializationRepository;
import com.model.repository.UserRepository;
import com.model.utils.UserType;
import com.utils.GeneratorUtil;
import com.views.admin.CreateUser;

@Component
public class AdminCreateUserController implements IAdminCreateUserController{
	
	@Autowired
	private CreateUser adminCreateUsers;
	@Autowired
	private UserRepository userRepository;
	private UserType selected;
	
	@Autowired
	private SpecializationRepository specializationRepository;
	private Specialization selectedSpecialization;

	@Autowired
	private IAdminManageUsersController adminManageUsersController;
	
	@Autowired
	private GeneratorUtil generatorUtil;
	
	
	
	public AdminCreateUserController() {
		super();
	}



	@Override
	public void setAdminCreateUsers(CreateUser adminCreateUsers) {
		this.adminCreateUsers = adminCreateUsers;
	}


	@Override
	public void saveUser() {
		String cnp = adminCreateUsers.getCNP();
		if(userRepository.existsById(cnp)) {
			String message = "User already exists";
			if(adminCreateUsers.getLanguageBundle() != null) {
				message = adminCreateUsers.getLanguageBundle().getString("user.alreadyExists");
			}
			adminCreateUsers.showPopup(message);
			return;
		}
		String password = generatorUtil.generatePassword();
		if(UserType.ADMIN == selected) {
			 Admin admin = new Admin();
			 admin.setName(adminCreateUsers.getName());
			 admin.setSurname(adminCreateUsers.getSurname());
			 admin.setCnp(adminCreateUsers.getCNP());
			 admin.setInternalEmail(adminCreateUsers.getInternalEmail());
			 admin.setExternalEmail(adminCreateUsers.getExternalEmail());
			 admin.setPassword(password);
			 userRepository.save(admin);
		 }
		 else if(UserType.TEACHER == selected) {
			 
			 Teacher teacher = new Teacher();
			 teacher.setName(adminCreateUsers.getName());
			 teacher.setSurname(adminCreateUsers.getSurname());
			 teacher.setCnp(adminCreateUsers.getCNP());
			 teacher.setInternalEmail(adminCreateUsers.getInternalEmail());
			 teacher.setExternalEmail(adminCreateUsers.getExternalEmail());
			 teacher.setPassword(password);
			 userRepository.save(teacher);
		 }
		 else {
			 Student student = new Student();
			 student.setName(adminCreateUsers.getName());
			 student.setSurname(adminCreateUsers.getSurname());
			 student.setCnp(adminCreateUsers.getCNP());
			 student.setInternalEmail(adminCreateUsers.getInternalEmail());
			 student.setExternalEmail(adminCreateUsers.getExternalEmail());
			 student.setPassword(password);
			 student.setStudyYear(adminCreateUsers.getStudyYear());
			 student.setSpecialization(selectedSpecialization);
			 userRepository.save(student);
		 }
		String message = "User created with password: " + password;
		if(adminCreateUsers.getLanguageBundle() != null) {
			message = adminCreateUsers.getLanguageBundle().getString("user.created.password") + ": " + password;
		}
		adminCreateUsers.showPopup(message);
		adminManageUsersController.viewUsers();
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
	public void updateInternalEmail() {
		String cnp = adminCreateUsers.getCNP();
		String name = adminCreateUsers.getName();
		String generatedInternalEmail = generatorUtil.generateInternalEmail(cnp, name);
		adminCreateUsers.setInternalEmail(generatedInternalEmail);
	}


}
