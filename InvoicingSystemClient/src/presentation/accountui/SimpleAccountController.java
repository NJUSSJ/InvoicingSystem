package presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SimpleAccountController implements Initializable  {
	private  Stage stage;
	@FXML
	private TextField nameField;
	@FXML
	private TextField accoutnField;
	@FXML
	private Button cancelB;
	@FXML
	private Button rightB;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void rightSet(){
		//
	}
	public void cancelSet(){
		stage.close();
	}
	public void setStage(Stage writeStage) {
		stage=writeStage;
	}
}
