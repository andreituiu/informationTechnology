package com.controllers.common.implementation;

import com.controllers.admin.IAdminFrameController;
import com.controllers.common.ILoginController;
import com.controllers.student.IStudentFrameController;
import com.controllers.teacher.ITeacherFrameController;
import com.model.Admin;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.dao.UserDAO;
import com.views.common.Login;

public class LoginController implements ILoginController {

	private UserDAO userDAO;
	private AdminDAO adminDAO;
	private TeacherDAO teacherDAO;
	private StudentDAO studentDAO;
	private Login loginFrame;
	private IStudentFrameController studentFrameController;
	private ITeacherFrameController teacherFrameController;
	private IAdminFrameController adminFrameController;

	
	
	public LoginController(UserDAO userDAO, AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO,
			ITeacherFrameController teacherFrameController, IStudentFrameController studentFrameController,
			IAdminFrameController adminFrameController) {
		super();
		this.userDAO = userDAO;
		this.adminDAO = adminDAO;
		this.teacherDAO = teacherDAO;
		this.studentDAO = studentDAO;
		this.teacherFrameController = teacherFrameController;
		this.studentFrameController = studentFrameController;
		this.adminFrameController = adminFrameController;
	}

	
	

	@Override
	public void setLoginFrame(Login loginFrame) {
		this.loginFrame = loginFrame;
	}





	@Override
	public void login() {
		String cnp = loginFrame.getUserCnp();
		String password = loginFrame.getPassword();

		User user = userDAO.getUser(cnp);
		if (user == null) {
			return;
		}

		String role = user.getRole();
		if (ROLE.ADMIN.getName().equals(role)) {
			Admin admin = adminDAO.getAdmin(cnp);
			if(admin.getPassword().equals(password)) {
				adminFrameController.setAdmin(admin);
				adminFrameController.setUser(user);
				adminFrameController.openFrame();
				loginFrame.setVisible(false);
			}
 		}
		if (ROLE.TEACHER.getName().equals(role)) {
			Teacher teacher = teacherDAO.getTeacher(cnp);
			if(teacher.getPassword().equals(password)) {
				teacherFrameController.setTeacher(teacher);
				teacherFrameController.setUser(user);
				teacherFrameController.openFrame();
				loginFrame.setVisible(false);
			}
		}
		if (ROLE.STUDENT.getName().equals(role)) {
			Student student = studentDAO.getStudent(cnp);
			if(student.getPassword().equals(password)) {
				studentFrameController.setStudent(student);
				studentFrameController.setUser(user);
				studentFrameController.openFrame();
				loginFrame.setVisible(false);
			}
		}
	}

}
