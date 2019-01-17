package com.controllers.common.implementation;

import java.net.URL;
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
import com.views.common.Login;

import javafx.fxml.Initializable;

@Component
@Controller
@Configurable
public class LoginController implements ILoginController, Initializable {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
//	
	@Autowired
	private TeacherRepository teacherRepository;
//	
	@Autowired
	private StudentRepository studentRepository;
	
	private Login loginFrame;
//	
	@Autowired
	private IAdminFrameController adminFrameController;

	@Autowired
	private ITeacherFrameController teacherFrameController;
//	
	@Autowired
	private IStudentFrameController studentFrameController;
//	
////	@Autowired
////	private IAdminFrameController adminFrameController;
//
//	@FXML
//	private Button loginButton;
//	
//	@FXML
//	private TextField cnpTF;
//	
//	@FXML
//	private PasswordField passTF;
//	
//	@Autowired
//	private Stage adminStage;

	
//	public LoginController(UserDAO userDAO, AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO,
//			ITeacherFrameController teacherFrameController, IStudentFrameController studentFrameController,
//			IAdminFrameController adminFrameController) {
//		super();
//		this.userRepository = userDAO;
//		this.adminDAO = adminDAO;
//		this.teacherDAO = teacherDAO;
//		this.studentDAO = studentDAO;
//		this.teacherFrameController = teacherFrameController;
//		this.studentFrameController = studentFrameController;
//		this.adminFrameController = adminFrameController;
//	}

	
	

	public LoginController() {
		super();
//		System.out.println(userDAO);
//		System.out.println(userDAO.findAll());
	}




	@Override
	public void setLoginFrame(Login loginFrame) {
		this.loginFrame = loginFrame;
	}





	@Override
	public void login() {
		String cnp = loginFrame.getUserCnp();
		String password = loginFrame.getPassword();

		Optional<User> userResult = userRepository.findById(cnp);
		if (userResult.isPresent() == false) {
			return;
		}
		User user = userResult.get();
		String role = user.getRole();
		if (ROLE.ADMIN.getName().equals(role)) {
			Optional<Admin> adminResult = adminRepository.findById(cnp);
			if(adminResult.isPresent() == false) {
				return;
			}
			Admin admin = adminResult.get();
			if(admin.getPassword().equals(password)) {
				adminFrameController.setAdmin(admin);
				adminFrameController.openFrame();
				loginFrame.setVisible(false);
			}
 		}
		if (ROLE.TEACHER.getName().equals(role)) {
			Optional<Teacher> teacherResult = teacherRepository.findById(cnp);
			if(teacherResult.isPresent() == false) {
				return; 
			}
			Teacher teacher = teacherResult.get();
			if(teacher.getPassword().equals(password)) {
				teacherFrameController.setTeacher(teacher);
				teacherFrameController.openFrame();
				loginFrame.setVisible(false);
			}
		}
		if (ROLE.STUDENT.getName().equals(role)) {
			Optional<Student> studentResult = studentRepository.findById(cnp);
			if(studentResult.isPresent() == false) {
				return;
			}
			Student student = studentResult.get();
			if(student.getPassword().equals(password)) {
				studentFrameController.setStudent(student);
				studentFrameController.openFrame();
				loginFrame.setVisible(false);
			}
		}
	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}




	public void print() {
		System.out.println(userRepository);
	}

}
