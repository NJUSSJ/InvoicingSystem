package presentation.promotionui;

import MainApp.MainApp;
import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.commoditybl.CommodityController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.utilitybl.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vo.CommodityVO;
import vo.PackagePromotionVO;

public class SimplePackagePromotionController {
	@FXML
	private TextField discountField;
	@FXML
	private TextField nameField;
	@FXML
	private Button add;
	@FXML
	private Button back;
	@FXML
	private Button addCommodity;
	private PromotionController pcon=new PromotionController();
	private CommodityController ccon=new CommodityController();
	private Stage stage;
	private CommodityList list=new CommodityList();
	private ObservableList<PackagePromotionData> tableList;
	public void setList(ObservableList<PackagePromotionData> tableList){
		this.tableList=tableList;
	}	
	@FXML
	public void add(){
		String discountText=discountField.getText();
		if((discountText!=null&&discountText.length()>0)){
			long id=Utility.creatID();
			double discountline=Double.parseDouble(discountText);
			PackagePromotionVO vo=new PackagePromotionVO(id,list,discountline);
			pcon.addPackagePromotion(vo);
			tableList.add(new PackagePromotionData(vo));
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
	public void addCommodity(){
		String name=nameField.getText();
		if(ccon.findCommodityByName(name)!=null){
			CommodityVO vo=ccon.findCommodityByName(name);
			if(!list.hasCommodity(vo.getID())){
				list.addCommodity(new CommodityLineItem(0,vo.getID(),vo.getSalePrice(),vo.getLateImportPrice(),""));
			}
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Add commodity success");
	        alert.setHeaderText("Add commodity success");
	        alert.setContentText("Add commodity success.");
	        alert.showAndWait();
		}else{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Can't find the commodity");
	        alert.setHeaderText("Can't find the commodity");
	        alert.setContentText("Can't find the commodity");
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
