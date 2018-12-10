package com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;

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
import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.controllers.teacher.ITeacherHeaderController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.controllers.teacher.implementation.TeacherCoursePanelController;
import com.controllers.teacher.implementation.TeacherCreateAssignmentFrameController;
import com.controllers.teacher.implementation.TeacherHeaderController;
import com.controllers.teacher.implementation.TeacherManageAssignmentsPanelController;
import com.controllers.teacher.implementation.TeacherManageStudentsPanelController;
import com.controllers.teacher.implementation.TeacherProfileInformationPanelController;
import com.model.Course;
import com.model.Mail;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.Teacher;
import com.model.User;
import com.model.dao.AssignmentDAO;
import com.model.dao.CourseDAO;
import com.model.dao.MailDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.dao.implementation.AssignmentDAOImpl;
import com.model.dao.implementation.CourseDAOImpl;
import com.model.dao.implementation.MailDAOImpl;
import com.model.dao.implementation.StudentDAOImpl;
import com.model.dao.implementation.TeacherDAOImpl;
import com.model.mapper.AssignmentMapper;
import com.model.mapper.CourseMapper;
import com.model.mapper.MailMapper;
import com.model.mapper.StudentAssignmentMapper;
import com.model.mapper.StudentMapper;
import com.model.mapper.TeacherMapper;
import com.views.common.ISupportPanel;
import com.views.common.MailPanel;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentEnrolledCoursesPanel;
import com.views.student.StudentFindCoursePannel;
import com.views.student.StudentFrame;
import com.views.student.StudentHeader;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;
import com.views.teacher.TeacherCoursesPanel;
import com.views.teacher.TeacherCreateAssignmentFrame;
import com.views.teacher.TeacherFrame;
import com.views.teacher.TeacherHeader;
import com.views.teacher.TeacherManageAssignmentsPanel;
import com.views.teacher.TeacherManageStudentsPanel;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;
import com.views.teacher.TeacherStudentsTablePanel;

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
	private IEmailPanelController emailPanelControllerTeacher;
	private IEmailPanelController emailPanelControllerStudent;
	private IStudentCoursesPanelController studentCoursesPanelController;
	private Connection connection;
	private TeacherFrame teacherFrame;
	private MailDAO mailDAO;
	private CourseDAO coursesDAO;
	private StudentDAO studentDAO;
	private TeacherDAO teacherDAO;
	private AssignmentDAO assignmentDAO;

	private CourseMapper courseMapper;
	private TeacherMapper teacherMapper;
	private StudentMapper studentMapper;
	private StudentAssignmentMapper studentAssignmentsMapper;
	private AssignmentMapper assignmetMapper;

	public void run() {
		initConn();
		initMappers();
		initDAO();
//		init();
//		 initialize();
		initStudent();
		initTeacher();
		teacherFrame.setVisible(true);
		studentFrame.setVisible(true);
	}


	private void initMappers() {
		studentMapper = new StudentMapper();
		teacherMapper = new TeacherMapper();
		assignmetMapper = new AssignmentMapper();
		courseMapper = new CourseMapper(teacherMapper);
		studentAssignmentsMapper = new StudentAssignmentMapper(assignmetMapper);
	}

	private void initDAO() {
		studentDAO = new StudentDAOImpl(studentMapper, connection);
        coursesDAO = new CourseDAOImpl(courseMapper,connection);
		mailDAO = new MailDAOImpl(new MailMapper(), connection);
		teacherDAO = new TeacherDAOImpl(teacherMapper, connection);
		assignmentDAO = new AssignmentDAOImpl(assignmetMapper, studentAssignmentsMapper, connection);
	}

	private void initTeacher() {
		User user = new User();
		Teacher teacher = teacherDAO.getTeacher("123");
		
		emailPanelControllerTeacher = new EmailPanelController(mailDAO, user);
		
		ITeacherProfileInformationPanelController teacherProfilePanelController = new TeacherProfileInformationPanelController(teacher);
		
		ITeacherManageStudentsPanelController teacherManageStudentsPanelController = new TeacherManageStudentsPanelController(studentDAO);
		ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController = new TeacherCreateAssignmentFrameController(assignmentDAO);
		ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelConttoller = new TeacherManageAssignmentsPanelController(studentDAO, assignmentDAO, teacherCreateAssignmentFrameController);
		ITeacherCoursePanelController teacherCoursesPanelController = new TeacherCoursePanelController(teacher, coursesDAO, teacherManageStudentsPanelController, teacherManageAssignmentsPanelConttoller);
		
		ITeacherHeaderController teacherHeaderController = new TeacherHeaderController(teacherProfilePanelController, teacherCoursesPanelController, emailPanelControllerTeacher);
		
		MailPanel mailPanel = new MailPanel(emailPanelControllerTeacher);
		
		TeacherStudentsTablePanel waitingStudentsTablePanel = new TeacherStudentsTablePanel();
		TeacherStudentsTablePanel enrolledStudentsTablePanel = new TeacherStudentsTablePanel();
		TeacherStudentsTablePanel studentsTablePanel = new TeacherStudentsTablePanel(teacherManageAssignmentsPanelConttoller);
		TeacherManageStudentsPanel teacherManageStudentsPanel = new TeacherManageStudentsPanel(teacherManageStudentsPanelController, waitingStudentsTablePanel, enrolledStudentsTablePanel);
		TeacherManageAssignmentsPanel teacherManageAssignmentsPanel = new TeacherManageAssignmentsPanel(teacherManageAssignmentsPanelConttoller, studentsTablePanel);
		
		TeacherCreateAssignmentFrame teacherCreateAssignmentFrame = new TeacherCreateAssignmentFrame(teacherCreateAssignmentFrameController);

		TeacherCoursesPanel teacherCoursePanel = new TeacherCoursesPanel(teacherCoursesPanelController, teacherManageStudentsPanel, teacherManageAssignmentsPanel);

		TeacherHeader teacherHeader = new TeacherHeader(teacherHeaderController);
		TeacherProfileInformationPanel teacherProfileInformationPanel = new TeacherProfileInformationPanel();
		TeacherPanel teacherPanel = new TeacherPanel(teacherHeader, teacherProfileInformationPanel);
		teacherFrame = new TeacherFrame(teacherPanel);
		
		teacherManageAssignmentsPanelConttoller.setTeacherManageAssignmentsPanel(teacherManageAssignmentsPanel);
		
		teacherManageStudentsPanelController.setTeacherManageStudentsPanel(teacherManageStudentsPanel);

		teacherCoursesPanelController.setTeacherCoursePanel(teacherCoursePanel);
		teacherCoursesPanelController.setTeacherPanel(teacherPanel);
		
		teacherProfilePanelController.setTeacherPanel(teacherPanel);
		teacherProfilePanelController.setTeacherProfileInformationPanel(teacherProfileInformationPanel);
		
		teacherCreateAssignmentFrameController.setTeacherCreateAssignmentFrame(teacherCreateAssignmentFrame);
		
		emailPanelControllerTeacher.setMailPanel(mailPanel);
		emailPanelControllerTeacher.setSupportPanel(teacherPanel);
	
	}

	private void initConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

	private void initStudent() {
		User user = new User();
		Student student = studentDAO.getStudent("1");
		IStudentProfileInformationPanelController studentProfilePanelController = new StudentProfileInformationPanelController(student);
		
		IStudentFindCoursePannelController studentFindCoursePannelController = new StudentFindCoursePannelController(student, coursesDAO, studentDAO);
		IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController = new StudentEnrolledCoursesPanelController(coursesDAO, assignmentDAO, student);
		
		studentCoursesPanelController = new StudentCoursesPanelController(studentFindCoursePannelController, studentEnrolledCoursesPanelController);
		
		emailPanelControllerStudent = new EmailPanelController(mailDAO, user);
		
		IStudentHeaderController studentHeaderController = new StudentHeaderController(studentProfilePanelController, studentCoursesPanelController, emailPanelControllerStudent);

		
		StudentProfileInformationPanel studentProfilePanel = new StudentProfileInformationPanel();
		StudentHeader header = new StudentHeader(studentHeaderController);
		StudentPanel studentPanel = new StudentPanel(header, studentProfilePanel);
		
		StudentFindCoursePannel studentFindCoursePannel = new StudentFindCoursePannel(studentFindCoursePannelController);
		StudentEnrolledCoursesPanel studentEnrolledCoursesPanel = new StudentEnrolledCoursesPanel(studentEnrolledCoursesPanelController);
		
		StudentCoursesPanel studentCoursesPanel = new StudentCoursesPanel(studentCoursesPanelController, studentFindCoursePannel, studentEnrolledCoursesPanel);

		studentFindCoursePannelController.setStudentFindCoursePannel(studentFindCoursePannel);
		studentEnrolledCoursesPanelController.setStudentEnrolledCoursesPanel(studentEnrolledCoursesPanel);
		
		studentCoursesPanelController.setStudentPanel(studentPanel);
		studentCoursesPanelController.setStudentCoursesPanel(studentCoursesPanel);
		
		MailPanel mailPanel = new MailPanel(emailPanelControllerStudent);
		
		emailPanelControllerStudent.setMailPanel(mailPanel);
		emailPanelControllerStudent.setSupportPanel(studentPanel);
		
		studentFrame = new StudentFrame(studentPanel);
	}

	

}
