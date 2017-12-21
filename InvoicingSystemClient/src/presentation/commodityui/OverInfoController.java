package presentation.commodityui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.billbl.LossBillController;
import businesslogicservice.billblservice.LossBillBLService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vo.LossBillVO;
import vo.OverBillVO;

public class OverInfoController implements Initializable{
private Stage stage;
	
	@FXML
	private Label name;
	@FXML
	private Label num;
	@FXML
	private Label sum;
	@FXML
	private Button confirm;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setStage(Stage stage) {
		this.stage=stage;
	}
	
	public void setInfo(String name,int num, double sum) {
		this.name.setText(name);
		this.num.setText(num+"");
		this.sum.setText(sum+"");
	}
	
	@FXML
	public void confirm() {
		/*
		 * ¥Ê¥¢±®“Á–≈œ¢
		 */
		Date today=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
		String idS=format.format(today);
		idS=idS.replaceAll(":", "");
		long id=Long.parseLong(idS);
		java.sql.Date sqlDate=DateUtil.toSQL(today);
		LossBillVO lossbill=new LossBillVO(id, MainApp.getID(),name.getText(), sqlDate, 0, Integer.parseInt(num.getText()), Double.parseDouble(sum.getText()));
		LossBillBLService lossbillservice=new LossBillController();
		lossbillservice.submitLossBill(lossbill);
		stage.close();
	}

	public void setVo(OverBillVO m) {
		// TODO Auto-generated method stub
		
	}
}
