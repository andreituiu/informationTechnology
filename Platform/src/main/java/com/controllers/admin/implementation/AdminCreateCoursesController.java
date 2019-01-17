package com.controllers.admin.implementation;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateCoursesController;
import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.dao.CourseDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.TeacherDAO;
import com.model.repository.CourseRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.TeacherRepository;
import com.views.admin.CreateCourses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;


@Component
public class AdminCreateCoursesController  implements IAdminCreateCoursesController, Initializable {

	@Autowired
	private CreateCourses adminCreateCourses;
	
	
	
	private Teacher teacherSelected;

	@Autowired
	private CourseRepository coursesRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private SpecializationRepository specializationRepository;

	private Specialization specializationSelected;
	private Stage adminCreateCourseStage;
	
	@FXML 
	private TextField nameTF;
	@FXML 
	private TextField yearTF;
	@FXML 
	private TextField semesterTF;
	@FXML 
	private ComboBox<Teacher> teacherCmb;
	@FXML 
	private ComboBox<Specialization> specializationCmb;

	private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
	private ObservableList<Specialization> specializations  = FXCollections.observableArrayList();

	public void setAdminCreateCourseStage(Stage adminCreateCourseStage) {
		this.adminCreateCourseStage = adminCreateCourseStage;
	}



	public AdminCreateCoursesController(CourseDAO coursesDAO, TeacherDAO teachersDAO,
			SpecializationDAO specializationDAO) {
		super();
		this.coursesRepository = coursesDAO;
		this.teachersDAO = teachersDAO;
		this.specializationRepository = specializationDAO;
	}
	
	

	public AdminCreateCoursesController() {
		super();
	}



	@Override
	public void setAdminCreateCourses(CreateCourses adminCreateCourses) {
		this.adminCreateCourses = adminCreateCourses;
	}




	@Override
	public void saveCourse() {

		 Course course = new Course();
		 course.setName(adminCreateCourses.getCourseName());
		 course.setYear(adminCreateCourses.getYear());
		 course.setSemester(adminCreateCourses.getSemester());
		 course.setSpecialization(specializationSelected);
		 teacherSelected.addCourse(course);
//		 Optional<Teacher> findById = teacherRepository.findById(teacherSelected.getCnp());
		 
//		 course.setTeacher(findById.get());
		 course.setTeacher(teacherSelected);
//		 teacherSelected.addCourse(course);
//		 teacherRepository.save(teacherSelected);
		 coursesRepository.save(course);
		
	}


	public void openFrame() {
		adminCreateCourses.ereaseAll();
		adminCreateCourses.populateTeachers(teacherRepository.findAll());
		adminCreateCourses.populateSpecializations(specializationRepository.findAll());
		adminCreateCourses.setVisible(true);
	}




	@Override
	public void selectSpecialization(Specialization specialization) {
	
		specializationSelected = specialization;
	}
	

	@Override
	public void selectTeacher(Teacher teacher) {
		 teacherSelected = teacher;
	}



	@FXML
	public void createCourse() {
		Integer semester = Integer.parseInt(semesterTF.getText());
		Integer year = Integer.parseInt(yearTF.getText());
		Teacher selectedTeacher = teacherCmb.getSelectionModel().getSelectedItem();
		Specialization selectedSpecialization = specializationCmb.getSelectionModel().getSelectedItem();

		Course course = new Course();
		course.setName(nameTF.getText());
		course.setSemester(semester);
		course.setYear(year);
		course.setTeacher(selectedTeacher);
		course.setSpecialization(selectedSpecialization);
		
		coursesRepository.save(course);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		teacherCmb.setConverter(new StringConverter<Teacher>() {
			@Override
			public String toString(Teacher teacher) {
				if (teacher == null) {
					return "";
				} else {
					return teacher.getName() + " " + teacher.getSurname();
				}
			}

			@Override
			public Teacher fromString(String string) {
				return null;
			}
		});	
		
		specializationCmb.setConverter(new StringConverter<Specialization>() {
			@Override
			public String toString(Specialization specialization) {
				if (specialization == null) {
					return "";
				} else {
					return specialization.getName();
				}
			}

			@Override
			public Specialization fromString(String string) {
				return null;
			}
		});		
	}


	

}

	






