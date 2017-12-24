package presentation.commodityui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogicservice.billblservice.LossBillBLService;
import businesslogicservice.billblservice.OverBillBLService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
	@FXML
	private Button reviseB;
	
	OverBillVO unpassbill=null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		reviseB.setVisible(false);
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
	public void revise(){
		Date today=new Date();
		java.sql.Date sqlDate=DateUtil.toSQL(today);
		OverBillVO overbill=new OverBillVO(unpassbill.getID(), MainApp.getID(),name.getText(), sqlDate, 0, Integer.parseInt(num.getText()), Double.parseDouble(sum.getText()));
		OverBillBLService overbillservice=new OverBillController();
		overbillservice.deleteOverBill(unpassbill);
		boolean success=overbillservice.submitOverBill(overbill);
		if(success) {
			Alert Information=new Alert(AlertType.INFORMATION);
			Information.setTitle("SUCCESS");
			Information.setContentText("发送报溢单成功！");
			Information.showAndWait();
			stage.close();
		}else {
			Alert Information=new Alert(AlertType.INFORMATION);
			Information.setTitle("FAILE");
			Information.setContentText("发送报溢单失败！");
			Information.showAndWait();
		}
		stage.close();
	}
	@FXML
	public void confirm() {
		/*
		 * 存储报溢信息
		 */
		Date today=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
		String idS=format.format(today);
		idS=idS.replaceAll(":", "");
		long id=Long.parseLong(idS);
		java.sql.Date sqlDate=DateUtil.toSQL(today);
		OverBillVO overbill=new OverBillVO(id, MainApp.getID(),name.getText(), sqlDate, 0, Integer.parseInt(num.getText()), Double.parseDouble(sum.getText()));
		OverBillBLService overbillservice=new OverBillController();
		boolean success=overbillservice.submitOverBill(overbill);
		if(success) {
			Alert Information=new Alert(AlertType.INFORMATION);
			Information.setTitle("SUCCESS");
			Information.setContentText("发送报溢单成功！");
			Information.showAndWait();
			stage.close();
		}else {
			Alert Information=new Alert(AlertType.INFORMATION);
			Information.setTitle("FAILE");
			Information.setContentText("发送报溢单失败！");
			Information.showAndWait();
		}
		stage.close();
	}

	public void setVo(OverBillVO m) {
		// TODO Auto-generated method stub
		  name.setText(""+m.getCommodityName());
		    num.setText(""+m.getNum());
			sum.setText(""+m.getSum());
		    confirm.setVisible(false);
	}

	public void setVO(OverBillVO m) {
		// TODO Auto-generated method stub
		  unpassbill=m;
		  name.setText(""+m.getCommodityName());
		  num.setText(""+m.getNum());
		  sum.setText(""+m.getSum());
		  confirm.setVisible(false);
		  reviseB.setVisible(true);
	}
}
