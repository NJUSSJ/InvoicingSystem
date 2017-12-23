package presentation.commodityui;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.CommodityVO;

public class SimpleCommodityController {
	Stage stage;
	static long id=0;
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
	private TextField warning;

	long parentid;

	long tempid=id;

	int style=0;

	CommodityBLService cbs=new CommodityController();

	CommodityVO commodityVO;
	public void setStage(Stage commodityStage) {
		stage=commodityStage;
	}
	@FXML
	public void setCommodity(){
		if(style==0){
			id++;
			commodityVO=new CommodityVO(name.getText(),tempid,model.getText(),Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),parentid,Integer.parseInt(warning.getText()));
	        cbs.addCommodity(commodityVO);
		}else{
			commodityVO=new CommodityVO(name.getText(),tempid,model.getText(),Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),parentid,Integer.parseInt(warning.getText()));
			cbs.updateCommodity(commodityVO);
		}
	}
	@FXML
	public void cancel(){
		stage.close();
	}
	public void setParentID(long parentid) {
		this.parentid=parentid;
	}

	public void setItem(CommodityVO vo) {
		tempid=vo.getID();
		parentid=vo.getParent();
		num.setText(Integer.toString(vo.getStockNum()));
		name.setText(vo.getName());
		model.setText(vo.getModel());
		saleprice.setText(Double.toString(vo.getSalePrice()));
		importprice.setText(Double.toString(vo.getImportPrice()));
		style=1;
		warning.setText(Integer.toString(vo.getLimit()));
	}

}
