package presentation.promotionui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.promotionbl.PromotionController;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vo.PackagePromotionVO;

public class PackagePromotionViewController implements Initializable{
	@FXML
	private Label id;
	@FXML
	private Button add;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	
	private ObservableList<PackagePromotionData> promotionData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<PackagePromotionData> promotionTable;
	@FXML
	private TableColumn<PackagePromotionData,String> discountCol;
	@FXML
	private TableColumn<PackagePromotionData,String> commodityCol;
	
	private PackagePromotionVO packagePromotionVO;
	
	private PromotionController pcon=new PromotionController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		ArrayList<PackagePromotionVO> list=pcon.findPackagePromotions();
		for(PackagePromotionVO p:list){
			promotionData.add(new PackagePromotionData(p));
		}
		promotionTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		discountCol.setCellValueFactory(cellData ->cellData.getValue().getDiscountProperty());
		commodityCol.setCellValueFactory(cellData ->cellData.getValue().getCommodityProperty());
		promotionTable.setItems(promotionData);
	}
	@FXML 
	public void back(){
		MainApp.showManagerMainUI();
	}
	@FXML
	public void add(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/promotionui/SimplePackagePromotion.fxml"));
			AnchorPane promotionUI=loader.load();
			Scene scene=new Scene(promotionUI);
			Stage promotionStage=new Stage();
			promotionStage.setTitle("Create PackagePromotion");
			promotionStage.initModality(Modality.WINDOW_MODAL);
			promotionStage.initOwner(MainApp.getPrimaryStage());
			promotionStage.setScene(scene);
            SimplePackagePromotionController controller=loader.getController();
            controller.setStage(promotionStage);
            promotionStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void getInf(PackagePromotionData newValue) {
		packagePromotionVO=newValue.getVO();
	}
	@FXML
	public void delete(){
		int index=promotionTable.getSelectionModel().getSelectedIndex();
		if(index>=0){
			pcon.deletePackagePromotion(packagePromotionVO);
			promotionTable.getItems().remove(index);
		}else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No PackagePromotion Selected");
	        alert.setContentText("Please select a promotion in the table.");
	        alert.showAndWait();
	    }
	}
}
