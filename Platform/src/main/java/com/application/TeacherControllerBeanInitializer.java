package com.application;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.controllers.admin.implementation.AdminCreateSpecializationsController;
import com.controllers.admin.implementation.AdminModifyUsersController;
import com.controllers.teacher.implementation.TeacherCourseController;
import com.controllers.teacher.implementation.TeacherFrameController;
import com.controllers.teacher.implementation.TeacherProfileController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TeacherControllerBeanInitializer implements ApplicationContextAware {

	private ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.context = applicationContext;
	}
//	
//	@Bean(name="teacherFrameStage")
//	public Stage teacherFrameStage() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/teacher/TeacherFrame.fxml"));
//		loader.setControllerFactory(context::getBean);
////		loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		TeacherFrameController controller = loader.getController();
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		controller.setTeacherStage(primaryStage);
//		
//		return primaryStage;
//	}
//	
//	@Bean(name="TeacherFrameController")
//	@Scope("singleton")
//	public TeacherFrameController TeacherFrameController() {
//		return new TeacherFrameController();
//	}
//	
//	@Bean(name="teacherProfileParent")
//	public Parent teacherProfileParent() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/teacher/TeacherProfile.fxml"));
//		loader.setControllerFactory(context::getBean);
////		loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		TeacherProfileController controller = loader.getController();
//
//		controller.setTeacherPanel(root);
//		
//		return root;
//	}
//	
//	@Bean(name="TeacherProfileController")
//	@Scope("singleton")
//	public TeacherProfileController TeacherProfileController() {
//		return new TeacherProfileController();
//	}
//	
//	@Bean(name="teacherCoursesParent")
//	public Node teacherCoursesParent() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/teacher/TeacherCourses.fxml"));
//		loader.setControllerFactory(context::getBean);
////		loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		TeacherCourseController controller = loader.getController();
//
//		controller.setCoursesPanel(root);
//		
//		return root;
//	}
//	
//	@Bean(name="TeacherCourseController")
//	@Scope("singleton")
//	public TeacherCourseController TeacherCourseController() {
//		return new TeacherCourseController();
//	}
}
