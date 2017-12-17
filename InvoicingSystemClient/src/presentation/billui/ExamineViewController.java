package presentation.billui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.billbl.CashBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogicservice.billblservice.CashBillBLService;
import businesslogicservice.billblservice.ImportBillBLService;
import businesslogicservice.billblservice.ImportReturnBillBLService;
import businesslogicservice.billblservice.PayBillBLService;
import businesslogicservice.billblservice.ReceiveBillBLService;
import businesslogicservice.billblservice.SaleBillBLService;
import businesslogicservice.billblservice.SaleReturnBillBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.accountui.AccountData;

public class ExamineViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private Label detail;
	@FXML
	private Button passB;
	
	@FXML
	private Button returnB;
	
	@FXML
	private Button notpassB;
	
	@FXML
	private Button detailB;
	
    private ObservableList<BillData> billData =FXCollections.observableArrayList();
	@FXML
	private TableView<BillData> billTable;
	@FXML
	private TableColumn<BillData,String> idColumn;
	@FXML
	private TableColumn<BillData,Number> stateColumn;
	CashBillBLService cbbs =new CashBillController();
	PayBillBLService pbbs =new PayBillController();
	ReceiveBillBLService rbbs =new ReceiveBillController();
	ImportReturnBillBLService irbbs =new ImportReturnBillController();
	ImportBillBLService ibbs =new ImportBillController();
	SaleBillBLService sbbs=new SaleBillController();
	SaleReturnBillBLService srbbs=new SaleReturnBillController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		billTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
		stateColumn.setCellValueFactory(cellData ->cellData.getValue().getststeProperty());
	}
	private void getInf(BillData newValue) {
		// TODO Auto-generated method stub
		
	}
	
}
