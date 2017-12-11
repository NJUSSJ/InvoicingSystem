package presentation.commodityui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
	
	Stage stage;
	
	long parentid;
	
private ObservableList<CommodityData> commodityData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CommodityData> commodityTable;
	
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
	
	ArrayList<CommodityVO> colist;
	
	CommodityBLService cbs=new CommodityController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		commodityTable.getSelectionModel().selectedItemProperty().addListener(
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
		try{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/presentation/commodityui/SimpleCommodityUI.fxml"));
		AnchorPane commodityUI=loader.load();
		Scene scene=new Scene(commodityUI);
		Stage commodityStage=new Stage();
		commodityStage.setTitle("Create/Change Commodity");
		commodityStage.initModality(Modality.WINDOW_MODAL);
		commodityStage.initOwner(MainApp.getPrimaryStage());
		commodityStage.setScene(scene);
        SimpleCommodityController controller=loader.getController();
        controller.setStage(commodityStage);
        controller.setParentID(parentid);
        commodityStage.showAndWait();
		}catch (IOException e) {
			// TODO: handle exception
		}
   }
	@FXML
   public void delete(){
		int selectedIndex = commodityTable.getSelectionModel().getSelectedIndex();
	   	 if (selectedIndex >= 0) {
	   		commodityTable.getItems().remove(selectedIndex);
	   			cbs.deleteCommodity(a);
	   	    } else { 
	   	    Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Category Selected");
	        alert.setContentText("Please select a category in the table.");

	        alert.showAndWait();
	    }
   }
	@FXML
	public void update(){
		try{
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/SimpleCommodityUI.fxml"));
			AnchorPane commodityUI=loader.load();
			Scene scene=new Scene(commodityUI);
			Stage commodityStage=new Stage();
			commodityStage.setTitle("Create/Change Commodity");
			commodityStage.initModality(Modality.WINDOW_MODAL);
			commodityStage.initOwner(MainApp.getPrimaryStage());
			commodityStage.setScene(scene);
	        SimpleCommodityController controller=loader.getController();
	        controller.setStage(commodityStage);
	        controller.setItem(a);
	        commodityStage.showAndWait();
			}catch(IOException e) {
				// TODO: handle exception
			}
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
		commodityData.clear();
		String content=search.getText();
		if(content.charAt(0)>='0'&&content.charAt(0)<='9'){
			a=cbs.findCommodityByID(Long.parseLong(content));
			parentid=a.getParent();
			commodityData.add(new CommodityData (a));
			commodityTable.setItems(commodityData);
		}else{
			a=cbs.findCommodityByName(content);
			parentid=a.getParent();
			commodityData.add(new CommodityData (a));
			commodityTable.setItems(commodityData);
		}
	}
	private void getInf(CommodityData newValue) {
		// TODO Auto-generated method stub
		a=newValue.getVO();
	}
	public void setStage(Stage commodityStage) {
		// TODO Auto-generated method stub
		stage=commodityStage;
	}
	public void setCommoditys(ArrayList<CommodityVO> colist) {
		// TODO Auto-generated method stub
		for(CommodityVO a:colist){
			commodityData.add(new CommodityData(a));
		}
		commodityTable.setItems(commodityData);
	}
	public void setparent(long id2) {
		// TODO Auto-generated method stub
		parentid=id2;
	}
}
