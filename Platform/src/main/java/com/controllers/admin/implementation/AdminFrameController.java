package com.controllers.admin.implementation;

import java.awt.Window;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminFrameController;
import com.controllers.admin.IAdminProfileController;
import com.model.Admin;
import com.model.User;
import com.model.dao.UserDAO;
import com.views.admin.AdminFrame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

@Component
public class AdminFrameController implements IAdminFrameController, Initializable {

	@Autowired
	private IAdminProfileController adminProfileController;
	
	@Autowired
	private AdminFrame adminFrame;
//	
//	@FXML
//	private TableView<User> usersTable;
//	
//	@FXML
//	private TableColumn<User, String> CNPColUT;
//	
//	@FXML
//	private TableColumn<User, String> NameColUT;
//	
//	@FXML
//	private TableColumn<User, String> SurnameColUT;
//
//	@FXML
//	private TableColumn<User, String> RoleColUT;
//	
//	@Autowired
//	private UserDAO userDAO;
//	
//	@FXML
//	private Button searchBtn;
//	
//	@FXML
//	private TextField searchTF;
//	
//	@Autowired
//	private Stage createUserStage;
//	
//	@FXML
//	private Button deleteUserBtn;
//	
////	@Autowired
////	private Stage modifyUserStage;
//	
//	@Autowired
//	private AdminModifyUsersController adminModifyUserController;
//	
//	@Autowired
//	private AdminCreateCoursesController adminCreateCourseController;
//	
//	@Autowired
//	private Stage stage;

	
	
	public AdminFrameController(IAdminProfileController adminProfileController) {
		this.adminProfileController = adminProfileController;
	}

	public AdminFrameController() {
		super();
	}

	@Override
	public void setAdmin(Admin admin) {
		adminProfileController.setAdmin(admin);
	}

	
	@Override
	public void setAdminFrame(AdminFrame adminFrame) {
		this.adminFrame = adminFrame;
	}

	@Override
	public void openFrame() {
//		Parent root = null;
//		try {
//			root = FXMLLoader.load(getClass().getResource("/fxxml/Admin.fxml"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Scene scene = new Scene(root);
//		Stage stage = new Stage(StageStyle.DECORATED);
//		stage.setTitle("My Application");
//		stage.setScene(scene);
//		
//		update();
//		stage.show();
		adminFrame.setVisible(true);
	}

	private void update() {
		List<User> allUsers = userDAO.findAll();
		updateTable(allUsers);

	}
	
	private void updateTable(List<User> users) {
		ObservableList<User> data = FXCollections.observableArrayList(users);
		usersTable.setItems(data);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTableFields();
		update();
	}
	
	private void initTableFields() {
		CNPColUT.setCellValueFactory(new PropertyValueFactory<User, String>("cnp"));
		NameColUT.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		SurnameColUT.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));
		RoleColUT.setCellValueFactory(new PropertyValueFactory<User, String>("role"));		
	}

	public void searchUser() {
		String searchTxt = searchTF.getText();
		searchTxt = searchTxt.trim();
		
		List<User> users = userDAO.findContaining(searchTxt);
		updateTable(users);
	}
	
	public void createUser() {
		createUserStage.show();
	}

	public void deleteUser() {
		User slectedUser = getSelectedUser();
		userDAO.delete(slectedUser);
		
		searchUser();
	}

	private User getSelectedUser() {
		User slectedUser = usersTable.getSelectionModel().getSelectedItem();
		return slectedUser;
	}
	
	public void modifyUser() {
		User selectedUser = getSelectedUser();
		if(selectedUser == null) {
			return;
		}
		adminModifyUserController.setUser(selectedUser);
		adminModifyUserController.openFrame();
	}
}
