package presentation.commodityui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.StockInventoryInfoVO;

public class StockInventoryViewController implements Initializable {
	@FXML
	private Label LogOut;
	
	@FXML
	private Button Invent;
	
	@FXML
	private Button Export;
	
	@FXML
	private Button Return;
	
	@FXML
	private TableView<StockInventoryInfoVO> table;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, Number> lineNum;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, String> name;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, String> model;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, Number> stockNum;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, Number> averagePrice;
	
	@FXML
	private TableColumn<StockInventoryInfoVO, String> finishedTime;
	
	@FXML
	private Label todayDate;
	
	@FXML
	private Label ID;

	private ObservableList<StockInventoryInfoVO> InventoryInfo=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Date todayDate=new Date();
		String tmp=todayDate.toString();
		this.todayDate.setText(tmp);
		
		ArrayList<StockInventoryInfoVO> list=new CommodityController().getInventoryInfo();
		
		for(int i=0;i<list.size();i++) {
			InventoryInfo.add(list.get(i));
		}
		
		
		lineNum.setCellValueFactory(cellData->cellData.getValue().lineNumProperty());
		name.setCellValueFactory(cellData->cellData.getValue().NameProperty());
		model.setCellValueFactory(cellData->cellData.getValue().ModelProperty());
		stockNum.setCellValueFactory(cellData->cellData.getValue().StockProperty());
		averagePrice.setCellValueFactory(cellData->cellData.getValue().AveragePriceProperty());
		finishedTime.setCellValueFactory(cellData->cellData.getValue().FinishedTimeProperty());
		
		table.setItems(InventoryInfo);
		
      
	}
	
	public void Invent() {
		StockInventoryInfoVO info=table.getSelectionModel().getSelectedItem();
		if(info==null) {
			Alert error=new Alert(Alert.AlertType.WARNING);
        	error.setTitle("No Selection");
        	error.setHeaderText("No commodity seleted");
        	error.setContentText("Please select a commodity");
        	error.showAndWait();
		}
		else {
			MainApp.showStockInventorySub(info);
		}
		
		
	}
	
	public void Return() {
		
	}
	
	public void Export() {
		
	}
	
}
