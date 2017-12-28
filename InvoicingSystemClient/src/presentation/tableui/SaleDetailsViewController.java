package presentation.tableui;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.billbl.CommodityList;
import businesslogic.commoditybl.CommodityController;
import businesslogic.memberbl.MemberController;
import businesslogic.tablebl.SaleDetailsTableController;
import businesslogic.userbl.UserController;
import businesslogicservice.tableblservice.SaleDetailsTableBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import vo.CommodityVO;
import vo.MemberVO;
import vo.SaleBillVO;
import vo.SaleDetailsTableVO;
import vo.UserVO;

public class SaleDetailsViewController  implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Button logoutB;
	@FXML
	private Button confirmB;
	@FXML
	private Button excelB;
	@FXML
	private Button cleanB;
	@FXML
	private Button returnB;
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
	private TextField commodityname;
	@FXML
	private TextField operator;
	@FXML
	private TextField member;
	
	//6¸öcolumn
public  ObservableList<CommodityItemData> commodityData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CommodityItemData> commodityTable;
	
	@FXML
	private TableColumn<CommodityItemData,String> dateColoumn;
	
	@FXML
	private TableColumn<CommodityItemData,String> priceColoumn;
	@FXML
	private TableColumn<CommodityItemData,String> nameColoumn;
	@FXML
	private TableColumn<CommodityItemData,String> modelColoumn;
	
	@FXML
	private TableColumn<CommodityItemData,String> numColoumn;
	@FXML
	private TableColumn<CommodityItemData,String> totalpriceColoumn;
	
	CommodityItemData item=null;
	CommodityList comlist=null;
	SaleDetailsTableVO sdtable=null;
	ArrayList<SaleBillVO> salelist=new ArrayList<SaleBillVO>();
	SaleDetailsTableBLService dtbs=new SaleDetailsTableController();
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
	    nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		numColoumn.setCellValueFactory(cellData ->cellData.getValue().getNumProperty());
		modelColoumn.setCellValueFactory(cellData ->cellData.getValue().getModelProperty());
		priceColoumn.setCellValueFactory(cellData ->cellData.getValue().getPriceProperty());
		totalpriceColoumn.setCellValueFactory(cellData ->cellData.getValue().getTotalPriceProperty());
		dateColoumn.setCellValueFactory(cellData ->cellData.getValue().getDateProperty());
	    commodityTable.setItems(commodityData);
	}

	@FXML
	public void search(){
		commodityData.clear();
		Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
		Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
		String goods=commodityname.getText();
		String	memberl=member.getText();
		String operatorn=operator.getText();
		if(goods.equals("")&&memberl.equals("")&&operatorn.equals("")){
			sdtable=dtbs.findByDate(start, end);
			salelist=sdtable.getList();
			for(SaleBillVO a:salelist){
				comlist=a.getList();
				Date date=a.getTime();
				for(int i=0;i<comlist.getListSize();i++){
					item=new CommodityItemData(comlist.get(i),date);
					commodityData.add(item);
				}
			}
		}else{
			if(memberl!=null&&memberl.length()>0){
				MemberVO memberVO=new MemberController().findMemberByName(memberl);
				if(memberVO==null){
					Alert alert = new Alert(AlertType.WARNING);
		   	        alert.initOwner(MainApp.getPrimaryStage());
		   	        alert.setTitle("No member found");
		   	        alert.setHeaderText("No member found");
		   	        alert.setContentText("No member found:"+memberl);
	                alert.showAndWait();
	                return;
				}
			}
			if(operatorn!=null&&operatorn.length()>0){
				UserVO userVO=new UserController().findUserbyName(operatorn);
				if(userVO==null){
					Alert alert = new Alert(AlertType.WARNING);
		   	        alert.initOwner(MainApp.getPrimaryStage());
		   	        alert.setTitle("No user found");
		   	        alert.setHeaderText("No user found");
		   	        alert.setContentText("No user found:"+operatorn);
	                alert.showAndWait();
	                return;
				}
			}
			if(goods!=null&&goods.length()>0){
				CommodityVO commodityVO=new CommodityController().findCommodityByName(goods);
				if(commodityVO==null){
					Alert alert = new Alert(AlertType.WARNING);
		   	        alert.initOwner(MainApp.getPrimaryStage());
		   	        alert.setTitle("No commodity found");
		   	        alert.setHeaderText("No commodity found");
		   	        alert.setContentText("No commodity found:"+goods);
	                alert.showAndWait();
	                return;
				}
			}
			sdtable=dtbs.findByField(start, end, goods, memberl, operatorn);
			salelist=sdtable.getList();
			for(SaleBillVO a:salelist){
				comlist=a.getList();
				Date date=a.getTime();
				for(int i=0;i<comlist.getListSize();i++){
					item=new CommodityItemData(comlist.get(i),date);
					commodityData.add(item);
				}
			}
		}
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
	public void clean(){
		commodityData.clear();
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
			if(sdtable!=null){
				boolean exportSuccess=dtbs.exportAsExcel(sdtable,filepath);
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
