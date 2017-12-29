package presentation.billui;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.accountbl.AccountController;
import businesslogic.billbl.AccountLineItem;
import businesslogic.billbl.AccountList;
import businesslogic.billbl.ReceiveBill;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.logbl.LogController;
import businesslogic.memberbl.MemberController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.accountblservice.AccountBLService;
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
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import vo.AccountVO;
import vo.LogVO;
import vo.MemberVO;
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
	Stage stage;
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
	
	AccountList aclist=new AccountList();
	
	AccountLineItemData  alid;
	
	static int times=0;
	
	ReceiveBillVO unpassbill=null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.util.Date utiltime=new java.util.Date();
		time=new Date(utiltime.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String str=sdf.format(time);
		DecimalFormat df=new DecimalFormat("#####");
		receiveTable.setItems(receiveData);
		
		/*
		 * set times
		 */
		ArrayList<ReceiveBillVO> tmpList=new ReceiveBillController().findReceiveBillByTime(time);
		times=tmpList.size()+1;
		billid.setText("SKD-"+str+"-"+df.format(times));
		
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
		operator.setText(MainApp.getName());
		receiveTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));	
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
		amountColoumn.setCellValueFactory(cellData ->cellData.getValue().getMoney());
		noteColoumn.setCellValueFactory(cellData ->cellData.getValue().getRemark());

	reviseB.setVisible(false);
	}
	@FXML
    public void add(){
        try {
        	 long name=Long.parseLong(itemName.getText());
        	 
        	 AccountBLService accountService=new AccountController();
        	 AccountVO tmpVO= accountService.findAccountByID(name);
        	 if(tmpVO==null) {
        		 Alert warning=new Alert(AlertType.WARNING);
     			 warning.setContentText("Account Does Not Exist!");
     			 warning.showAndWait();
     			 return;
        	 }
        	 double money=Double.parseDouble(itemMoney.getText());
        	 String note=itemNote.getText();
			 ali=new AccountLineItem(name,money,note);
			 aclist.addAccount(ali);
			 alid=new AccountLineItemData(ali);
			 receiveData.add(alid);
			 totalsum.setText(Double.toString(aclist.getSum()));
			 
			 
		} catch (NumberFormatException e) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setContentText("Please Check Your Input!");
			warning.showAndWait();
		}
        	 itemMoney.setText("");
			 itemName.setText("");
			 itemNote.setText("");
    }
	@FXML
    public void update(){
		
    	try {
       	 long name=Long.parseLong(itemName.getText());
       	 
       	 AccountBLService accountService=new AccountController();
       	 AccountVO tmpVO= accountService.findAccountByID(name);
       	 if(tmpVO==null) {
       		 Alert warning=new Alert(AlertType.WARNING);
    			 warning.setContentText("Account Does Not Exist!");
    			 warning.showAndWait();
    			 return;
       	 }
       	 double money=Double.parseDouble(itemMoney.getText());
       	 	 String note=itemNote.getText();
       	 	 aclist.removeAccount(ali);
       	 	 receiveData.remove(alid);
			 ali=new AccountLineItem(name,money,note);
			 aclist.addAccount(ali);
			 alid=new AccountLineItemData(ali);
			 receiveData.add(alid);
			 totalsum.setText(Double.toString(aclist.getSum()));
			 
			 itemMoney.setText("");
			 itemName.setText("");
			 itemNote.setText("");
		} catch (NumberFormatException e) {
			Alert warning=new Alert(AlertType.WARNING);
			warning.setContentText("Please Check Your Input!");
			warning.showAndWait();
		}
    }
	@FXML
    public void delete(){
    	int selectedIndex = receiveTable.getSelectionModel().getSelectedIndex();
   	 if (selectedIndex >= 0) {
   		    receiveTable.getItems().remove(selectedIndex);
            aclist.removeAccount(ali);
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
	@FXML
    public void showFianceMainUI(){
    	MainApp.showFianceMainUI();
    }
	@FXML
    public void logout(){
		MainApp.cancelUser();
    	MainApp.showLoginUI();
    }
	private void getInf(AccountLineItemData newValue) {
		if(newValue!=null) {
			ali=newValue.getVO();
			alid=newValue;
			 itemMoney.setText(alid.getMoney().get());
			 itemName.setText(alid.getName().get());
			 itemNote.setText(alid.getRemark().get());
		}
		
	}
	@FXML
	public void revise(){
		 MemberVO tmpMember=new MemberController().findMemberByName(account.getText());
		 if(tmpMember==null) {
			 Alert warning=new Alert(AlertType.WARNING);
				warning.setContentText("Member Does Not Exist!");
				warning.showAndWait();
				return ;
		 }
		 
		 ReceiveBillBLService pbs=new ReceiveBillController();
		 pbs.deleteReceiveBill(unpassbill);
		 ReceiveBillVO receivebill=new ReceiveBillVO(billid.getText() ,MainApp.getID(),tmpMember.getID(),aclist,aclist.getSum(),time,0);
		 String isSubmit="fail Submit";
		 if(pbs.submitReceiveBill(receivebill)){
			 isSubmit="Succeed Submit";
			//记录日志
				LogController logController=new LogController();
				long logID=logController.findLargestID()+1;
 	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"submitReceiveBill:"+receivebill.getID(),MainApp.getID());
 	        logController.addLog(logVO);
		 }
  		Alert alert = new Alert(AlertType.INFORMATION);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Information");
	        alert.setHeaderText("Submit");
	        alert.setContentText(isSubmit);
	        alert.showAndWait();
	}
	@FXML
 public void rightSet(){
		/*
		 * judge member
		 */
	 MemberVO tmpMember=new MemberController().findMemberByName(account.getText());
	 if(tmpMember==null) {
		 Alert warning=new Alert(AlertType.WARNING);
			warning.setContentText("Member Does Not Exist!");
			warning.showAndWait();
			return ;
	 }
	 
	 ReceiveBillBLService pbs=new ReceiveBillController();
	 ReceiveBillVO receivebill=new ReceiveBillVO(billid.getText() ,MainApp.getID(),tmpMember.getID(),aclist,aclist.getSum(),time,0);
	 String isSubmit="fail Submit";
	 if(pbs.submitReceiveBill(receivebill)){
		//记录日志
			LogController logController=new LogController();
			long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"submitReceiveBill:"+receivebill.getID(),MainApp.getID());
	        logController.addLog(logVO);
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		 String str=sdf.format(time);
		 DecimalFormat df=new DecimalFormat("#####");
		 ArrayList<ReceiveBillVO> tmpList=new ReceiveBillController().findReceiveBillByTime(time);
		 times=tmpList.size()+1;
		 billid.setText("SKD-"+str+"-"+df.format(times));
		 
		 isSubmit="Succeed Submit";
		 
		 receiveData.clear();
		 aclist=new AccountList();
		 account.setText("");
		 totalsum.setText(Double.toString(aclist.getSum()));
	 }
     		Alert alert = new Alert(AlertType.INFORMATION);
	        alert.initOwner(MainApp.getPrimaryStage());
	        alert.setTitle("Information");
	        alert.setHeaderText("Submit");
	        alert.setContentText(isSubmit);
	        alert.showAndWait();
 }
	public void setStage(Stage stage) {
		this.stage=stage;
	}
	public void setVo(ReceiveBillVO m) {
		billid.setText(m.getID());
		account.setText(""+m.getMemberID());
		operator.setText(""+m.getUserID());
		totalsum.setText(""+m.getSum());
	    AccountList items=m.getAccountList();
	    for(int i=0;i<items.getListLength();i++){
		   AccountLineItemData a=new AccountLineItemData(items.getItem(i));
		   receiveData.add(a);
	   }
	   receiveTable.setItems(receiveData);
	   rightB.setVisible(false);
	   returnB.setVisible(false);
	   addB.setVisible(false);
	   updateB.setVisible(false);
	   deleteB.setVisible(false);
	   itemName.setEditable(false);
	   itemMoney.setEditable(false);
	   itemNote.setEditable(false);
	   account.setEditable(false);
	   logout.setVisible(false);
	   id.setVisible(false);
	}
	public void setVO(ReceiveBillVO m) {
		unpassbill=m;
		billid.setText(m.getID());
		account.setText(""+m.getMemberID());
		operator.setText(""+m.getUserID());
		totalsum.setText(""+m.getSum());
	    AccountList items=m.getAccountList();
	    for(int i=0;i<items.getListLength();i++){
		   AccountLineItemData a=new AccountLineItemData(items.getItem(i));
		   receiveData.add(a);
	   }
	   receiveTable.setItems(receiveData);
	  reviseB.setVisible(true);
	   rightB.setVisible(false);
	   returnB.setVisible(false);
	   logout.setVisible(false);
	   id.setVisible(false);
	}
	public void red(ReceiveBillVO m) {
		id.setText(""+MainApp.getID());
		account.setText(""+m.getMemberID());
		operator.setText(""+m.getUserID());
		totalsum.setText(""+m.getSum());
	    AccountList items=m.getAccountList();
	    for(int i=0;i<items.getListLength();i++){
		   AccountLineItemData a=new AccountLineItemData(items.getItem(i));
		   receiveData.add(a);
	   }
	   receiveTable.setItems(receiveData);
	   addB.setVisible(false);
	   returnB.setVisible(false);
	   deleteB.setVisible(false);
	   logout.setVisible(false);
	   id.setVisible(false);
	}
}
