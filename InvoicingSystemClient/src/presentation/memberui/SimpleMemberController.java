package presentation.memberui;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.logbl.LogController;
import businesslogic.memberbl.MemberController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.memberblservice.MemberBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.LogVO;
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


	private ObservableList<MemberData> list =FXCollections.observableArrayList();
	int style=0;//style=1  修改/0 新增


	MemberBLService mbs=new MemberController();

	MemberVO memberVO;

	MemberData memberData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		operator.setText(MainApp.getID()+"");
	}

	public void setStage(Stage memberStage) {
		stage=memberStage;
	}
	public void setMember(MemberVO me) {
		memberVO=me;
		nameField.setText(memberVO.getName());
		rankField.setText(Integer.toString(memberVO.getRank()));
		categoryField.setText(Integer.toString(memberVO.getCategory()));
		emailField.setText(memberVO.getEmail());
		addressField.setText(memberVO.getAddress());
		postcodeField.setText(Integer.toString(memberVO.getPostCode()));
		telephoneField.setText(Long.toString(memberVO.getPhoneNum()));
		shouldget.setText(memberVO.getShouldGet()+"");
		shouldpay.setText(memberVO.getShouldPay()+"");
		quota.setText(memberVO.getQuota()+"");
		style=1;
	}
    public void cancel(){
    	stage.close();
    }
    public void setList(ObservableList<MemberData> list){
    	this.list=list;
    }
    public void setMemberData(MemberData data){
    	memberData=data;
    }
	public void set(){
		if(style==1){
			try {
				memberVO=new MemberVO(memberVO.getID(),Integer.parseInt(rankField.getText()),
						Integer.parseInt(postcodeField.getText()),Integer.parseInt(categoryField.getText()),
						nameField.getText(),Long.parseLong(telephoneField.getText()),addressField.getText(),
						emailField.getText(),Double.parseDouble(shouldpay.getText()),Double.parseDouble(shouldget.getText()),
						Double.parseDouble(quota.getText()),MainApp.getID());
					mbs.updateMember(memberVO);
					memberData.setMemberVO(memberVO);
					//记录日志
					LogController logController=new LogController();
					long logID=logController.findLargestID()+1;
			        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"updateMember:"+memberVO.getID(),MainApp.getID());
			        logController.addLog(logVO);
			        //
					stage.close();
			} catch (NumberFormatException e) {
				Alert alert=new Alert(AlertType.WARNING);
				alert.setContentText("Please check your input!");
				alert.showAndWait();
			}
		}else{
			long largest=-1;
			for(int i=0;i<list.size();i++) {
				if(Long.parseLong(list.get(i).getidProperty().get())>largest)
					largest=Long.parseLong(list.get(i).getidProperty().get());
			}
			String id=largest+1+"";
			while(id.length()<5) {
				id="0"+id;
			}
			try {
				memberVO=new MemberVO(Long.parseLong(id),Integer.parseInt(rankField.getText()),
					Integer.parseInt(postcodeField.getText()),Integer.parseInt(categoryField.getText()),
					nameField.getText(),Long.parseLong(telephoneField.getText()),
					addressField.getText(),emailField.getText(),0.0,0.0,0.0,MainApp.getID());
			mbs.addMember(memberVO);
			list.add(new MemberData(memberVO));
			//记录日志
			LogController logController=new LogController();
			long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"addMember:"+memberVO.getID(),MainApp.getID());
	        logController.addLog(logVO);
	        //
			stage.close();
			} catch (NumberFormatException e) {
				Alert alert=new Alert(AlertType.WARNING);
				alert.setContentText("Please check your input!");
				alert.showAndWait();
			}
			
		}
		
	}
}
