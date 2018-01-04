package presentation.commodityui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import businesslogic.logbl.LogController;
import businesslogic.utilitybl.Utility;
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
import vo.CategoryVO;
import vo.CommodityVO;
import vo.LogVO;

public class CategoryViewController implements Initializable{
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
	private Button enterSon;

	@FXML
	private Button returnFather;
	
	@FXML
	private Button enterCommodity;
	
	@FXML
	private TextField search;
	
	
	private ObservableList<CategoryData> categoryData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CategoryData> categoryTable;
	
	@FXML
	private TableColumn<CategoryData,String> idColoumn;
	
	@FXML
	private TableColumn<CategoryData,String> nameColoumn;
	

	CategoryVO categoryVO=null;

	
	ArrayList<CategoryVO> volist;
	
	CommodityBLService cbs=new CommodityController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		categoryTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getID());
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
	    volist=cbs.findDownCategory(cbs.findCategoryByID(-1));
	    for(CategoryVO s:volist){
			categoryData.add(new CategoryData(s));
			categoryTable.setItems(categoryData);
		}
	}
	private void getInf(CategoryData newValue) {
		if(newValue==null){
			return;
		}
		categoryVO=newValue.getVO();
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
			categoryVO=cbs.findCategoryByID(Long.parseLong(content));
		}else{
			categoryVO=cbs.findCategoryByName(content);
		}
		if(categoryVO==null){
			Alert alert = new Alert(AlertType.WARNING);
   	        alert.initOwner(MainApp.getPrimaryStage());
   	        alert.setTitle("Not Found");
   	        alert.setHeaderText("Not Found");
   	        alert.setContentText("Not Found:"+content);
            alert.showAndWait();
            return;
		}
		categoryData.clear();
		categoryData.add(new CategoryData (categoryVO));
		categoryTable.setItems(categoryData);
	}
	
	@FXML
	public void addCategory(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/commodityui/SimpleCategoryUI.fxml"));
			AnchorPane categoryUI=loader.load();
			Scene scene=new Scene(categoryUI);
			Stage categoryStage=new Stage();
			categoryStage.setTitle("Create/Change Category");
			categoryStage.initModality(Modality.WINDOW_MODAL);
			categoryStage.initOwner(MainApp.getPrimaryStage());
			categoryStage.setScene(scene);
            SimpleCategoryController controller=loader.getController();
            controller.setStage(categoryStage);
            controller.setList(categoryData);
            if(categoryVO==null){
            	controller.setParentID(-1);
            }else{
            	controller.setParentID(categoryVO.getID());
            }
           categoryStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@FXML
	public void deleteCategory(){
		volist=cbs.findDownCategory(categoryVO);
		if(volist==null||volist.size()==0){
			ArrayList<CommodityVO> comlist=cbs.findDownCommodity(categoryVO);
			if(comlist==null||comlist.size()==0){
				long parentid= categoryVO.getParentID();
				int selectedIndex = categoryTable.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					//¼ÇÂ¼ÈÕÖ¾
					LogController logController=new LogController();
					long logID=logController.findLargestID()+1;
					LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"deteleCategory:"+categoryVO.getID(),MainApp.getID());
					logController.addLog(logVO);
					//
					cbs.deleteCategory(categoryVO);
					categoryTable.getItems().remove(selectedIndex);
					if(categoryData.isEmpty()){
						if(parentid!=-1){
							returnFather();
						}
					}
					categoryVO=null;
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.initOwner(MainApp.getPrimaryStage());
					alert.setTitle("Warning");
					alert.setHeaderText("This category already has commodities");
					alert.setContentText("Please select another category in the table.");
					alert.showAndWait();
				}
			} else { 
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(MainApp.getPrimaryStage());
				alert.setTitle("No Selection");
				alert.setHeaderText("No Category Selected");
				alert.setContentText("Please select a category in the table.");
				alert.showAndWait();
			}
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(MainApp.getPrimaryStage());
			alert.setTitle("Warning");
			alert.setHeaderText("No leaf");
			alert.setContentText("Please select a leaf in the table.");
			alert.showAndWait();
		}
	}
	@FXML
	public void updateCategory(){
		try{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/presentation/commodityui/SimpleCategoryUI.fxml"));
		AnchorPane categoryUI=loader.load();
		Scene scene=new Scene(categoryUI);
		Stage categoryStage=new Stage();
		categoryStage.setTitle("Create/Change Category");
		categoryStage.initModality(Modality.WINDOW_MODAL);
		categoryStage.initOwner(MainApp.getPrimaryStage());
		categoryStage.setScene(scene);
        SimpleCategoryController controller=loader.getController();
        controller.setStage(categoryStage);
        controller.setList(categoryData);
        controller.setItem(categoryVO,categoryTable.getSelectionModel().getSelectedItem());
        categoryStage.showAndWait();
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
	public void showStockMainUI(){
		MainApp.showStockMainUI();
	}
	@FXML
	public void enterSon(){
	volist=cbs.findDownCategory(categoryVO);
	//ArrayList<CommodityVO> colist=cbs.findDownCommodity(categoryVO);
		if(volist==null||volist.size()==0){
			Alert alert = new Alert(AlertType.WARNING);
	     	alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No category under this category");
	        alert.setHeaderText("No category under this category");
	        alert.setContentText("No category under this category.");
	        alert.showAndWait();
	        return;
		}else{
			categoryData.clear();
			for(CategoryVO s:volist){
			categoryData.add(new CategoryData(s));
			categoryTable.setItems(categoryData);
		}
	}
	}
	@FXML
	public void returnFather(){
		volist=cbs.findUpCategory(categoryVO);
		if(volist==null||volist.size()==0||categoryVO.getParentID()==-1){
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No Category");
	        alert.setHeaderText("No Category Up");
	        alert.setContentText("Please select another category in the table.");
	        alert.showAndWait();
		}else{
			categoryData.clear();
			for(CategoryVO s:volist){
				categoryData.add(new CategoryData(s));
				categoryTable.setItems(categoryData);
			}
		}
	}
	@FXML
	public void showCommodity(){
		ArrayList<CommodityVO> colist=cbs.findDownCommodity(categoryVO);
		if(colist==null||colist.size()==0){
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No Commodity");
	        alert.setHeaderText("No Commodity Down");
	        alert.setContentText("Please select another category in the table.");
	        alert.showAndWait();
		}else{
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/commodityui/CommodityUI.fxml"));
				AnchorPane commodityUI=loader.load();
				Scene scene=new Scene(commodityUI);
				Stage commodityStage=new Stage();
				commodityStage.setTitle("Commodity");
				commodityStage.initModality(Modality.WINDOW_MODAL);
				commodityStage.initOwner(MainApp.getPrimaryStage());
				commodityStage.setScene(scene);
	            CommodityViewController controller=loader.getController();
	            controller.setStage(commodityStage);
	            controller.setCommoditys(colist);
	           // controller.setparent(categoryVO.getID());
	            //commodityStage.showAndWait();
	            commodityStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}
}
