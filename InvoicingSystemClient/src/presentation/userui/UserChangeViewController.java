package presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.UserVO;

public class UserChangeViewController implements Initializable {
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
	
	ObservableList<UserData> list;
	
	
	static long times=0;
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
	
	public void setObeservarableList(ObservableList<UserData> list) {
		this.list=list;
		long largest=-1;
		for(int i=0;i<list.size();i++) {
			if(Long.parseLong(list.get(i).getIDProperty().get())>largest)
				largest=Long.parseLong(list.get(i).getIDProperty().get());
		}
		String id=largest+1+"";
		while(id.length()<5) {
			id="0"+id;
		}
		this.id.setText(id);
	}
	
	public void confirm() {
		if(cetifyInput()) {
			String name_=name.getText();
			String rank_=rank.getText();
			String password_=password.getText();
			int rankNum=Integer.parseInt(rank_);
			long id_=Long.parseLong(id.getText());
			
			UserVO tmpVO=new UserVO(id_, password_, rankNum, name_);
			list.add(new UserData(tmpVO));
			stage.close();
			
			new UserController().addUser(tmpVO);
		}
	}
	
	public boolean cetifyInput() {
		String name_=name.getText();
		String rank_=rank.getText();
		String password_=password.getText();
		if(name_.equals("")||name_==null||rank_==null||rank_.equals("")||password_.equals("")||password_==null) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setTitle("Input Warning!");
			warning.setContentText("请填写完整信息");
			warning.showAndWait();
			return false;
		}
		try {
			
		int rankNum=Integer.parseInt(rank_);
		if(rankNum<0||rankNum>4) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setTitle("Input Warning!");
			warning.setContentText("等级信息不正确！");
			warning.showAndWait();
			return false;
		}
		} catch (NumberFormatException e) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setTitle("Input Warning!");
			warning.setContentText("等级信息不正确！");
			warning.showAndWait();
			return false;
		}
		
		return true;
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
