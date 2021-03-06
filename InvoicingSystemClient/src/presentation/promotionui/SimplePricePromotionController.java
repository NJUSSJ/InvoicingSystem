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
import vo.PricePromotionVO;

public class SimplePricePromotionController {
	@FXML
	private TextField pricelineField;
	@FXML
	private TextField giftNameField;
	@FXML
	private TextField numField;
	@FXML
	private TextField couponField;
	@FXML
	private Button add;
	@FXML
	private Button back;
	@FXML
	private Button addGift;
	private PromotionController pcon=new PromotionController();
	private CommodityController ccon=new CommodityController();
	private Stage stage;
	private CommodityList list=new CommodityList();
	private ObservableList<PricePromotionData> tableList;
	public void setList(ObservableList<PricePromotionData> tableList){
		this.tableList=tableList;
	}
	
	@FXML
	public void add(){
		try{
		String priceText=pricelineField.getText();
		String couponText=couponField.getText();
		if((priceText!=null&&priceText.length()>0)&&(couponText!=null&&couponText.length()>0)){
			long id=Utility.creatID();
			double priceline=Double.parseDouble(priceText);
			int coupon=Integer.parseInt(couponText);
			if(priceline<=0||coupon<=0){
				throw new NumberFormatException();
			}
			PricePromotionVO vo=new PricePromotionVO(id,priceline,list,coupon);
			pcon.addPricePromotion(vo);
			tableList.add(new PricePromotionData(vo));
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
		try {
		String name=giftNameField.getText();
		int num=Integer.parseInt(numField.getText());
		
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
}
