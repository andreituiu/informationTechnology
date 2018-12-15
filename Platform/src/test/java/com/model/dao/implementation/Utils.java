package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.controllers.common.implementation.ROLE;
import com.model.Admin;
import com.model.Assignment;
import com.model.Course;
import com.model.Mail;
import com.model.Specialization;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.Teacher;
import com.model.User;
import com.model.dao.CourseDAO;
import com.model.mapper.AdminMapper;
import com.model.mapper.AssignmentMapper;
import com.model.mapper.CourseMapper;
import com.model.mapper.MailMapper;
import com.model.mapper.StudentAssignmentMapper;
import com.model.mapper.StudentMapper;
import com.model.mapper.TeacherMapper;
import com.model.mapper.UserMapper;

public class Utils {

	public Course course;
	public Student student;
	public Student enrolledStudent;
	public Teacher teacher;
	public Student pendingStudent;
	public CourseDAO courseDAO;
	private Connection connection;
	public StudentDAOImpl studentDAO;
	public MailDAOImpl mailDAO;
	public TeacherDAOImpl teacherDAO;
	public AssignmentDAOImpl assignmentDAO;
	public AdminDAOImpl adminDAO;
	public SpecializationDAOImpl specializationDAO;
	public UserDAOImpl userDAO;
	private StudentMapper studentMapper;
	private TeacherMapper teacherMapper;
	private AssignmentMapper assignmetMapper;
	private StudentAssignmentMapper studentAssignmentsMapper;
	private CourseMapper courseMapper;
	private AdminMapper adminMapper;
	private UserMapper userMapper;
	private Specialization specialization;
	public User user;
	
	public static final String COURSE_NAME = "COURSE_NAME";
	public static final Integer COURSE_YEAR = 1;
	public static final Integer COURSE_SEMESTER = 1;
	public static final String TEACHER_CNP = "TEACHER_CNP";
	public static final String SPECIALIZATION_NAME = "SPECIALIZATION_NAME";
	
	public static final String ADMIN_INETERNAL_EMAIL = "adminIneternalEmail";
	public static final String ADMIN_EXTERNAL_EMAIL = "adminExternalEmail";
	public static final String ADMIN_CNP = "adminCNP";
	public static final String ADMIN_PASSWORD = "adminPassword";
	public static final String ADMIN_SURNAME = "adminSurname";
	public static final String ADMIN_NAME = "adminName";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/se";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	public static final String TEACHER_NAME = "TEACHER_NAME";
	public static final String TEACHER_SURNAME = "TEACHER_SURNAME";
	public static final String TEACHER_PASSWORD = "TEACHER_PASSWORD";
	public static final String TEACHER_EXTERNAL_EMAIL = "TEACHER_EXTERNAL_EMAIL";
	public static final String TEACHER_INTERNAL_EMAIL = "TEACHER_INTERNAL_EMAIL";
	public static final String STUDENT_CNP = "999";
	public static final String STUDENT_NAME = "STUDENT_NAME";
	public static final String STUDENT_SURNAME = "STUDENT_SURNAME";
	public static final String STUDENT_EE = "STUDENT_EE";
	public static final String STUDENT_PASSWORD = "STUDENT_PASSWORD";
	public static final String STUDENT_IE = "STUDENT_IE";
	public static final Integer STUDY_YEAR = 1;
	public static final String STUDENT_CNP_ENROLLED = "STUDENT_CNP_ENROLLED";
	public static final String STUDENT_CNP_PENDING = "STUDENT_CNP_PENDING";
	public static final String ASSIGNMENT_NAME = "ASSIGNMENT_NAME";

	
	public Utils() {
		super();
		initConn();
		initMappers();
		initDAO();
	}


	private void initModel() {
		user = new User();
		user.setCnp(STUDENT_CNP);
		user.setName(STUDENT_NAME);
		user.setSurname(STUDENT_SURNAME);
		user.setRole(ROLE.STUDENT.getName());
		
		userDAO.save(user);
		
		user.setCnp(TEACHER_CNP);
		userDAO.save(user);
		
		user.setCnp(STUDENT_CNP_ENROLLED);
		userDAO.save(user);
		
		user.setCnp(STUDENT_CNP_PENDING);
		userDAO.save(user);
		
		user.setCnp(ADMIN_CNP);
		userDAO.save(user);
		
		specialization = new Specialization();
		specialization.setName(SPECIALIZATION_NAME);
		
		specializationDAO.saveNewSpecialization(specialization);
		
		teacher = new Teacher();
		teacher.setCnp(TEACHER_CNP);
		teacher.setName(TEACHER_NAME);
		teacher.setSurname(TEACHER_SURNAME);
		teacher.setPassword(TEACHER_PASSWORD);
		teacher.setExternalEmail(TEACHER_EXTERNAL_EMAIL);
		teacher.setInternalEmail(TEACHER_INTERNAL_EMAIL);
		
		course = new Course();
		course.setName(COURSE_NAME);
		course.setSemester(COURSE_SEMESTER);
		course.setSpecialization(specialization);
		course.setTeacher(teacher);
		course.setYear(COURSE_YEAR);
		
		courseDAO.saveNewCourse(course);
		
		student = new Student();
		student.setCnp(STUDENT_CNP);
		student.setName(STUDENT_NAME);
		student.setSurname(STUDENT_SURNAME);
		student.setExternalEmail(STUDENT_EE);
		student.setInternalEmail(STUDENT_IE);
		student.setPassword(STUDENT_PASSWORD);
		student.setSpecialization(specialization);
		student.setStudyYear(STUDY_YEAR);
		
		enrolledStudent = new Student();
		enrolledStudent.setCnp(STUDENT_CNP_ENROLLED);
		enrolledStudent.setName(STUDENT_NAME);
		enrolledStudent.setSurname(STUDENT_SURNAME);
		enrolledStudent.setExternalEmail(STUDENT_EE);
		enrolledStudent.setInternalEmail(STUDENT_IE);
		enrolledStudent.setPassword(STUDENT_PASSWORD);
		enrolledStudent.setSpecialization(specialization);
		enrolledStudent.setStudyYear(STUDY_YEAR);
		
		pendingStudent = new Student();
		pendingStudent.setCnp(STUDENT_CNP_PENDING);
		pendingStudent.setName(STUDENT_NAME);
		pendingStudent.setSurname(STUDENT_SURNAME);
		pendingStudent.setExternalEmail(STUDENT_EE);
		pendingStudent.setInternalEmail(STUDENT_IE);
		pendingStudent.setPassword(STUDENT_PASSWORD);
		pendingStudent.setSpecialization(specialization);
		pendingStudent.setStudyYear(STUDY_YEAR);
		
		studentDAO.save(pendingStudent);
		studentDAO.save(enrolledStudent);
		studentDAO.save(student);
		
		studentDAO.enrolleToCourse(enrolledStudent, course);
		studentDAO.pendingStudent(pendingStudent, course);
		
		teacherDAO.save(teacher);
		
		Admin admin = new Admin();
		admin.setName(ADMIN_NAME);
		admin.setSurname(ADMIN_SURNAME);
		admin.setPassword(ADMIN_PASSWORD);
		admin.setCnp(ADMIN_CNP);
		admin.setExternalEmail(ADMIN_EXTERNAL_EMAIL);
		admin.setInternalEmail(ADMIN_INETERNAL_EMAIL);
		adminDAO.save(admin);
		
		Mail mail = new Mail();
		mail.setFromCnp(STUDENT_CNP);
		mail.setToCnp(STUDENT_CNP);
		mail.setSubject("");
		mail.setMessage("");
		mailDAO.sendMail(mail );
		
		Assignment assignment = new Assignment();
		assignment.setName(ASSIGNMENT_NAME);
		assignment.setCourseName(COURSE_NAME);
		assignment.setDeadline(new Date());
//		assignment.setId(100);
		assignmentDAO.save(assignment);
//		StudentAssignment studentAssignment = new StudentAssignment();
//		studentAssignment.setAssignment(assignment);
//		studentAssignment.setStudentCnp(STUDENT_CNP_ENROLLED);
//		
//		assignmentDAO.save(studentAssignment);
	}


	private void initMappers() {
		studentMapper = new StudentMapper();
		teacherMapper = new TeacherMapper();
		assignmetMapper = new AssignmentMapper();
		courseMapper = new CourseMapper(teacherMapper);
		studentAssignmentsMapper = new StudentAssignmentMapper(assignmetMapper);
		adminMapper = new AdminMapper();
		userMapper = new UserMapper();		
	}


	private void initDAO() {
		studentDAO = new StudentDAOImpl(studentMapper, connection);
        courseDAO = new CourseDAOImpl(courseMapper,connection);
		mailDAO = new MailDAOImpl(new MailMapper(), connection);
		teacherDAO = new TeacherDAOImpl(teacherMapper, connection);
		assignmentDAO = new AssignmentDAOImpl(assignmetMapper, studentAssignmentsMapper, connection);
		adminDAO = new AdminDAOImpl(adminMapper, connection);
		specializationDAO = new SpecializationDAOImpl(connection);
		userDAO = new UserDAOImpl(userMapper, connection);
	}


	private void initConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


	public void init() {
		initModel();
	}


	public void destroy() {
		User user = new User();
		user.setCnp(STUDENT_CNP);
		userDAO.deleteUser(user);
	}
}
