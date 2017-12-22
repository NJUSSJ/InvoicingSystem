package presentation.memberui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.memberbl.MemberController;
import businesslogicservice.memberblservice.MemberBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.MemberVO;

public class SimpleMemberController implements Initializable{
	
Stage stage;
@FXML
private TextField nameField;
@FXML
private TextField rankField;
@FXML
private TextField categoryField;
@FXML
private TextField addressField;
@FXML
private TextField emailField;
@FXML
private TextField postcodeField;
@FXML
private TextField telephoneField;
@FXML
private Button cancelB;
@FXML
private Button rightB;
@FXML
private Label shouldpay;
@FXML
private Label shouldget;
@FXML
private Label quota;
@FXML
private Label operator;

private ObservableList<MemberData> memberData =FXCollections.observableArrayList();
int style=0;//style=1  ÐÞ¸Ä/0 ÐÂÔö

static long id=0;

MemberBLService mbs=new MemberController();

MemberVO a;

@Override
public void initialize(URL location, ResourceBundle resources) {
}
	public void setStage(Stage memberStage) {
		stage=memberStage;
	}
	public void setMember(MemberVO me) {
		a=me;
		nameField.setText(a.getName());
		rankField.setText(Integer.toString(a.getRank()));
		categoryField.setText(Integer.toString(a.getCategory()));
		emailField.setText(a.getEmail());
		addressField.setText(a.getAddress());
		postcodeField.setText(Integer.toString(a.getPostCode()));
		telephoneField.setText(Long.toString(a.getPhoneNum()));
		style=1;
	}
    public void cancel(){
    	stage.close();
    }
    public void setList(ObservableList list){
    	memberData=list;
    }
	public void set(){
		if(style==1){
			a=new MemberVO(id,Integer.parseInt(rankField.getText()),Integer.parseInt(postcodeField.getText()),Integer.parseInt(categoryField.getText()),nameField.getText(),Integer.parseInt(telephoneField.getText()),
addressField.getText(),emailField.getText(),Double.parseDouble(shouldpay.getText()),Double.parseDouble(shouldget.getText()),Double.parseDouble(quota.getText()),MainApp.getID());
		mbs.updateMember(a);
		stage.close();
		}else{
			id++;
			a=new MemberVO(id,Integer.parseInt(rankField.getText()),Integer.parseInt(postcodeField.getText()),Integer.parseInt(categoryField.getText()),nameField.getText(),Integer.parseInt(telephoneField.getText()),
	addressField.getText(),emailField.getText(),0.0,0.0,0.0,MainApp.getID());
			mbs.addMember(a);
			memberData.add(new MemberData(a));
			stage.close();
		}
		
	}
}
