package com.application;

import org.hibernate.Session;
import org.springframework.context.annotation.Bean;

import com.model.dao.AdminDAO;
import com.model.dao.CourseDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.dao.UserDAO;
import com.model.dao.hibernateimplementation.AdminDAOHImpl;
import com.model.dao.hibernateimplementation.CourseDAOHImpl;
import com.model.dao.hibernateimplementation.SpecializationDAOHImpl;
import com.model.dao.hibernateimplementation.StudentDAOHImpl;
import com.model.dao.hibernateimplementation.TeacherDAOHImpl;
import com.model.dao.hibernateimplementation.UserDAOHImpl;
import com.model.utils.SessionUtil;

public class DAOInitializerBean {
//
//	@Bean
//	public Session session() {
//		return SessionUtil.getSessionFactory().openSession();
//	}
//
//	@Bean
//	public UserDAO userDAO() {
//		return new UserDAOHImpl();
//	}
//	
//	@Bean
//	public AdminDAO adminDAO() {
//		return new AdminDAOHImpl();
//	}
//	
//	@Bean
//	public StudentDAO studentDAO() {
//		return new StudentDAOHImpl();
//	}
//	
//	@Bean
//	public TeacherDAO teacherDAO() {
//		return new TeacherDAOHImpl();
//	}
//	
//	@Bean
//	public SpecializationDAO specializationDAO() {
//		return new SpecializationDAOHImpl();
//	}
//	
//	@Bean
//	public CourseDAO courseDAO() {
//		return new CourseDAOHImpl();
//	}
}
