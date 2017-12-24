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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vo.LossBillVO;

public class LossInfoController implements Initializable{

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
		 * 存储报损信息
		 */
		Date today=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
		String idS=format.format(today);
		idS=idS.replaceAll(":", "");
		long id=Long.parseLong(idS);
		java.sql.Date sqlDate=DateUtil.toSQL(today);
		int lossNum=Integer.parseInt(num.getText());
		double lossSum=Double.parseDouble(sum.getText());
		LossBillVO lossbill=new LossBillVO(id, MainApp.getID(), name.getText(), sqlDate, 0, lossNum, lossSum);
		LossBillBLService lossbillservice=new LossBillController();
		boolean success=lossbillservice.submitLossBill(lossbill);
		if(success) {
			Alert Information=new Alert(AlertType.INFORMATION);
			Information.setTitle("SUCCESS");
			Information.setContentText("发送报损单成功！");
			Information.showAndWait();
			stage.close();
		}else {
			Alert Information=new Alert(AlertType.INFORMATION);
			Information.setTitle("FAILE");
			Information.setContentText("发送报损单失败！");
			Information.showAndWait();
		}
		stage.close();
	}

	public void setVo(LossBillVO m) {
		// TODO Auto-generated method stub
		    name.setText(m.getCommodityName());;
		    num.setText(""+m.getNum());
			sum.setText(""+m.getSum());
		    confirm.setVisible(false);
	}

	public void setVO(LossBillVO m) {
		// TODO Auto-generated method stub
		
	}

}
