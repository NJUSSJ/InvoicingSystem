package presentation.commodityui;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vo.CommodityVO;

public class SimpleCommodityController {
	Stage stage;
	@FXML
	private Button rightB;
	@FXML
	private Button returnB;
	@FXML
	private TextField name;
	@FXML
	private TextField num;
	@FXML
	private TextField model;
	@FXML
	private TextField saleprice;
	@FXML
	private TextField importprice;
	@FXML
	private TextField parent;
	@FXML
	private TextField warning;
	
	int style=0;

	CommodityBLService cbs=new CommodityController();

	CommodityVO commodityVO;
	public void setStage(Stage commodityStage) {
		stage=commodityStage;
	}
	@FXML
	public void setCommodity(){
		if(style==0){
			long id=cbs.findLargestIDofCommodity()+1;
			if(id>=0){
				commodityVO=new CommodityVO(name.getText(),id,model.getText(),
						Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),
						Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText())
						,Double.parseDouble(saleprice.getText()),Long.parseLong(parent.getText()),
						Integer.parseInt(warning.getText()));
				cbs.addCommodity(commodityVO);
			}else{
				Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(MainApp.getPrimaryStage());
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Error in the database:no suitable id");
		        alert.showAndWait();
			}
		}else{
			commodityVO=new CommodityVO(name.getText(),commodityVO.getID(),model.getText(),
					Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),
					Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText()),
					Double.parseDouble(saleprice.getText()),Long.parseLong(parent.getText()),Integer.parseInt(warning.getText()));
			cbs.updateCommodity(commodityVO);
		}
	}
	@FXML
	public void cancel(){
		stage.close();
	}

	public void setItem(CommodityVO vo) {
		//id=vo.getID();
		parent.setText(vo.getParent()+"");
		if(style==1){
			parent.setEditable(false);
		}
		num.setText(Integer.toString(vo.getStockNum()));
		name.setText(vo.getName());
		model.setText(vo.getModel());
		saleprice.setText(Double.toString(vo.getSalePrice()));
		importprice.setText(Double.toString(vo.getImportPrice()));
		parent.setText(vo.getParent()+"");
		style=1;
		warning.setText(Integer.toString(vo.getLimit()));
		
	}

}
