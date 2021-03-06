package com.controllers.common.implementation;

import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.controllers.admin.IAdminFrameController;
import com.controllers.common.ILoginController;
import com.controllers.student.IStudentFrameController;
import com.controllers.teacher.ITeacherFrameController;
import com.model.Admin;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.repository.AdminRepository;
import com.model.repository.StudentRepository;
import com.model.repository.TeacherRepository;
import com.model.repository.UserRepository;
import com.model.utils.UserType;
import com.views.common.Login;

@Component
@Controller
@Configurable
public class LoginController implements ILoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	private Login loginFrame;

	@Autowired
	private IAdminFrameController adminFrameController;

	@Autowired
	private ITeacherFrameController teacherFrameController;

	@Autowired
	private IStudentFrameController studentFrameController;

	public LoginController() {
		super();
	}

	@Override
	public void setLoginFrame(Login loginFrame) {
		this.loginFrame = loginFrame;
	}

	@Override
	public void login() {
		String cnp = loginFrame.getUserCnp();
		String password = loginFrame.getPassword();
		ResourceBundle languageBundle = loginFrame.getLanguageBundle();
		String message = "User or password are incorect";
		if (languageBundle != null) {
			message = languageBundle.getString("user.notFound");
		}
		Optional<User> userResult = userRepository.findById(cnp);
		if (userResult.isPresent() == false) {
			loginFrame.showPopup(message);
			return;
		}
		User user = userResult.get();
		String role = user.getRole();
		if (UserType.ADMIN.getName().equals(role)) {
			Optional<Admin> adminResult = adminRepository.findById(cnp);
			if (adminResult.isPresent() == false) {
				loginFrame.showPopup(message);
				return;
			}
			Admin admin = adminResult.get();
			if (admin.getPassword().equals(password)) {
				adminFrameController.setAdmin(admin);
				adminFrameController.openFrame();
				loginFrame.setVisible(false);
			} else {
				loginFrame.showPopup(message);
			}
		}
		if (UserType.TEACHER.getName().equals(role)) {
			Optional<Teacher> teacherResult = teacherRepository.findById(cnp);
			if (teacherResult.isPresent() == false) {
				loginFrame.showPopup(message);
				return;
			}
			Teacher teacher = teacherResult.get();
			if (teacher.getPassword().equals(password)) {
				teacherFrameController.setTeacher(teacher);
				teacherFrameController.openFrame();
				loginFrame.setVisible(false);
			} else {
				loginFrame.showPopup(message);
			}
		}
		if (UserType.STUDENT.getName().equals(role)) {
			Optional<Student> studentResult = studentRepository.findById(cnp);
			if (studentResult.isPresent() == false) {
				loginFrame.showPopup(message);
				return;
			}
			Student student = studentResult.get();
			if (student.getPassword().equals(password)) {
				studentFrameController.setStudent(student);
				studentFrameController.openFrame();
				loginFrame.setVisible(false);
			} else {
				loginFrame.showPopup(message);
			}
		}
	}

}
