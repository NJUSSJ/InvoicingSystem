package presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.userbl.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.UserVO;

public class UserModifyController implements Initializable {

	@FXML
	private TextField name;
	@FXML
	private Label id;
	@FXML
	private Button confirm;
	@FXML
	private TextField password;
	@FXML
	private TextField rank;
	
	UserData data;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private Button cancelB;
    Stage stage;
	public void setStage(Stage userStage) {
		stage=userStage;
	}
	
	@FXML
	public void cancel(){
		stage.close();
	}
	
	public void setSelected(UserData data) {
		this.data=data;
	}
	
	public void confirm() {
		if(cetifyInput()) {
			String name_=name.getText();
			String rank_=rank.getText();
			String password_=password.getText();
			int rankNum=Integer.parseInt(rank_);
			long id_=Long.parseLong(id.getText());
			
			UserVO tmpVO=new UserVO(id_, password_, rankNum, name_);
			data.setName(name_);
			data.setPassword(password_);
			data.setRank(rank_);
			stage.close();
			
			new UserController().updateUser(tmpVO);
		}
	}
	
	public boolean cetifyInput() {
		String name_=name.getText();
		String rank_=rank.getText();
		String password_=password.getText();
		if(name_==""||name==null||rank==null||rank_==""||password_==""||password_==null) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setTitle("Input Warning!");
			warning.setContentText("请填写完整信息");
			warning.showAndWait();
			return false;
		}
		int rankNum=Integer.parseInt(rank_);
		if(rankNum<0||rankNum>4) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setTitle("Input Warning!");
			warning.setContentText("等级信息不正确！");
			warning.showAndWait();
			return false;
		}
		return true;
	}
	
	public void setInfo(String name,int rank,String password,long id) {
		this.name.setText(name);
		String idString=id+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		this.id.setText(idString);
		this.password.setText(password);
		this.rank.setText(rank+"");
	}

}
