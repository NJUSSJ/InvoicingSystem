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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void showlogUI(){
		MainApp.showLogUI();
	}
    public void showEmailUI(){
		MainApp.showEmailUI();
	}
    public void showuserChangeUI(){
	    MainApp.showUserChangeUI();
    }
    public void showLoginUI(){
    	MainApp.cancelUser();
		MainApp.showLoginUI();
   	}
}
