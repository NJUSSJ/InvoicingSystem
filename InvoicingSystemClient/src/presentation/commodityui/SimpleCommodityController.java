package presentation.commodityui;

import java.sql.Date;
import java.util.ArrayList;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import businesslogic.logbl.LogController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vo.CategoryVO;
import vo.CommodityVO;
import vo.LogVO;

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
	
	private ObservableList<CommodityData> list=null;
	int style=0;
	CommodityBLService cbs=new CommodityController();

	CommodityVO commodityVO;
	CommodityData data;
	public void setStage(Stage commodityStage) {
		stage=commodityStage;
	}
	@FXML
	public void setCommodity(){
		if(style==0){
			long id=cbs.findLargestIDofCommodity()+1;
			if(id>=0){
				String parentName=parent.getText();
				CategoryVO parentCategory=cbs.findCategoryByName(parentName);
				if(parentCategory==null){
					Alert alert = new Alert(AlertType.WARNING);
			        alert.initOwner(MainApp.getPrimaryStage());
			        alert.setTitle("Parent not found");
			        alert.setHeaderText("Parent not found");
			        alert.setContentText("Parent not found:"+parentName);
			        alert.showAndWait();
			        return;
				}
				ArrayList<CategoryVO> down=cbs.findDownCategory(parentCategory);
				if(down!=null&&down.size()>0){
					Alert alert = new Alert(AlertType.WARNING);
			        alert.initOwner(MainApp.getPrimaryStage());
			        alert.setTitle("Parent error");
			        alert.setHeaderText("Parent error");
			        alert.setContentText("Parent is not leaf node:"+parentName);
			        alert.showAndWait();
			        return;
				}
				commodityVO=new CommodityVO(name.getText(),id,model.getText(),
						Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),
						Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText())
						,Double.parseDouble(saleprice.getText()),parentCategory.getID(),
						Integer.parseInt(warning.getText()));
				cbs.addCommodity(commodityVO);
				//记录日志
				LogController logController=new LogController();
				long logID=logController.findLargestID()+1;
    	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"addCommodity:"+commodityVO.getID(),MainApp.getID());
    	        logController.addLog(logVO);
    	        //
				list.add(new CommodityData(commodityVO));
			}else{
				Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(MainApp.getPrimaryStage());
		        alert.setTitle("Error");
		        alert.setHeaderText("Error");
		        alert.setContentText("Error in the database:no suitable id");
		        alert.showAndWait();
			}
		}else{
			commodityVO=new CommodityVO(name.getText(),Long.parseLong(data.getId().get()),model.getText(),
					Integer.parseInt(num.getText()),Double.parseDouble(importprice.getText()),
					Double.parseDouble(saleprice.getText()),Double.parseDouble(importprice.getText()),
					Double.parseDouble(saleprice.getText()),Long.parseLong(parent.getText()),Integer.parseInt(warning.getText()));
			cbs.updateCommodity(commodityVO);
			//记录日志
			LogController logController=new LogController();
			long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"updateCommodity:"+commodityVO.getID(),MainApp.getID());
	        logController.addLog(logVO);
	        //
			data.setVO(commodityVO);
		}
		stage.close();
	}
	@FXML
	public void cancel(){
		stage.close();
	}

	public void setItem(CommodityData data) {
		//id=vo.getID();
		this.data=data;
		CommodityVO vo=data.getVO();
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
	public void setList(ObservableList<CommodityData> list){
		this.list=list;
	}
}
