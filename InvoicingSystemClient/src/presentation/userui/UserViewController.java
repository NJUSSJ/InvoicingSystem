package presentation.userui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vo.UserVO;

public class UserViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Label logout;
	
	@FXML
	private TextField search;
	
	@FXML
	private Button rightB;
	
	@FXML
	private Button addB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private Button updateB;
	
	@FXML
	private Button returnB;
	
	UserBLService abs=new UserController();
	
private ObservableList<UserData> userData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<UserData> userTable;
	
	@FXML
	private TableColumn<UserData,String> passwordColoumn;
	
	@FXML
	private TableColumn<UserData,String> rankColoumn;
	@FXML
	private TableColumn<UserData,String> nameColoumn;
	@FXML
	private TableColumn<UserData,String> idColoumn;
	
	UserVO a;
	ArrayList<UserVO> alist=new ArrayList<UserVO>();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		userTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		//nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		rankColoumn.setCellValueFactory(cellData ->cellData.getValue().getRankProperty());
		passwordColoumn.setCellValueFactory(cellData ->cellData.getValue().getPasswordProperty());
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getIDProperty());
	    alist=abs.findUsers();
	    for(UserVO b:alist){
	    	userData.add(new UserData(b));
	    }
	    userTable.setItems(userData);
	}

	private void getInf(UserData newValue) {
		// TODO Auto-generated method stub
		a=newValue.getVO();
	}
	@FXML
	public void louout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void searchUser(){
		String find=search.getText();
		userData.clear();
		if(find.charAt(0)>='0'&&find.charAt(0)<='9'){
			a=abs.findUserByID(Long.parseLong(find));
			userData.add(new UserData(a));
			userTable.setItems(userData);
		}else{
		a=abs.findUserbyName(find);
		userData.add(new UserData(a));
		userTable.setItems(userData);
		}
		
	}
	@FXML
    public void addUser(){
    	try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/userui/UserChangeUI.fxml"));
			AnchorPane userUI=loader.load();
			Scene scene=new Scene(userUI);
			Stage userStage=new Stage();
			userStage.setTitle("Create/Change User");
			userStage.initModality(Modality.WINDOW_MODAL);
			userStage.initOwner(MainApp.getPrimaryStage());
			userStage.setScene(scene);
            UserChangeViewController controller=loader.getController();
            controller.setStage(userStage);
            userStage.showAndWait();
            
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	@FXML
	public void deleteUser(){
    	int selectedIndex = userTable.getSelectionModel().getSelectedIndex();
    	 if (selectedIndex >= 0) {
    	        userTable.getItems().remove(selectedIndex);
    			abs.deleteUser(a);
    	    } else {
    	        // Nothing selected.
    	        Alert alert = new Alert(AlertType.WARNING);
    	        alert.initOwner(MainApp.getPrimaryStage());
    	        alert.setTitle("No Selection");
    	        alert.setHeaderText("No User Selected");
    	        alert.setContentText("Please select an User in the table.");

    	        alert.showAndWait();
    	    }
   	}
	 @FXML
	    public void updateAccount(){
	    	try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/userui/UserChangeUI.fxml"));
				AnchorPane userUI=loader.load();
				Scene scene=new Scene(userUI);
				Stage userStage=new Stage();
				userStage.setTitle("Create/Change User");
				userStage.initModality(Modality.WINDOW_MODAL);
				userStage.initOwner(MainApp.getPrimaryStage());
				userStage.setScene(scene);
				UserChangeViewController controller=loader.getController();
	            controller.setStage(userStage);
	            controller.setID(a.getID());
	            userStage.showAndWait();
	            
			} catch (IOException e) {
				// TODO: handle exception
			}
			
	   	}
	 @FXML
	    public void showAdministerMainUI(){
			MainApp.showAdministerMainUI();
	   	}
}
