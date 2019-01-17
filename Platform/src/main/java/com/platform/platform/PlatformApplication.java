package com.platform.platform;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.controllers.common.implementation.LoginController;
import com.model.Admin;
import com.model.Specialization;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.repository.AdminRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.StudentRepository;
import com.model.repository.TeacherRepository;
import com.model.repository.UserRepository;
import com.views.common.Login;

@SpringBootApplication
@EnableJpaRepositories("com.model.repository")
@ComponentScan("com.*")
@EntityScan("com.model")
// @Configurable
public class PlatformApplication {

	 @Autowired
	 private UserRepository userDAO;

	 @Autowired
	 private AdminRepository adminDAO;
	 
	 @Autowired
	 private SpecializationRepository specializationRepository;
	 
	public static void main(String[] args) {
//		SpringApplication.run(PlatformApplication.class, args);
		// UserRepository userDAO = new UserDAOHImpl();
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PlatformApplication.class);
	    builder.headless(false).run(args);
		PlatformApplication application = new PlatformApplication();
		// application.run();
		// userDAO.save(new User("1", null, null, null, null, null));
	}

	@Autowired
	private LoginController loginController;
	
	@Autowired
	private Login loginFrame;

	@Autowired
	private TeacherRepository teacherDao;

	@Autowired
	private StudentRepository studentDAO;

	private void run() {
		// System.out.println("merge");
		// System.out.println(userDAO);
		// userDAO.save(new User("1", null, null, null, null, null));
		initLogin();
	}

	@PostConstruct
	public void listen() {
//		Specialization specialization = specializationRepository.save(new Specialization("test"));
//		userDAO.save(new Admin("1", null, null, null, null, "1"));
//		teacherDao.save(new Teacher("2", null, null, null, null, "1"));
//		studentDAO.save(new Student("3", null, null, null, null, "1", null, specialization));
		initLogin();
	}

	private void initLogin() {
//		loginFrame = new Login(loginController, null);
		// languageController.add(loginFrame);
		 loginController.setLoginFrame(loginFrame);
		 loginFrame.setVisible(true);
//		loginController.print();
	}

}
