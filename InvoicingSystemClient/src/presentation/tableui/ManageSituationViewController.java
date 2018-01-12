package presentation.tableui;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.tablebl.OperateConditionTableController;
import businesslogicservice.tableblservice.ManageConditionTableBLService;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import vo.OperateConditionTableVO;

public class ManageSituationViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Button logout;
	
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
	private Button refer;
	
	@FXML
	private Button deriveToExcel;
	
	@FXML
	private Button returnA;

	@FXML
	private Label saleIncome;

	@FXML
	private Label commodityOverIncome;
	
	@FXML
	private Label importReturnIncome;
	
	@FXML
	private Label couponIncome;

	@FXML
	private Label incomeAfterDiscount;

	@FXML
	private Label discount;

	@FXML
	private Label saleCost;

	@FXML
	private Label lossExpense;

	@FXML
	private Label giftExpense;

	@FXML
	private Label totalCost;

	@FXML
	private Label profit;
	
	@FXML
	private Label saleReturn;
	OperateConditionTableVO oct=null;
	ManageConditionTableBLService octbl=new OperateConditionTableController();
	
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
		startMonth.setValue("9");
		startDay.setValue("1");
		endYear.setItems(FXCollections.observableArrayList("2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		endMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		endDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));	
		endYear.setValue("2018");
		endMonth.setValue("9");
		endDay.setValue("1");
		refer.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode().equals(KeyCode.ENTER)) {
					refer();
				}
			}
		});
	}

	@FXML
	public void showtheMain(){
		if(MainApp.getRank()==2){
			MainApp.showFianceMainUI();
		}else{
			MainApp.showManagerMainUI();
		}
	}
	
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	
	@FXML
	public void refer() {
		Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
		Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
		
		oct=octbl.findByInterval(start, end);
		
	
		saleIncome.setText(""+oct.getSaleOriginIncome());
		commodityOverIncome.setText(""+oct.getOverIncome());
		importReturnIncome.setText(""+oct.getImportReturnIncome());
		couponIncome.setText(""+oct.getCouponIncome());
		incomeAfterDiscount.setText(""+oct.getIncome());
		discount.setText(""+oct.getDiscount());
		saleCost.setText(""+oct.getImportExpense());
		lossExpense.setText(""+oct.getLossExpense());
		giftExpense.setText(""+oct.getGiftExpense());
		totalCost.setText(""+oct.getExpense());
		profit.setText(""+oct.getProfit());
		saleReturn.setText(""+oct.getSaleReturnExpense());
		
	}
	
	@FXML
	public void excel(){
	    FileChooser fileChooser=new FileChooser();
		
		//set extension filter
		FileChooser.ExtensionFilter extFilter=new ExtensionFilter("XLS files (*.xls)", "*.xls");
		fileChooser.getExtensionFilters().add(extFilter);
	
		//show save file dialog
		File file=fileChooser.showSaveDialog(MainApp.getPrimaryStage());
		if(file!=null) {
			String filepath=file.getPath();
			if(!filepath.endsWith(".xls")) {
			filepath+=".xls";
			}
			if(oct!=null){
				boolean exportSuccess=octbl.exportAsExcel(oct,filepath);
				if(exportSuccess){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.initOwner(MainApp.getPrimaryStage());
					alert.setTitle("Export Success");
					alert.setHeaderText("Export Success");
					alert.setContentText("Export Success.");
					alert.showAndWait();
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.initOwner(MainApp.getPrimaryStage());
	   	        	alert.setTitle("Export failure");
	   	        	alert.setHeaderText("Export failure");
	   	        	alert.setContentText("Export failure.");
	   	        	alert.showAndWait();
				}
			}else{
				    Alert alert = new Alert(AlertType.WARNING);
		   	        alert.initOwner(MainApp.getPrimaryStage());
		   	        alert.setTitle("No Selection");
		   	        alert.setHeaderText("No Item Selected");
		   	        alert.setContentText("Please select the time.");
	                alert.showAndWait();
			}
		}
		
	}
}


