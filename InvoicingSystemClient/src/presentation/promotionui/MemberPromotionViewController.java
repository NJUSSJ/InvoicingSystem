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
import vo.MemberPromotionVO;
import vo.PricePromotionVO;

public class MemberPromotionViewController implements Initializable{
	@FXML
	private TableView<MemberPromotionData> promotionTable;
	@FXML
	private TableColumn<MemberPromotionData,Number> rankCol;
	@FXML
	private TableColumn<MemberPromotionData,Number> couponCol;
	@FXML
	private TableColumn<MemberPromotionData,Number> discountCol;
	@FXML
	private TableColumn<MemberPromotionData,String> giftCol;
	@FXML
	private Button add;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
	private Label id;
	private ObservableList<MemberPromotionData> promotionData=FXCollections.observableArrayList();
	
	private MemberPromotionVO promotionVO;
	
	private PromotionController pcon=new PromotionController();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO 自动生成的方法存根
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		ArrayList<MemberPromotionVO> list=pcon.findMemberPromotions();
		for(MemberPromotionVO m:list){
			promotionData.add(new MemberPromotionData(m));
		}
		promotionTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		rankCol.setCellValueFactory(cellData ->cellData.getValue().getRankProperty());
		couponCol.setCellValueFactory(cellData ->cellData.getValue().getCouponProperty());
		discountCol.setCellValueFactory(cellData ->cellData.getValue().getDiscountProperty());
		giftCol.setCellValueFactory(cellData ->cellData.getValue().getGiftProperty());
		promotionTable.setItems(promotionData);
	}
	@FXML
	public void delete(){
		int index=promotionTable.getSelectionModel().getSelectedIndex();
		if(index>=0){
			pcon.deleteMemberPromotion(promotionVO);
			promotionTable.getItems().remove(index);
		}else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No MemberPromotion Selected");
	        alert.setContentText("Please select a promotion in the table.");
	        alert.showAndWait();
	    }
	}
	@FXML 
	public void back(){
		MainApp.showManagerMainUI();
	}
	@FXML
	public void add(){
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/promotionui/SimpleMemberPromotion.fxml"));
			AnchorPane promotionUI=loader.load();
			Scene scene=new Scene(promotionUI);
			Stage promotionStage=new Stage();
			promotionStage.setTitle("Create MemberPromotion");
			promotionStage.initModality(Modality.WINDOW_MODAL);
			promotionStage.initOwner(MainApp.getPrimaryStage());
			promotionStage.setScene(scene);
            SimpleMemberPromotionController controller=loader.getController();
            controller.setStage(promotionStage);
            promotionStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getInf(MemberPromotionData newValue) {
		promotionVO=newValue.getVO();
	}
}
