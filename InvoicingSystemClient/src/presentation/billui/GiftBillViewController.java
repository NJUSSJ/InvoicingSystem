package presentation.billui;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.billbl.CommodityList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import vo.GiftBillVO;

public class GiftBillViewController  implements Initializable{
	@FXML
	private Label ID;
	@FXML
	private Label userid;
	@FXML
	private Label memberid;
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
	public void setVo(GiftBillVO m) {
		// TODO Auto-generated method stub
		ID.setText(""+m.getID());
		userid.setText(""+m.getUserID());
		memberid.setText(""+m.getMemberID());
		CommodityList list=m.getCommodityList();
		for(int i=0;i<list.getListSize();i++){
			CommodityItemData data=new CommodityItemData(list.get(0));
			cashData.add(data);
		}
		cashTable.setItems(cashData);
	}
	public void setVO(GiftBillVO m) {
		// TODO Auto-generated method stub
		
	}
}
