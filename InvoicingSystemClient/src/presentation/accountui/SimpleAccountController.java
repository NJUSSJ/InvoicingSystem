package presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountBLService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.AccountVO;

public class SimpleAccountController implements Initializable  {
	private  Stage stage;
	@FXML
	private TextField nameField;
	@FXML
	private TextField accountField;
	@FXML
	private TextField idField;
	@FXML
	private Button cancelB;
	@FXML
	private Button rightB;
	 
	int style=0;//style=1  ÐÞ¸Ä/0 ÐÂÔö
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	@FXML
	public void rightSet(){
		String name=nameField.getText();
		String deposit=accountField.getText();
		AccountVO a=new AccountVO(0,Double.parseDouble(deposit),name);
		AccountBLService abs=new AccountController();
		if(style==1){
			abs.updateAccount(a);
		}else{
			abs.addAccount(a);
		}
	}
	@FXML
	public void cancelSet(){
		stage.close();
	}

	public void setStage(Stage writeStage) {
		stage=writeStage;
	}

	public void setAccount(String a){
		accountField.setText(a);
		style=1;
	}
	
	public void setName(String a){
		nameField.setText(a);
		style=1;
	}

	public void setId(String id) {
		idField.setText(id);
		style=1;
		
	}

	
}
