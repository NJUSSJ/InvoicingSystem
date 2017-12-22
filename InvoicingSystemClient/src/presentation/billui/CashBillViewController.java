package presentation.billui;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.accountbl.AccountController;
import businesslogic.billbl.CashBillController;
import businesslogicservice.accountblservice.AccountBLService;
import businesslogicservice.billblservice.CashBillBLService;
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
import vo.AccountVO;
import vo.CashBillVO;
import javafx.scene.control.Alert.AlertType;

public class CashBillViewController  implements Initializable {
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
	
	ArrayList<String> items=new ArrayList<>();
	
	ItemData a;;
	
	String item;
	
    private ObservableList<ItemData> cashData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<ItemData> cashTable;
	
	@FXML
	private TableColumn<ItemData,String> nameColoumn;
	
	@FXML
	private TableColumn<ItemData,String> amountColoumn;
	
	@FXML
	private TableColumn<ItemData,String> noteColoumn;
	
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
	
	private double totalSum=0;
	
	static int times=0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		java.util.Date utiltime=new java.util.Date();
		time=new Date(utiltime.getTime());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String str=sdf.format(time);
		DecimalFormat df=new DecimalFormat("#####");
		
		/*
		 * get times
		 */
		
		ArrayList<CashBillVO> tmpList=new CashBillController().findCashBillByTime(time);
		times=tmpList.size()+1;
		
		
		billid.setText("FKD-"+str+"-"+df.format(times));
		
		
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		operator.setText(MainApp.getName());
		cashTable.setItems(cashData);
		cashTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));	
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
		amountColoumn.setCellValueFactory(cellData ->cellData.getValue().getMoney());
		noteColoumn.setCellValueFactory(cellData ->cellData.getValue().getNote());
	}
	@FXML
    public void add(){
		try {
			 String name=itemName.getText();
			 String money=itemMoney.getText();
			 String note=itemNote.getText();
			 
			 if(name.equals("")||money.equals("")||note.equals("")) {
				 	Alert warning =new Alert(AlertType.WARNING);
					warning.setContentText("Please check your input!");
					warning.showAndWait();
					return ;
			 }
			 totalSum=totalSum+Double.parseDouble(money);
			 item=name+","+money+","+note;
			 a=new ItemData(name,money,note);
			 items.add(item);
			 cashData.add(a);
			 totalsum.setText(Double.toString(totalSum));
			 itemMoney.setText("");
			 itemName.setText("");
			 itemNote.setText("");
		} catch (NumberFormatException e) {
			Alert warning =new Alert(AlertType.WARNING);
			warning.setContentText("Please check your input!");
			warning.showAndWait();
		}
       
    }
	@FXML
    public void update(){
		try {
			items.remove(item);
			String name=itemName.getText();
			String money=itemMoney.getText();
			String note=itemNote.getText();
			
			 if(name.equals("")||money.equals("")||note.equals("")) {
				 	Alert warning =new Alert(AlertType.WARNING);
					warning.setContentText("Please check your input!");
					warning.showAndWait();
					return ;
			 }
			totalSum=totalSum-Double.parseDouble(a.getmoney());
			item=name+","+money+","+note;
			items.add(item);
			a.setMoney(money);
			a.setName(name);
			a.setNote(note);
			totalSum=totalSum+Double.parseDouble(money);
			totalsum.setText(Double.toString(totalSum));
			itemMoney.setText("");
			itemName.setText("");
			itemNote.setText("");
		} catch (NumberFormatException e) {
			Alert warning =new Alert(AlertType.WARNING);
			warning.setContentText("Please check your input!");
			warning.showAndWait();
		}
    	
    }
	@FXML
    public void delete(){
    	int selectedIndex = cashTable.getSelectionModel().getSelectedIndex();
   	 if (selectedIndex >= 0) {
   	        cashTable.getItems().remove(selectedIndex);
            items.remove(item);
            totalSum=totalSum-Double.parseDouble(a.getmoney());
            totalsum.setText(Double.toString(totalSum));
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
	@FXML
    public void showFianceMainUI(){
    	MainApp.showFianceMainUI();
    }
	@FXML
    public void logout(){
		MainApp.cancelUser();
    	MainApp.showLoginUI();
    }
	private void getInf(ItemData newValue) {
		// TODO Auto-generated method stub
		if(newValue!=null) {
		item=newValue.getname()+","+newValue.getmoney()+","+newValue.getnote();
		a=newValue;
		}
	}
	@FXML
 public void rightSet(){
	 CashBillBLService pbs=new CashBillController();
	 
	 AccountBLService accountService=new AccountController();
	 boolean ifAccountExisted=false;
	 try {
		long accountID=Long.parseLong(account.getText());
		AccountVO tmpVO=accountService.findAccountByID(accountID);
		if(tmpVO!=null) {
			ifAccountExisted=true;
		}
	} catch (NumberFormatException e) {
		Alert warning=new Alert(AlertType.WARNING);
		warning.setContentText("Please check your account id input!");
		warning.showAndWait();
	}
	 if(ifAccountExisted) {
		 	CashBillVO cashbill=new CashBillVO(billid.getText(), MainApp.getID(),Long.parseLong(account.getText()) , items, time, 0);
		 	String isSubmit="fail Submit";
		 	if(pbs.submitCashBill(cashbill)){
		 		
		 		isSubmit="Succeed Submit";
		 		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		 		String str=sdf.format(time);
		 		DecimalFormat df=new DecimalFormat("#####");
		 		
		 		ArrayList<CashBillVO> tmpList=new CashBillController().findCashBillByTime(time);
				times=tmpList.size()+1;
				if(times>99999) {
					Alert warning=new Alert(AlertType.WARNING);
					warning.setContentText("No more than 99999 cashbills a day!");
					warning.showAndWait();
				}
		 		billid.setText("FKD-"+str+"-"+df.format(times));
		 		cashData.clear();
		 		account.setText("");
		 		}
	 		Alert alert = new Alert(AlertType.INFORMATION);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Information");
	        alert.setHeaderText("Submit");
	        alert.setContentText(isSubmit);
	        alert.showAndWait();
	        }
	 else {
		 	Alert warning=new Alert(AlertType.WARNING);
			warning.setContentText("Please check your account id input!");
			warning.showAndWait();
	 }
	
	        
 }
	

}

