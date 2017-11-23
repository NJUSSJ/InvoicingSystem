package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

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
	
	private Boolean certifyUser() {
		String inputUserneme=username.getText();
		String inputPassword=password.getText();
		
		UserBLService userservice=new UserController();
		UserVO tmpUser=userservice.findUserbyName(inputUserneme);
		//�û�������
		if(tmpUser==null) {
			Alert error=new Alert(Alert.AlertType.INFORMATION,"User does not exist!");

			Button confirm=new Button();

			error.show();

			confirm.setOnAction((ActionEvent e)->{

				 error.close();

			});
			return false;
		}
		//��֤����
		if(tmpUser.getPassword().equals(inputPassword)) {
			user=tmpUser;
			return true;
		}
		//�������
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
			//�ж��û����
			switch (user.getRank()) {
			case 1:
				System.out.println("�ܾ����¼��");
				break;

			default:
				break;
			}
		}
		
		
	}
}
