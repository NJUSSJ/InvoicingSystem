package presentation.promotionui;

import MainApp.MainApp;
import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.commoditybl.CommodityController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.utilitybl.Utility;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.CommodityVO;
import vo.MemberPromotionVO;

public class SimpleMemberPromotionController {
	@FXML
	private TextField rank;
	@FXML
	private TextField coupon;
	@FXML
	private TextField discount;
	@FXML
	private TextField gift;
	@FXML
	private TextField number;
	@FXML
	private Button add;
	@FXML
	private Button back;
	@FXML
	private Button addGift;
	private Stage stage;
	CommodityList list=new CommodityList();
	PromotionController pcon=new PromotionController();
	CommodityController ccon=new CommodityController();
	ObservableList<MemberPromotionData> promotionList;
	@FXML
	public void add(){
		try {
		String rankText=rank.getText();
		String couponText=coupon.getText();
		String discountText=discount.getText();
		if((rankText!=null&&rankText.length()>0)&&(couponText!=null&&couponText.length()>0)
				&&(discountText!=null&&discountText.length()>0)){
			long id=Utility.creatID();
			double discountValue=Double.parseDouble(discountText);
			int rankValue=Integer.parseInt(rankText);
			int couponValue=Integer.parseInt(couponText);
			MemberPromotionVO vo=new MemberPromotionVO(id,rankValue,discountValue,list,couponValue);
			if(discountValue>=1||discountValue<=0||rankValue<=0||rankValue>5||couponValue<=0) {
				/*Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(MainApp.getPrimaryStage());
				alert.setTitle("Add Failed");
				alert.setHeaderText("Add Failed");
				alert.setContentText("Please Check Your Input for Discount!");
				alert.showAndWait();
				stage.close();
				return ;*/
				throw new NumberFormatException();
			}
			
			if(pcon.addMemberPromotion(vo)) {
				MemberPromotionData tmpData=new MemberPromotionData(vo);
				
				promotionList.add(tmpData);
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(MainApp.getPrimaryStage());
				alert.setTitle("Add success");
				alert.setHeaderText("Add Success");
				alert.setContentText("Add promotion successfully");
				alert.showAndWait();
				stage.close();
			}else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(MainApp.getPrimaryStage());
				alert.setTitle("Add Failed");
				alert.setHeaderText("Add Failed");
				alert.setContentText("Add Failed");
				alert.showAndWait();
			}		
		}else{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Information lack");
	        alert.setHeaderText("Information lack");
	        alert.setContentText("Please input information completely.");
	        alert.showAndWait();
		}
		}catch(NumberFormatException e){
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Input error");
	        alert.setHeaderText("Input error");
	        alert.setContentText("Please check input");
	        alert.showAndWait();
		}
	}
	@FXML
	public void addGift(){
		try{
		String name=gift.getText();
		int num=Integer.parseInt(number.getText());
		if(num<=0){
			throw new NumberFormatException();
		}
		if(ccon.findCommodityByName(name)!=null){
			CommodityVO vo=ccon.findCommodityByName(name);
			if(list.hasCommodity(vo.getID())){
				CommodityLineItem item=list.findCommodity(vo.getID());
				item.setNum(item.getNum()+num);
			}else{
				list.addCommodity(new CommodityLineItem(num,vo.getID(),vo.getSalePrice(),vo.getLateImportPrice(),""));
			}
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Add gift success");
	        alert.setHeaderText("Add gift success");
	        alert.setContentText("Add gift success.");
	        alert.showAndWait();
		}else{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Can't find the gift");
	        alert.setHeaderText("Can't find the gift");
	        alert.setContentText("Can't find the gift");
	        alert.showAndWait();
		}
		gift.setText("");
		number.setText("");
		}catch(NumberFormatException e){
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Input error");
	        alert.setHeaderText("Input error");
	        alert.setContentText("Please check input");
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
	public void setList(ObservableList<MemberPromotionData> list) {
		this.promotionList=list;
	}
}
