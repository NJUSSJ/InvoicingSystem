package presentation.billui;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.billbl.AccountLineItem;
import businesslogic.billbl.AccountList;
import businesslogic.billbl.ReceiveBillController;
import businesslogicservice.billblservice.ReceiveBillBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import vo.ReceiveBillVO;

public class ReceiveBillViewController  implements Initializable{
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private Label operator;
	@FXML
	private Label totalsum;
	@FXML
	private Label billid;
	@FXML
	private TextField account;
	
	Date time;
	
    private ObservableList<AccountLineItemData> receiveData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<AccountLineItemData> receiveTable;
	
	@FXML
	private TableColumn<AccountLineItemData,String> nameColoumn;
	
	@FXML
	private TableColumn<AccountLineItemData,String> amountColoumn;
	
	@FXML
	private TableColumn<AccountLineItemData,String> noteColoumn;
	
	@FXML
	private Button rightB;
	
	@FXML
	private Button returnB;
	
	@FXML
	private Button addB;
	
	@FXML
	private Button reviseB;
	
	@FXML
	private Button updateB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private TextField itemName;
	
	@FXML
	private TextField itemMoney;
	
	@FXML
	private TextField itemNote;
	
	AccountLineItem ali;
	
	AccountList aclist;
	
	AccountLineItemData  alid;
	
	static int times=0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		java.util.Date utiltime=new java.util.Date();
		time=new Date(utiltime.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String str=sdf.format(time);
		DecimalFormat df=new DecimalFormat("#####");
		billid.setText("SKD-"+str+"-"+df.format(times));
		id.setText("ID:"+MainApp.getID());
		operator.setText(Long.toString(MainApp.getID()));
		receiveTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));	
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
		amountColoumn.setCellValueFactory(cellData ->cellData.getValue().getMoney());
		noteColoumn.setCellValueFactory(cellData ->cellData.getValue().getRemark());
         times++;
	}

    public void add(){
        long name=Long.parseLong(itemName.getText());
        double money=Double.parseDouble(itemMoney.getText());
        String note=itemNote.getText();
        ali=new AccountLineItem(name,money,note);
        aclist.addAccount(ali);
        alid=new AccountLineItemData(ali);
        receiveData.add(alid);
        receiveTable.setItems(receiveData);
        totalsum.setText(Double.toString(aclist.getSum()));
    }
    public void update(){
    	aclist.removeAccount(ali);
    	receiveData.remove(alid);
    	long name=Long.parseLong(itemName.getText());
        double money=Double.parseDouble(itemMoney.getText());
        String note=itemNote.getText();
        ali.setAccountID(name);
        ali.setMoney(money);
        ali.setRemark(note);
        aclist.addAccount(ali);
        alid=new AccountLineItemData(ali);
        receiveData.add(alid);
        receiveTable.setItems(receiveData);
        totalsum.setText(Double.toString(aclist.getSum()));
    }
    public void delete(){
    	int selectedIndex = receiveTable.getSelectionModel().getSelectedIndex();
   	 if (selectedIndex >= 0) {
   		    receiveTable.getItems().remove(selectedIndex);
            aclist.removeAccount(ali);
            receiveData.remove(selectedIndex);
            totalsum.setText(Double.toString(aclist.getSum()));
   	    } else {
   	        // Nothing selected.
   	        Alert alert = new Alert(AlertType.WARNING);
   	        alert.initOwner(MainApp.getPrimaryStage());
   	        alert.setTitle("No Selection");
   	        alert.setHeaderText("No Item Selected");
   	        alert.setContentText("Please select an item in the table.");

   	        alert.showAndWait();
   	    }
    }
    public void showFianceMainUI(){
    	MainApp.showFianceMainUI();
    }
    public void logout(){
    	MainApp.showLoginUI();
    }
	private void getInf(AccountLineItemData newValue) {
		// TODO Auto-generated method stub
		ali=newValue.getVO();
		alid=newValue;
	}
 public void rightSet(){
	 ReceiveBillBLService pbs=new ReceiveBillController();
	 ReceiveBillVO receivebill=new ReceiveBillVO(billid.getText() ,Long.parseLong(operator.getText()),Long.parseLong(account.getText()),aclist,aclist.getSum(),time,0);
	 String isSubmit="fail Submit";
	 if(pbs.submitReceiveBill(receivebill)){
		 isSubmit="Succeed Submit";
	 }
     Alert alert = new Alert(AlertType.INFORMATION);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Information");
	        alert.setHeaderText("Submit");
	        alert.setContentText(isSubmit);
	        alert.showAndWait();
 }
	


	
}
