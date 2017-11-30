package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WarningViewController implements Initializable {
	@FXML
	private Button returnb;
	@FXML
	private Button rightb;
	@FXML
	private TextField num;
	
	private  Stage stage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void rightWarning(){
		String theNum=num.getText();
		//Î´Ð´Íê
		
		stage.close();
	}
	public void cancelWarning(){
		stage.close();
	}
	public void setStage(Stage warnStage) {
		// TODO Auto-generated method stub
		stage=warnStage;
	}
}
