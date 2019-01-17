package com.controllers.teacher.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherFrameController;
import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.views.teacher.TeacherFrame;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

@Component
public class TeacherFrameController implements ITeacherFrameController {

	@Autowired
	private TeacherProfileController teacherProfileController;
	
	
//	private ITeacherCoursePanelController teacherCoursesPanelController;
	
	@Autowired
	private TeacherFrame teacherFrame;


	private Stage teacherStage;


	@FXML AnchorPane bodyPanel;

	@Autowired
	private TeacherCourseController teacherCoursesController;

	public TeacherFrameController(ITeacherProfileInformationPanelController teacherProfilePanelController,
			ITeacherCoursePanelController teacherCoursesPanelController) {
				this.teacherProfileController = teacherProfilePanelController;
				this.teacherCoursesPanelController = teacherCoursesPanelController;
	}
	
	
	
	
	public TeacherFrameController() {
		super();
	}




	@Override
	public void setTeacherFrame(TeacherFrame teacherFrame) {
		this.teacherFrame = teacherFrame;
	}



	@Override
	public void setTeacher(Teacher teacher) {
		
		teacherProfileController.setTeacher(teacher);
		teacherCoursesController.setTeacher(teacher);
	}

	@Override
	public void openFrame() {
//		teacherStage.show();
//		Parent root = null;
//		try {
//			root = FXMLLoader.load(getClass().getResource("/fxxml/Admin.fxml"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Scene scene = new Scene(root);
//		Stage stage = new Stage(StageStyle.DECORATED);
//		stage.setTitle("My Application");
//		stage.setScene(scene);
//		stage.show();
		teacherFrame.setVisible(true);
	}


	public void setTeacherStage(Stage teacherStage) {
		this.teacherStage = teacherStage;
	}


	public void openProfile() {
		teacherProfileController.update();
		bodyPanel.getChildren().setAll(teacherProfileController.getTeacherPanel());
	}

	public void openCourses() {
		teacherCoursesController.update();
		bodyPanel.getChildren().setAll(teacherCoursesController.getCoursesPanel());
	}

}
