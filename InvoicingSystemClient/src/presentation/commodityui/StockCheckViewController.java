package presentation.commodityui;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.commoditybl.CommodityController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.StockCheckInfoVO;

public class StockCheckViewController implements Initializable {

	@FXML
	private Label id;
	
	@FXML
	private ChoiceBox<String> startYear;
	
	@FXML
	private ChoiceBox<String> startMonth;
	
	@FXML
	private ChoiceBox<String> startDay;
	
	@FXML
	private ChoiceBox<String> endYear;
	
	@FXML
	private ChoiceBox<String> endMonth;
	
	@FXML
	private ChoiceBox<String> endDay;
	
	@FXML
	private TableView<StockCheckInfoVO> table;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> idColumn;
	
	@FXML
	private TableColumn<StockCheckInfoVO, String> name;
	
	@FXML
	private TableColumn<StockCheckInfoVO, String> model;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> outNum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> inNum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> saleNum;
	
	@FXML 
	private TableColumn<StockCheckInfoVO, Number> importNum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> outSum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> inSum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> saleSum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Number> importSum;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button Return;
	
	@FXML
	private Label LogOut;
	
	private ObservableList<StockCheckInfoVO> StockInfo=FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
		startYear.setItems(FXCollections.observableArrayList("2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		startMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		startDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));
		
		startYear.setValue("2017");
		startMonth.setValue("1");
		startDay.setValue("1");
		
		endYear.setItems(FXCollections.observableArrayList("2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		endMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		endDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));
		
		endYear.setValue("2017");
		endMonth.setValue("12");
		endDay.setValue("31");
	}
	
		
	public void Confrim() {
		if(table.getItems()!=null) {
			table.getItems().clear();
		}
		Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
		Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
		
		ArrayList<StockCheckInfoVO> stockinfolist=new CommodityController().getStockInfo(start, end);
		
		for(int i=0;i<stockinfolist.size();i++) {
			StockInfo.add(stockinfolist.get(i));
		}
		
		name.setCellValueFactory(cellData->cellData.getValue().nameProperty());
		idColumn.setCellValueFactory(cellData->cellData.getValue().IDProperty());
		model.setCellValueFactory(cellData->cellData.getValue().modelProperty());
		outNum.setCellValueFactory(cellData->cellData.getValue().outNumProperty());
		outSum.setCellValueFactory(cellData->cellData.getValue().outSumProperty());
		inNum.setCellValueFactory(cellData->cellData.getValue().inNumProperty());
		inSum.setCellValueFactory(cellData->cellData.getValue().inSumProperty());
		saleNum.setCellValueFactory(cellData->cellData.getValue().saleNumProperty());
		saleSum.setCellValueFactory(cellData->cellData.getValue().saleSumProperty());
		importNum.setCellValueFactory(cellData->cellData.getValue().importNumProperty());
		importSum.setCellValueFactory(cellData->cellData.getValue().importSumProperty());
		
		table.setItems(StockInfo);
	}
	
	
	
	public void ReturnToMain() {
		MainApp.showStockMainUI();
	}
	
	public void LogOut() {
		MainApp.setUser(null);
		MainApp.showLoginUI();
	}
	
	}



	
	
