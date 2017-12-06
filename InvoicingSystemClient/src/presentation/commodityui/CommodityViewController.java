package presentation.commodityui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vo.CommodityVO;

public class CommodityViewController implements Initializable{
	@FXML
	private Label id;
	
	@FXML
	private Label logout;
	@FXML
	private Button returnB;
	
	@FXML
	private Button addB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private Button updateB;
	
	@FXML
	private Button rightB;
	
	@FXML
	private TextField search;
	
private ObservableList<CommodityData> categoryData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CommodityData> categoryTable;
	
	@FXML
	private TableColumn<CommodityData,String> idColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> nameColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> modelColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> stockNumColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> importPriceColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> salePriceColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> lateImportPriceColoumn;
	
	@FXML
	private TableColumn<CommodityData,String> lateSalePriceColoumn;
	
	CommodityVO a;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		categoryTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getId());
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
	    modelColoumn.setCellValueFactory(cellData ->cellData.getValue().getModel());
		stockNumColoumn.setCellValueFactory(cellData ->cellData.getValue().getNum());
		importPriceColoumn.setCellValueFactory(cellData ->cellData.getValue().getImport());
		salePriceColoumn.setCellValueFactory(cellData ->cellData.getValue().getSale());
		lateImportPriceColoumn.setCellValueFactory(cellData ->cellData.getValue().getLateImport());
		lateSalePriceColoumn.setCellValueFactory(cellData ->cellData.getValue().getLateSale());
	}
	@FXML
   public void add(){
	   
   }
	@FXML
   public void delete(){
	   
   }
	@FXML
	public void update(){
		
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showFiance(){
		MainApp.showFianceMainUI();
	}
	@FXML
	public void search(){
		
	}
	private void getInf(CommodityData newValue) {
		// TODO Auto-generated method stub
		a=newValue.getVO();
	}
}
