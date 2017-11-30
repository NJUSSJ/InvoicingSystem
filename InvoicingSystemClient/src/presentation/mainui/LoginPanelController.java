package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vo.UserVO;

public class LoginPanelController implements Initializable {
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button SignButton;
	
	UserVO user;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean certifyUser() {
		String inputUserneme=username.getText();
		String inputPassword=password.getText();
		
		UserBLService userservice=new UserController();
		UserVO tmpUser=userservice.findUserbyName(inputUserneme);
		//用户不存在
		if(tmpUser==null) {
			Alert error=new Alert(Alert.AlertType.INFORMATION,"User does not exist!");

			Button confirm=new Button();

			error.show();

			confirm.setOnAction((ActionEvent e)->{

				 error.close();

			});
			return false;
		}
		//验证密码
		if(tmpUser.getPassword().equals(inputPassword)) {
			user=tmpUser;
			return true;
		}
		//密码错误
		else {
			Alert error=new Alert(Alert.AlertType.INFORMATION,"Incorrect Password!");

			Button confirm=new Button();

			error.show();

			confirm.setOnAction((ActionEvent e)->{

				 error.close();

			});
			return false;
		}
	}
	
	public void Login() {
		
		if(certifyUser()) {
			//判断用户身份
			switch (user.getRank()) {
			case 1:
                MainApp.showManagerMainUI();
				break;
			case 2:
				MainApp.showFianceMainUI();
				break;
			case 3:
                MainApp.showSaleMainUI();
				break;
			case 4:
                MainApp.showStockMainUI();
				break;
			case 0:
                MainApp.showAdministerMainUI();
				break;
			}
		}

		
		
	}
}
