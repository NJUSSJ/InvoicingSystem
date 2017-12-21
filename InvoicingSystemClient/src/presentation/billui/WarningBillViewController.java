package presentation.billui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import vo.WarningBillVO;

public class WarningBillViewController implements Initializable{
	@FXML
	private Label ID;
	@FXML
	private Label userid;
	Stage stage;
 private ObservableList<CommodityItemData> cashData =FXCollections.observableArrayList();
		
		@FXML
		private TableView<CommodityItemData> cashTable;
		
		@FXML
		private TableColumn<CommodityItemData,String> nameColoumn;
		
		@FXML
		private TableColumn<CommodityItemData,String> idColoumn;
		
		@FXML
		private TableColumn<CommodityItemData,String> numColoumn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		numColoumn.setCellValueFactory(cellData ->cellData.getValue().getNumProperty());
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
	   
	}
	public void setStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage=stage;
	}
	public void setVo(WarningBillVO m) {
		// TODO Auto-generated method stub
		
	}
	
}
