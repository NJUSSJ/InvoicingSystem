package presentation.billui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.billbl.CashBillController;
import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogic.billbl.WarningBillController;
import businesslogicservice.billblservice.CashBillBLService;
import businesslogicservice.billblservice.GiftBillBLService;
import businesslogicservice.billblservice.ImportBillBLService;
import businesslogicservice.billblservice.ImportReturnBillBLService;
import businesslogicservice.billblservice.LossBillBLService;
import businesslogicservice.billblservice.OverBillBLService;
import businesslogicservice.billblservice.PayBillBLService;
import businesslogicservice.billblservice.ReceiveBillBLService;
import businesslogicservice.billblservice.SaleBillBLService;
import businesslogicservice.billblservice.SaleReturnBillBLService;
import businesslogicservice.billblservice.WarningBillBLService;
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
	private TableColumn<BillData,String> styleColumn;
	@FXML
	private TableColumn<BillData,String> chooseColumn;
	@FXML
	private TableColumn<BillData,String> operatorColumn;
	CashBillBLService cbbs =new CashBillController();
	PayBillBLService pbbs =new PayBillController();
	ReceiveBillBLService rbbs =new ReceiveBillController();
	ImportReturnBillBLService irbbs =new ImportReturnBillController();
	ImportBillBLService ibbs =new ImportBillController();
	SaleBillBLService sbbs=new SaleBillController();
	SaleReturnBillBLService srbbs=new SaleReturnBillController();
	GiftBillBLService gbbs=new GiftBillController();
	LossBillBLService lbbs=new LossBillController();
	OverBillBLService obbs=new OverBillController();
	WarningBillBLService wbbs=new WarningBillController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		billTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		idColumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
		styleColumn.setCellValueFactory(cellData ->cellData.getValue().getstyleProperty());
		operatorColumn.setCellValueFactory(cellData ->cellData.getValue().getoperatorProperty());
		chooseColumn.setCellValueFactory(cellData ->cellData.getValue().getchooseProperty());
	}
	private void getInf(BillData newValue) {
		// TODO Auto-generated method stub
		billData.remove(newValue);
		if(newValue.getchooseProperty().get().equals("·ñ")){
			newValue.setChoose("ÊÇ");
		}else{
			newValue.setChoose("·ñ");
		}
		billData.add(newValue);
		billTable.setItems(billData);
	}
	
}
