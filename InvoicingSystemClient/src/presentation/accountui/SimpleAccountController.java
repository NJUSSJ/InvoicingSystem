package presentation.accountui;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.accountbl.AccountController;
import businesslogic.logbl.LogController;
import businesslogic.utilitybl.Utility;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.AccountVO;
import vo.LogVO;

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
	 
	int style=0;//style=1  修改/0 新增
	
	AccountData data;
	ObservableList<AccountData> list;
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
	@FXML
	public void rightSet(){
		if(style==0) {
			try {
				String id=idField.getText();
				String name=nameField.getText();
				String deposit=accountField.getText();
				
				if(id.length()<9) {
					Alert warning=new Alert(AlertType.WARNING);
					warning.setContentText("Please Check Your Input!");
					warning.showAndWait();
					return;
				}
				
				AccountVO tmpVO=new AccountVO(Long.parseLong(id),Double.parseDouble(deposit), name);
				new AccountController().addAccount(tmpVO);
				
				AccountData tmpData=new AccountData(tmpVO);
				list.add(tmpData);
				//记录日志
				LogController logController=new LogController();
				long logID=logController.findLargestID()+1;
    	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"addAccount:"+tmpVO.getID(),MainApp.getID());
    	        logController.addLog(logVO);
				stage.close();
			} catch (NumberFormatException e) {
				Alert warning=new Alert(AlertType.WARNING);
				warning.setContentText("Please Check Your Input!");
				warning.showAndWait();
			}
		}else {
			try {
				String id=idField.getText();
				String name=nameField.getText();
				String deposit=accountField.getText();
				
				if(id.length()<9) {
					Alert warning=new Alert(AlertType.WARNING);
					warning.setContentText("Please Check Your Input!");
					warning.showAndWait();
					return;
				}
				
				AccountVO tmpVO=new AccountVO(Long.parseLong(id),Double.parseDouble(deposit), name);
				if(new AccountController().updateAccount(tmpVO)) {
					data.setDeposit(Double.parseDouble(deposit)+"");
					data.setID(id);
					data.setName(name);
					//记录日志
					LogController logController=new LogController();
					long logID=logController.findLargestID()+1;
	    	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"updateAccount:"+tmpVO.getID(),MainApp.getID());
	    	        logController.addLog(logVO);
				}
				else {
					Alert warning=new Alert(AlertType.WARNING);
					warning.setContentText("修改失败！");
					warning.showAndWait();
				}
				
				
				
				stage.close();
			} catch (NumberFormatException e) {
				Alert warning=new Alert(AlertType.WARNING);
				warning.setContentText("Please Check Your Input!");
				warning.showAndWait();
			}
		}
		
	}
	@FXML
	public void cancelSet(){
		stage.close();
	}

	public void setStage(Stage writeStage) {
		stage=writeStage;
	}

	public void setSelect(AccountData data) {
		this.data=data;
		nameField.setText(data.getNameProperty().get());
		accountField.setText(data.getDepositProperty().get());
		idField.setText(data.getidProperty().get());
	}
	public void setStyle(int style) {
		this.style=style;
	}
	public void setList(ObservableList<AccountData> list) {
		this.list=list;
	}
	
}
