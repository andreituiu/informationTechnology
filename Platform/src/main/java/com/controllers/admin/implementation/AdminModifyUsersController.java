package com.controllers.admin.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminManageUsersController;
import com.controllers.admin.IAdminModifyUserController;
import com.model.Admin;
import com.model.Specialization;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.repository.AdminRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.StudentRepository;
import com.model.repository.TeacherRepository;
import com.model.utils.UserType;
import com.views.admin.ModifyUser;

@Component
public class AdminModifyUsersController implements IAdminModifyUserController {

	private User selectedUser;

	@Autowired
	private ModifyUser adminModifyUsers;

	@Autowired
	private SpecializationRepository specializationRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private StudentRepository studentRepository;

	private Specialization selectedSpecialization;

	@Autowired
	private IAdminManageUsersController adminManageUsersController;

	public AdminModifyUsersController() {
		super();
	}

	@Override
	public void openFrame(User selectedUser) {
		this.selectedUser = selectedUser;
		adminModifyUsers.ereaseAll();
		adminModifyUsers.populateSpecializations(specializationRepository.findAll());
		itemsForSelectedUser();

		adminModifyUsers.setVisible(true);

	}

	@Override
	public void saveUser() {
		if (UserType.ADMIN.getName().equals(selectedUser.getRole())) {
			Admin admin = new Admin();
			admin.setName(adminModifyUsers.getName());
			admin.setSurname(adminModifyUsers.getSurname());
			admin.setCnp(adminModifyUsers.getCNP());
			admin.setInternalEmail(adminModifyUsers.getInternalEmail());
			admin.setExternalEmail(adminModifyUsers.getExternalEmail());
			admin.setPassword(adminModifyUsers.getPassword());

			adminRepository.save(admin);
		} else if (UserType.TEACHER.getName().equals(selectedUser.getRole())) {

			Teacher teacher = new Teacher();
			teacher.setName(adminModifyUsers.getName());
			teacher.setSurname(adminModifyUsers.getSurname());
			teacher.setCnp(adminModifyUsers.getCNP());
			teacher.setInternalEmail(adminModifyUsers.getInternalEmail());
			teacher.setExternalEmail(adminModifyUsers.getExternalEmail());
			teacher.setPassword(adminModifyUsers.getPassword());

			teacherRepository.save(teacher);
		} else {
			Student student = new Student();
			student.setName(adminModifyUsers.getName());
			student.setSurname(adminModifyUsers.getSurname());
			student.setCnp(adminModifyUsers.getCNP());
			student.setInternalEmail(adminModifyUsers.getInternalEmail());
			student.setExternalEmail(adminModifyUsers.getExternalEmail());
			student.setPassword(adminModifyUsers.getPassword());
			student.setStudyYear(adminModifyUsers.getStudyYear());
			student.setSpecialization(selectedSpecialization);
			studentRepository.save(student);
		}
		adminManageUsersController.viewUsers();

	}

	private void itemsForSelectedUser() {
		adminModifyUsers.setRole(selectedUser.getRole());
		adminModifyUsers.setName(selectedUser.getName());
		adminModifyUsers.setSurname(selectedUser.getSurname());
		adminModifyUsers.setCnp(selectedUser.getCnp());
		adminModifyUsers.setExternalEmail(selectedUser.getExternalEmail());
		adminModifyUsers.setInternalEmail(selectedUser.getInternalEmail());
		adminModifyUsers.setPassword(selectedUser.getPassword());
		if (UserType.STUDENT.getName().equals(selectedUser.getRole())) {
			Optional<Student> studentOptional = studentRepository.findById(selectedUser.getCnp());

			if (studentOptional.isPresent() == false) {
				return;
			}

			Student student = studentOptional.get();
			adminModifyUsers.setStudyYear(student.getStudyYear());
			adminModifyUsers.setSpecialization(student.getSpecialization());
		}

	}

	@Override
	public void setAdminModifyUsers(ModifyUser adminModifyUsers) {
		this.adminModifyUsers = adminModifyUsers;
	}

	@Override
	public void selectSpecialization(Specialization selectedSpecialization) {
		this.selectedSpecialization = selectedSpecialization;

	}

}
