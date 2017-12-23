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
	private Button logout;
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
	
	//long parentid;
	
	private ObservableList<CommodityData> commodityData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CommodityData> commodityTable;
	
	@FXML
	private TableColumn<CommodityData,String> idColumn;
	
	@FXML
	private TableColumn<CommodityData,String> nameColumn;
	
	@FXML
	private TableColumn<CommodityData,String> modelColumn;
	
	@FXML
	private TableColumn<CommodityData,String> stockNumColumn;
	
	@FXML
	private TableColumn<CommodityData,String> importPriceColumn;
	
	@FXML
	private TableColumn<CommodityData,String> salePriceColumn;
	
	@FXML
	private TableColumn<CommodityData,String> lateImportPriceColumn;
	
	@FXML
	private TableColumn<CommodityData,String> lateSalePriceColumn;
	
	@FXML
	private TableColumn<CommodityData,String> parentColumn;
	CommodityVO commodityVO;
	
	ArrayList<CommodityVO> colist;
	
	CommodityBLService cbs=new CommodityController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		commodityTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColumn.setCellValueFactory(cellData ->cellData.getValue().getId());
		nameColumn.setCellValueFactory(cellData ->cellData.getValue().getName());
	    modelColumn.setCellValueFactory(cellData ->cellData.getValue().getModel());
		stockNumColumn.setCellValueFactory(cellData ->cellData.getValue().getNum());
		importPriceColumn.setCellValueFactory(cellData ->cellData.getValue().getImport());
		salePriceColumn.setCellValueFactory(cellData ->cellData.getValue().getSale());
		lateImportPriceColumn.setCellValueFactory(cellData ->cellData.getValue().getLateImport());
		lateSalePriceColumn.setCellValueFactory(cellData ->cellData.getValue().getLateSale());
		parentColumn.setCellValueFactory(cellData ->cellData.getValue().getParent());
		colist=cbs.findCommodities();
		for(CommodityVO vo:colist){
			commodityData.add(new CommodityData(vo));
		}
		commodityTable.setItems(commodityData);
	}
	@FXML
   public void add(){
		try{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/presentation/commodityui/SimpleCommodity.fxml"));
		AnchorPane commodityUI=loader.load();
		Scene scene=new Scene(commodityUI);
		Stage commodityStage=new Stage();
		commodityStage.setTitle("Create/Change Commodity");
		commodityStage.initModality(Modality.WINDOW_MODAL);
		commodityStage.initOwner(MainApp.getPrimaryStage());
		commodityStage.setScene(scene);
        SimpleCommodityController controller=loader.getController();
        controller.setStage(commodityStage);
        //controller.setParentID(parentid);
        controller.setList(commodityData);
        commodityStage.showAndWait();
		}catch (IOException e) {
			e.printStackTrace();
		}
   }
	@FXML
   public void delete(){
		int selectedIndex = commodityTable.getSelectionModel().getSelectedIndex();
	   	 	if (selectedIndex >= 0) {
	   	 		cbs.deleteCommodity(commodityVO);
	   	 		commodityTable.getItems().remove(selectedIndex);
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
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/SimpleCommodity.fxml"));
			AnchorPane commodityUI=loader.load();
			Scene scene=new Scene(commodityUI);
			Stage commodityStage=new Stage();
			commodityStage.setTitle("Create/Change Commodity");
			commodityStage.initModality(Modality.WINDOW_MODAL);
			commodityStage.initOwner(MainApp.getPrimaryStage());
			commodityStage.setScene(scene);
	        SimpleCommodityController controller=loader.getController();
	        controller.setStage(commodityStage);
	        controller.setItem(commodityTable.getSelectionModel().getSelectedItem());
	        controller.setList(commodityData);
	        commodityStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showStockMain(){
		MainApp.showStockMainUI();
	}
	@FXML
	public void search(){
		String content=search.getText();
		if(content==null||content.length()<=0){
			 Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("No Input");
	   	        alert.setHeaderText("No Input");
	   	        alert.setContentText("Please input first.");
	            alert.showAndWait();
	            return;
		}
		if(content.charAt(0)>='0'&&content.charAt(0)<='9'){
			commodityVO=cbs.findCommodityByID(Long.parseLong(content));
			//parentid=commodityVO.getParent();
			if(commodityVO==null){
				Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("Not Found");
	   	        alert.setHeaderText("Not Found");
	   	        alert.setContentText("Not Found:"+content);
	            alert.showAndWait();
	            return;
			}
			commodityData.clear();
			commodityData.add(new CommodityData (commodityVO));
			//commodityTable.setItems(commodityData);
		}else{
			ArrayList<CommodityVO> vos=cbs.findCommodityByField(content);
			if(vos==null||vos.size()<=0){
				Alert alert = new Alert(AlertType.WARNING);
	   	        alert.initOwner(MainApp.getPrimaryStage());
	   	        alert.setTitle("Not Found");
	   	        alert.setHeaderText("Not Found");
	   	        alert.setContentText("Not Found:"+content);
	            alert.showAndWait();
	            return;
			}
			//parentid=commodityVO.getParent();
			commodityData.clear();
			for(CommodityVO vo:vos){
				commodityData.add(new CommodityData (vo));
				//commodityTable.setItems(commodityData);
			}
		}
	}
	private void getInf(CommodityData newValue) {
		if(newValue==null){
			return;
		}
		commodityVO=newValue.getVO();
	}
	public void setStage(Stage commodityStage) {
		stage=commodityStage;
	}
	public void setCommoditys(ArrayList<CommodityVO> colist) {
		for(CommodityVO a:colist){
			commodityData.add(new CommodityData(a));
		}
		commodityTable.setItems(commodityData);
	}
	/*public void setparent(long id) {
		parentid=id;
	}*/
}
