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
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	
	UserVO a=null;
	ArrayList<UserVO> alist=new ArrayList<UserVO>();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
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
	    
	    search.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getCode().equals(KeyCode.ENTER)) {
					searchUser();
				}
			}
		});
	    search.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				if(search.getText().equals("")&&e.getCode().equals(KeyCode.DELETE)) {
					MainApp.showUserChangeUI();
				}
			}
		});
	}

	
	@FXML
	public void louout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void searchUser(){
		
		
		
		String find=search.getText();
		if(find.equals("")) {
			MainApp.showUserChangeUI();
			return;
		}
		addB.setDisable(true);
		userData.clear();
		if(find.charAt(0)>='0'&&find.charAt(0)<='9'){
			a=abs.findUserByID(Long.parseLong(find));
			if(a==null) {
				Alert info=new Alert(AlertType.INFORMATION);
				info.setTitle("Information");
				info.setContentText("Find no mathch!");
				info.show();
				return;
			}
			userData.add(new UserData(a));
			userTable.setItems(userData);
		}else{
		ArrayList<UserVO> usersFound=abs.findUsersbyField(find);
		if(usersFound.isEmpty()) {
			Alert info=new Alert(AlertType.INFORMATION);
			info.setTitle("Information");
			info.setContentText("Find no mathch!");
			info.showAndWait();
			return;
		}
		userData.clear();
		for(int i=0;i<usersFound.size();i++) {
			userData.add(new UserData(usersFound.get(i)));
		}
		
		userTable.setItems(userData);
		}
		
	}
	@FXML
    public void addUser(){
    	try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/userui/UserChangeUI.fxml"));
			AnchorPane userUI=(AnchorPane)loader.load();
			Scene scene=new Scene(userUI);
			Stage userStage=new Stage();
			userStage.setTitle("New User");
			userStage.initModality(Modality.WINDOW_MODAL);
			userStage.initOwner(MainApp.getPrimaryStage());
			userStage.setScene(scene);
            UserChangeViewController controller=loader.getController();
            controller.setStage(userStage);
            controller.setObeservarableList(userData);
            userStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void deleteUser(){
    	int selectedIndex = userTable.getSelectionModel().getSelectedIndex();
    	UserData tmpUser=userTable.getSelectionModel().getSelectedItem();
    	long id=Long.parseLong(tmpUser.getIDProperty().get());
    	int rank=Integer.parseInt(tmpUser.getRankProperty().get());
    	UserVO tmpUserVO=new UserVO(id, tmpUser.getPasswordProperty().get(), rank, tmpUser.getNameProperty().get()); 
    	 if (selectedIndex >= 0) {
    	        userTable.getItems().remove(selectedIndex);
    			abs.deleteUser(tmpUserVO);
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
	    		UserData tmpData=userTable.getSelectionModel().getSelectedItem();
	    		if(tmpData==null) {
	    			 Alert alert = new Alert(AlertType.WARNING);
	     	        alert.initOwner(MainApp.getPrimaryStage());
	     	        alert.setTitle("No Selection");
	     	        alert.setHeaderText("No User Selected");
	     	        alert.setContentText("Please select an User in the table.");

	     	        alert.showAndWait();
	     	        return ;
	    		}
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/userui/UserModifyUI.fxml"));
				AnchorPane userUI=loader.load();
				Scene scene=new Scene(userUI);
				Stage userStage=new Stage();
				userStage.setTitle("Modify User");
				userStage.initModality(Modality.WINDOW_MODAL);
				userStage.initOwner(MainApp.getPrimaryStage());
				userStage.setScene(scene);
				UserModifyController controller=loader.getController();
	            controller.setStage(userStage);
	            controller.setSelected(tmpData);
	            controller.setInfo(tmpData.getNameProperty().get(), Integer.parseInt(tmpData.getRankProperty().get()), tmpData.getPasswordProperty().get(), Long.parseLong(tmpData.getIDProperty().get()));
	            userStage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	   	}
	 @FXML
	    public void showAdministerMainUI(){
			MainApp.showAdministerMainUI();
	   	}
}
