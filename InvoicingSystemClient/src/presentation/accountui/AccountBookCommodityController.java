package presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AccountBookCommodityController implements Initializable {

	@FXML
	private TableView<AccoutBookCommodityData> commodityTable;
	
	@FXML
	private TableColumn<AccoutBookCommodityData, String> id;
	
	@FXML
	private TableColumn<AccoutBookCommodityData, String> name;
	
	@FXML
	private TableColumn<AccoutBookCommodityData, String> model;
	
	@FXML
	private TableColumn<AccoutBookCommodityData, String> importprice;
	
	@FXML
	private TableColumn<AccoutBookCommodityData, String> saleprice;
	
	@FXML
	private TableColumn<AccoutBookCommodityData, String> parent;
	
	private ObservableList<AccoutBookCommodityData> commodityData;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		commodityTable.setItems(commodityData);
		id.setCellValueFactory(cellData->cellData.getValue().getID());
		name.setCellValueFactory(cellData->cellData.getValue().getName());
		model.setCellValueFactory(cellData->cellData.getValue().getModel());
		importprice.setCellValueFactory(cellData->cellData.getValue().getImportPrice());
		saleprice.setCellValueFactory(cellData->cellData.getValue().getSalePrice());
		parent.setCellValueFactory(cellData->cellData.getValue().getParent());
		
		
	}
	
	public void setList(ObservableList<AccoutBookCommodityData> list) {
		this.commodityData=list;
		commodityTable.setItems(commodityData);
	}

}
