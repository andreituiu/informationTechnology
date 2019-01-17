package com.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ControllerBeanInitializer implements ApplicationContextAware {

//	
	private ApplicationContext context;
//	
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
//
//	@Bean
//	public LoginController LoginController() {
//		return new LoginController();
//	}
//	
//	
//	@Bean
//	public AdminFrameController AdminFrameController() {
//		return new AdminFrameController();
//	}
//	
//	@Bean
//	public AdminCreateUserController AdminCreateUserController() {
//		return new AdminCreateUserController();
//	}
//	
//	@Bean
//	public Stage adminStage() {
////		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/Admin.fxml"));
//		loader.setControllerFactory(context::getBean);
////		TeacherFrameController t = loader.getController();
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		return primaryStage;
//	}
//	
//	
//	@Bean
//	public Stage createUserStage() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/CreateUser.fxml"));
//		loader.setControllerFactory(context::getBean);
////		loader.setController(AdminCreateUserController());
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		return primaryStage;
//	}
//	
////	@Bean
////	public Stage modifyUserStage() {
////		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/UpdateUser.fxml"));
////		loader.setControllerFactory(context::getBean);
////		
////		Parent root = null;
////		try {
////			root = loader.load();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		Stage primaryStage = new Stage();
////		primaryStage.setTitle("My Application");
////		primaryStage.setScene(new Scene(root));
////		return primaryStage;
////	}
//
//	
//	@Bean(name="modifyUserStage")
//	public Stage modifyUserStage() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/UpdateUser.fxml"));
//		loader.setControllerFactory(context::getBean);
////		loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		AdminModifyUsersController controller = loader.getController();
//		
//		controller.setStage(primaryStage);
//		
//		return primaryStage;
//	}
//
//	
//	@Bean(name="AdminModifyUsersController")
//	@Scope("singleton")
//	public AdminModifyUsersController AdminModifyUsersController() {
//		return new AdminModifyUsersController();
//	}
//	
//	@Bean
//	public AdminManageSpecializationsController AdminManageSpecializationsController() {
//		return new AdminManageSpecializationsController();
//	}
//
//	@Bean(name = "createSpecializationStage")
//	public Stage createSpecializationStage() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/CreateSpecialization.fxml"));
//		loader.setControllerFactory(context::getBean);
//		// loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		AdminCreateSpecializationsController controller = loader.getController();
//
//		controller.setAdminCreateSpecializationStage(primaryStage);
//
//		return primaryStage;
//	}
//	
//	@Bean(name="AdminCreateSpecializationsController")
//	@Scope("singleton")
//	public AdminCreateSpecializationsController AdminCreateSpecializationsController() {
//		return new AdminCreateSpecializationsController();
//	}
//	
//	@Bean(name = "modifySpecializationStage")
//	public Stage modifySpecializationStage() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/ModifySpecialization.fxml"));
//		loader.setControllerFactory(context::getBean);
//		// loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		AdminModifySpecializationController controller = loader.getController();
//
//		controller.setModifySpecializationStage(primaryStage);
//
//		return primaryStage;
//	}
//	
//	@Bean(name="AdminModifySpecializationController")
//	@Scope("singleton")
//	public AdminModifySpecializationController AdminModifySpecializationController() {
//		return new AdminModifySpecializationController();
//	}
//
//	@Bean
//	public AdminManageCoursesController AdminManageCoursesController() {
//		return new AdminManageCoursesController();
//	}
//	
//	@Bean(name = "createCourseStage")
//	public Stage createCourseStage() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxxml/CreateCourse.fxml"));
//		loader.setControllerFactory(context::getBean);
//		// loader.setCon
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Stage primaryStage = new Stage();
//		primaryStage.setTitle("My Application");
//		primaryStage.setScene(new Scene(root));
//		AdminCreateCoursesController controller = loader.getController();
//
//		controller.setAdminCreateCourseStage(primaryStage);
//
//		return primaryStage;
//	}
//	
//	@Bean(name="AdminCreateCoursesController")
//	@Scope("singleton")
//	public AdminCreateCoursesController AdminCreateCoursesController() {
//		return new AdminCreateCoursesController();
//	}
}
