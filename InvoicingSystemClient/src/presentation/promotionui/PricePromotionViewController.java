package presentation.promotionui;

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

public class PricePromotionViewController implements Initializable{
	@FXML
	private Label id;
	@FXML
	private Button add;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	
	private ObservableList<PricePromotionData> promotionData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<PricePromotionData> promotionTable;
	@FXML
	private TableColumn<PricePromotionData,String> pricelineCol;
	@FXML
	private TableColumn<PricePromotionData,String> discountCol;
	@FXML
	private TableColumn<PricePromotionData,String> couponCol;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO 自动生成的方法存根
		id.setText("ID:"+MainApp.getID());
		promotionTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		pricelineCol.setCellValueFactory(cellData ->cellData.getValue().getPricelineProperty());
		discountCol.setCellValueFactory(cellData ->cellData.getValue().getDiscountProperty());
		couponCol.setCellValueFactory(cellData ->cellData.getValue().getCouponProperty());
	}
	private Object getInf(PricePromotionData newValue) {
		// TODO 自动生成的方法存根
		return newValue.getVO();
	}

}
