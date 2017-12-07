package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.UserVO;

public class UserChangeViewController {
	@FXML
	private TextField name;
	@FXML
	private Label id;
	@FXML
	private Button rightB;
	@FXML
	private TextField password;
	@FXML
	private TextField rank;
	
	int style=0;
	
	UserBLService ubs=new UserController();
	
	UserVO user;
	
	static long times=0;
	@FXML
	private Button cancelB;
    Stage stage;
	public void setStage(Stage userStage) {
		// TODO Auto-generated method stub
		stage=userStage;
	}
	public void setID(long id) {
		// TODO Auto-generated method stub
		this.id.setText(Long.toString(id));
		style=1;
	}
	@FXML
	public void cancel(){
		stage.close();
	}
	@FXML
	public void setUser(){
		if(style==0){
			String a=id.getText();
			String b=name.getText();
			String c=rank.getText();
			String d=password.getText();
			user=new UserVO(Long.parseLong(a),b,Integer.parseInt(c),d);
			ubs.addUser(user);
		}else{
			times++;
			String b=name.getText();
			String c=rank.getText();
			String d=password.getText();
			user=new UserVO(times,b,Integer.parseInt(c),d);
			ubs.updateUser(user);
		}
	}
}
