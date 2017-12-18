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

CommodityVO a;
	public void setStage(Stage commodityStage) {
		// TODO Auto-generated method stub
		stage=commodityStage;
	}
	@FXML
	public void setCommodity(){
		if(style==0){
			id++;
			a=new CommodityVO(name.getText(),tempid,model.getText(),Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),parentid,Integer.parseInt(warning.getText()));
	        cbs.addCommodity(a);
		}else{
			a=new CommodityVO(name.getText(),tempid,model.getText(),Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText()),Double.parseDouble(saleprice.getText()),parentid,Integer.parseInt(warning.getText()));
			cbs.updateCommodity(a);
		}
	}
	@FXML
	public void cancel(){
		stage.close();
	}
	public void setParentID(long parentid) {
		// TODO Auto-generated method stub
		this.parentid=parentid;
	}

	public void setItem(CommodityVO a) {
		// TODO Auto-generated method stub
		tempid=a.getID();
		parentid=a.getParent();
		num.setText(Integer.toString(a.getStockNum()));
		name.setText(a.getName());
		model.setText(a.getModel());
		saleprice.setText(Double.toString(a.getSalePrice()));
		importprice.setText(Double.toString(a.getImportPrice()));
		style=1;
		warning.setText(Integer.toString(a.getLimit()));
	}

}
