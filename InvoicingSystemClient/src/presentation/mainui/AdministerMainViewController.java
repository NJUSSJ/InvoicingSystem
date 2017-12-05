package presentation.mainui;


import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AdministerMainViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private ImageView email;
	
	@FXML
	private ImageView log;
	
	@FXML
	private ImageView userChange;

	@FXML
	private Label logout;
	//��ʼ��ʱ����Id
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
	}
	
	@FXML
	public void showlogUI(){
		MainApp.showLogUI();
	}
	@FXML
    public void showEmailUI(){
		MainApp.showEmailUI();
	}
	@FXML
    public void showuserChangeUI(){
	    MainApp.showUserChangeUI();
    }
	@FXML
    public void showLoginUI(){
    	MainApp.cancelUser();
		MainApp.showLoginUI();
   	}
}
