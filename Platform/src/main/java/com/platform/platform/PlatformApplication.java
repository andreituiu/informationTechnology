package com.platform.platform;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.controllers.common.implementation.LoginController;
import com.model.Admin;
import com.model.Mail;
import com.model.Teacher;
import com.model.repository.AdminRepository;
import com.model.repository.AssignmentRepository;
import com.model.repository.MailRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.StudentAssignmentRepository;
import com.model.repository.StudentRepository;
import com.model.repository.TeacherRepository;
import com.model.repository.UserRepository;
import com.utils.Configuration;
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
	 
	 
	 @Autowired
	 private Configuration configuration;
	 
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PlatformApplication.class);
	    builder.headless(false).run(args);
		PlatformApplication application = new PlatformApplication();
	}

	@Autowired
	private LoginController loginController;
	
	@Autowired
	private Login loginFrame;


	private void run() {
		initLogin();
	}

	@PostConstruct
	public void listen() throws IOException {

		initLogin();
	}

	private void initLogin() {
		 loginController.setLoginFrame(loginFrame);
		 loginFrame.setVisible(true);
	}

}
