package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.controllers.common.IEmailPanelController;
import com.controllers.common.implementation.EmailPanelController;
import com.controllers.student.IStudentCoursesPanelController;
import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.controllers.student.IStudentFindCoursePannelController;
import com.controllers.student.IStudentHeaderController;
import com.controllers.student.IStudentProfileInformationPanelController;
import com.controllers.student.implementation.StudentCoursesPanelController;
import com.controllers.student.implementation.StudentEnrolledCoursesPanelController;
import com.controllers.student.implementation.StudentFindCoursePannelController;
import com.controllers.student.implementation.StudentHeaderController;
import com.controllers.student.implementation.StudentProfileInformationPanelController;
import com.model.Course;
import com.model.Mail;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.User;
import com.model.dao.AssignmentDAO;
import com.model.dao.CourseDAO;
import com.model.dao.MailDAO;
import com.model.dao.StudentDAO;
import com.model.dao.implementation.AssignmentDAOImpl;
import com.model.dao.implementation.CourseDAOImpl;
import com.model.dao.implementation.MailDAOImpl;
import com.model.dao.implementation.StudentDAOImpl;
import com.model.mapper.AssignmentMapper;
import com.model.mapper.CourseMapper;
import com.model.mapper.MailMapper;
import com.model.mapper.StudentAssignmentMapper;
import com.model.mapper.TeacherMapper;
import com.views.common.MailPanel;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentEnrolledCoursesPanel;
import com.views.student.StudentFindCoursePannel;
import com.views.student.StudentFrame;
import com.views.student.StudentHeader;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/se";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	private StudentFrame studentFrame;
	private IEmailPanelController emailPanelController;
	private IStudentCoursesPanelController studentCoursesPanelController;
	private Connection connection;

	public void run() {
		initConn();
//		init();
		 initialize();
		 studentFrame.setVisible(true);
	}

	private void initConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		CourseDAO courseDAO = new CourseDAOImpl(factory);
		StudentDAO studentDAO = new StudentDAOImpl(factory);
		MailDAO mailDAO = new MailDAOImpl(new MailMapper(), connection);

		mailDAO.sendMail(new Mail("1", "2", "subj", "message"));
		// Student student = studentDAO.getStudent("1");
		// List<Course> enrolledCourses = courseDAO.getEnrolledCourses(student);
		// courseDAO.getAllCourses();
		// System.out.println(enrolledCourses.size());

	}

	private void initialize() {
	    TeacherMapper teacherMapper = new TeacherMapper();
        CourseMapper courseMapper = new CourseMapper(teacherMapper);
        AssignmentMapper assignmetMapper = new AssignmentMapper();
		StudentAssignmentMapper studentAssignmentsMapper = new StudentAssignmentMapper(assignmetMapper);

        StudentProfileInformationPanel studentProfilePanel = new StudentProfileInformationPanel();
		
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
		StudentDAO studentDAO = new StudentDAOImpl(factory);
        CourseDAO coursesDAO = new CourseDAOImpl(courseMapper,connection);
		MailDAO mailDAO = new MailDAOImpl(new MailMapper(), connection);
		AssignmentDAO assignmentDAO = new AssignmentDAOImpl(studentAssignmentsMapper, connection);
		
		User user = new User();
		Student student = studentDAO.getStudent("1");
		if (student != null) {
			System.out.println(student.getCnp());
		} else {
			System.out.println("student not found");
		}
		// System.out.println(coursesDAO.getAllCourses().get(0).getAssignments().size());
		IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController = new StudentEnrolledCoursesPanelController(
				coursesDAO, assignmentDAO, student);
		IStudentFindCoursePannelController studentFindCoursePannelController = new StudentFindCoursePannelController(
				coursesDAO);
		studentCoursesPanelController = new StudentCoursesPanelController(studentFindCoursePannelController,
				studentEnrolledCoursesPanelController);
		StudentFindCoursePannel studentFindCoursePannel = new StudentFindCoursePannel(
				studentFindCoursePannelController);
		studentFindCoursePannelController.setStudentFindCoursePannel(studentFindCoursePannel);

		IStudentProfileInformationPanelController studentProfilePanelController = new StudentProfileInformationPanelController(
				student);
		
		emailPanelController = new EmailPanelController(mailDAO, user);
		MailPanel emailPanel = new MailPanel(emailPanelController);
		
		IStudentHeaderController studentHeaderController = new StudentHeaderController(studentProfilePanelController,
				studentCoursesPanelController, emailPanelController);
		StudentHeader studentHeader = new StudentHeader(studentHeaderController);
		StudentPanel studentPanel = new StudentPanel(studentHeader, studentProfilePanel);

		StudentEnrolledCoursesPanel enrolledCoursesPanel = new StudentEnrolledCoursesPanel(
				studentEnrolledCoursesPanelController);
		StudentCoursesPanel studentCoursesPanel = new StudentCoursesPanel(studentCoursesPanelController,
				studentFindCoursePannel, enrolledCoursesPanel);

		emailPanelController.setMailPanel(emailPanel);
		emailPanelController.setStudentPanel(studentPanel);
		studentCoursesPanelController.setStudentPanel(studentPanel);
		studentCoursesPanelController.setStudentCoursesPanel(studentCoursesPanel);
		studentEnrolledCoursesPanelController.setStudentEnrolledCoursesPanel(enrolledCoursesPanel);
		studentProfilePanelController.setStudentPanel(studentPanel);
		studentProfilePanelController.setStudentProfileInformationPanel(studentProfilePanel);

		studentFrame = new StudentFrame(studentPanel);
	}

}
