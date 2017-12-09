package presentation.commodityui;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
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
	private TableColumn<StockCheckInfoVO, Long> idColumn;
	
	@FXML
	private TableColumn<StockCheckInfoVO, String> name;
	
	@FXML
	private TableColumn<StockCheckInfoVO, String> model;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Integer> outNum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Integer> inNum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Integer> saleNum;
	
	@FXML 
	private TableColumn<StockCheckInfoVO, Integer> importNum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Double> outSum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Double> inSum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Double> saleSum;
	
	@FXML
	private TableColumn<StockCheckInfoVO, Double> importSum;
	
	@FXML
	private Button confirm;
	
	private ObservableList<StockCheckInfoVO> StockInfo=FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		id.setText("ID:"+MainApp.getID());
		
		startYear.setItems(FXCollections.observableArrayList("2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		startMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		startDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));
		
		endYear.setItems(FXCollections.observableArrayList("2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		endMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		endDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));	}
	
	public void Confrim() {
		Date start=DateUtil.toSQL(startYear.getSelectionModel().getSelectedItem(),startMonth.getSelectionModel().getSelectedItem(),startDay.getSelectionModel().getSelectedItem());		
		Date end=DateUtil.toSQL(endYear.getSelectionModel().getSelectedItem(), endMonth.getSelectionModel().getSelectedItem(), endDay.getSelectionModel().getSelectedItem());
		
		
	}
	
	
	
	
	
	}



	
	
