package presentation.promotionui;

import java.text.SimpleDateFormat;
import java.util.Date;

import MainApp.MainApp;
import businesslogic.promotionbl.PromotionController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import vo.PricePromotionVO;

public class SimplePricePromotionController {
	@FXML
	private TextField pricelineField;
	@FXML
	private TextField discountField;
	@FXML
	private TextField couponField;
	@FXML
	private Button add;
	@FXML
	private Button back;
	
	private PromotionController pcon=new PromotionController();
	
	private Stage stage;
	@FXML
	public void add(){
		String priceText=pricelineField.getText();
		String discountText=discountField.getText();
		String couponText=couponField.getText();
		if((priceText!=null&&priceText.length()>0)&&(discountText!=null&&discountText.length()>0)&&
				(couponText!=null&&couponText.length()>0)){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			long id=Long.parseLong(sdf.format(new Date()));
			double priceline=Double.parseDouble(priceText);
			double discount=Double.parseDouble(discountText);
			int coupon=Integer.parseInt(couponText);
			PricePromotionVO vo=new PricePromotionVO(id,priceline,discount,coupon);
			pcon.addPricePromotion(vo);
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Add success");
	        alert.setHeaderText("Add Success");
	        alert.setContentText("Add promotion successfully");
	        alert.showAndWait();
	        stage.close();
		}else{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Information lack");
	        alert.setHeaderText("Information lack");
	        alert.setContentText("Please input information completely.");
	        alert.showAndWait();
		}
	}
	@FXML
	public void back(){
		stage.close();
	}
	public void setStage(Stage stage){
		this.stage=stage;
	}
}
