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
import vo.CategoryVO;
import vo.CommodityVO;

public class CategoryViewController implements Initializable{
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
	private Button enterSon;

	@FXML
	private Button returnFather;
	
	@FXML
	private Button enterCommodity;
	
	@FXML
	private TextField search;
	
	static long cateid=0;
	
	private ObservableList<CategoryData> categoryData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<CategoryData> categoryTable;
	
	@FXML
	private TableColumn<CategoryData,String> idColoumn;
	
	@FXML
	private TableColumn<CategoryData,String> nameColoumn;
	
	CategoryVO a;
	
	ArrayList<CategoryVO> volist;
	
	CommodityBLService cbs=new CommodityController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		categoryTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getId());
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
	}
	private void getInf(CategoryData newValue) {
		a=newValue.getVO();
	}
	@FXML
	public void search(){
		String content=search.getText();
		if(content.charAt(0)>='0'&&content.charAt(0)<='9'){
			a=cbs.findCategoryByID(Long.parseLong(content));
			categoryData.add(new CategoryData (a));
			categoryTable.setItems(categoryData);
		}else{
			a=cbs.findCategoryByName(content);
			categoryData.add(new CategoryData (a));
			categoryTable.setItems(categoryData);
		}
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
            controller.setParentID(a.getParentID());
           categoryStage.showAndWait();
            
		} catch (IOException e) {
			// TODO: handle exception
		}

	}
	@FXML
	public void deleteCategory(){
		volist=cbs.findDownCategory(a);
		if(volist==null||volist.size()==0){
		int selectedIndex = categoryTable.getSelectionModel().getSelectedIndex();
   	 if (selectedIndex >= 0) {
   	        categoryTable.getItems().remove(selectedIndex);
   			cbs.deleteCategory(a);
   	    } else { 
   	    Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(MainApp.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Category Selected");
        alert.setContentText("Please select a category in the table.");

        alert.showAndWait();
    }}else{
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
        controller.setItem(a);
       categoryStage.showAndWait();
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
	public void showStockMainUI(){
		MainApp.showStockMainUI();
	}
	@FXML
	public void enterSon(){
	volist=cbs.findDownCategory(a);
	if(volist==null||volist.size()==0){
		Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(MainApp.getPrimaryStage());
        alert.setTitle("No Category");
        alert.setHeaderText("No Category Down");
        alert.setContentText("Please select another category in the table.");
        alert.showAndWait();
	}else{
		for(CategoryVO s:volist){
			categoryData.add(new CategoryData(s));
			categoryTable.setItems(categoryData);
		}
	}
	}
	@FXML
	public void returnFather(){
		volist=cbs.findUpCategory(a);
		if(volist==null||volist.size()==0){
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No Category");
	        alert.setHeaderText("No Category Up");
	        alert.setContentText("Please select another category in the table.");
	        alert.showAndWait();
		}else{
			for(CategoryVO s:volist){
				categoryData.add(new CategoryData(s));
				categoryTable.setItems(categoryData);
			}
		}
	}
	@FXML
	public void showCommodity(){
		ArrayList<CommodityVO> colist;
		colist=cbs.findDownCommodity(a);
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
	            controller.setparent(a.getID());
	            commodityStage.showAndWait();
	            
			} catch (IOException e) {
				// TODO: handle exception
			}
	}
	}
}
