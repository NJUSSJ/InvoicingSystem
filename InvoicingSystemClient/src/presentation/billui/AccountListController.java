package presentation.billui;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.billbl.AccountLineItem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountListController   implements Initializable {

	@FXML
	private Button rightB;
	@FXML
	private Button returnB;
	@FXML
	private TextField name;
	@FXML
	private TextField money;
	@FXML
	private TextField remark;
	 
	Stage stage;
	
	static AccountLineItem a;
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	public void close(){
		stage.close();
	}
	public void rightSet(){
		long id=Long.parseLong(name.getText());
		double mon=Double.parseDouble(money.getText());
		String re=remark.getText();
		a=new AccountLineItem(id,mon,re);
	}
	public void setStage(Stage payStage) {
		// TODO Auto-generated method stub
		stage=payStage;
	}
	public void setAccountid(String string) {
		// TODO Auto-generated method stub
		name.setText(string);
	}
	public void setRemark(String remark2) {
		// TODO Auto-generated method stub
		remark.setText(remark2);
	}
	public void setMoney(double money2) {
		// TODO Auto-generated method stub
		money.setText(Double.toString(money2));
	}
}
