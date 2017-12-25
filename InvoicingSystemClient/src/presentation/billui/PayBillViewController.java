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
import businesslogic.billbl.PayBillController;
import businesslogic.billbl.ReceiveBillController;
import businesslogic.logbl.LogController;
import businesslogic.memberbl.MemberController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.accountblservice.AccountBLService;
import businesslogicservice.billblservice.PayBillBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.AccountVO;
import vo.LogVO;
import vo.MemberVO;
import vo.PayBillVO;
import vo.ReceiveBillVO;


public class PayBillViewController  implements Initializable{
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
    private ObservableList<AccountLineItemData> payData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<AccountLineItemData> payTable;
	
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
	private Button updateB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private Button reviseB;
	
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
	
	PayBillVO unpassbill=null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		java.util.Date utiltime=new java.util.Date();
		time=new Date(utiltime.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String str=sdf.format(time);
		DecimalFormat df=new DecimalFormat("#####");
		payTable.setItems(payData);
		/*
		 * set times
		 */
		ArrayList<PayBillVO> tmpList=new PayBillController().findPayBillByTime(time);
		times=tmpList.size()+1;
		billid.setText("FKD-"+str+"-"+df.format(times));
		
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
		operator.setText(MainApp.getName());
		payTable.getSelectionModel().selectedItemProperty().addListener(
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
       	 }
       	 double money=Double.parseDouble(itemMoney.getText());
       	 String note=itemNote.getText();
			 ali=new AccountLineItem(name,money,note);
			 aclist.addAccount(ali);
			 alid=new AccountLineItemData(ali);
			 payData.add(alid);
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
	       	 }
	       	 double money=Double.parseDouble(itemMoney.getText());
	       	 	 String note=itemNote.getText();
	       	 	 aclist.removeAccount(ali);
	       	 	 payData.remove(alid);
				 ali=new AccountLineItem(name,money,note);
				 aclist.addAccount(ali);
				 alid=new AccountLineItemData(ali);
				 payData.add(alid);
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
		int selectedIndex = payTable.getSelectionModel().getSelectedIndex();
	   	 if (selectedIndex >= 0) {
	   		    payTable.getItems().remove(selectedIndex);
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
		 
		 PayBillBLService pbs=new PayBillController();
		 pbs.deletePayBill(unpassbill);
		 PayBillVO paybill=new PayBillVO(billid.getText() ,MainApp.getID(),tmpMember.getID(),aclist,aclist.getSum(),time,0);
		 String isSubmit="fail Submit";
		 if(pbs.submitPayBill(paybill)){
			 isSubmit="Succeed Sumbit";
			//记录日志
				LogController logController=new LogController();
				long logID=logController.findLargestID()+1;
 	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"submitPayBill:"+paybill.getID(),MainApp.getID());
 	        logController.addLog(logVO);
 	        //
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
	 
	 PayBillBLService pbs=new PayBillController();
	 PayBillVO paybill=new PayBillVO(billid.getText() ,MainApp.getID(),tmpMember.getID(),aclist,aclist.getSum(),time,0);
	 String isSubmit="fail Submit";
	 if(pbs.submitPayBill(paybill)){
		 //记录日志
		 LogController logController=new LogController();
		 long logID=logController.findLargestID()+1;
		 LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"submitPayBill:"+paybill.getID(),MainApp.getID());
		 logController.addLog(logVO);
		 //
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		 String str=sdf.format(time);
		 DecimalFormat df=new DecimalFormat("#####");
		 ArrayList<ReceiveBillVO> tmpList=new ReceiveBillController().findReceiveBillByTime(time);
		 times=tmpList.size()+1;
		 billid.setText("SKD-"+str+"-"+df.format(times));
		 
		 isSubmit="Succeed Submit";
		 
		 payData.clear();
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
		// TODO Auto-generated method stub
		this.stage=stage;
	}
	public void setVo(PayBillVO m) {
		// TODO Auto-generated method stub
		id.setText(""+MainApp.getID());
		billid.setText(m.getID());
		account.setText(""+m.getMemberID());
		operator.setText(""+m.getUserID());
		totalsum.setText(""+m.getSum());
	    AccountList items=m.getAccountList();
	    for(int i=0;i<items.getListLength();i++){
		   AccountLineItemData a=new AccountLineItemData(items.getItem(i));
		   payData.add(a);
	   }
	   payTable.setItems(payData);
	   rightB.setVisible(false);
	   returnB.setVisible(false);
	   addB.setVisible(false);
	   updateB.setVisible(false);
	   deleteB.setVisible(false);
	}
	public void setVO(PayBillVO m) {
		unpassbill=m;
		// TODO Auto-generated method stub
		id.setText(""+MainApp.getID());
		billid.setText(m.getID());
		account.setText(""+m.getMemberID());
		operator.setText(""+m.getUserID());
		totalsum.setText(""+m.getSum());
	    AccountList items=m.getAccountList();
	    for(int i=0;i<items.getListLength();i++){
		   AccountLineItemData a=new AccountLineItemData(items.getItem(i));
		   payData.add(a);
	   }
	   payTable.setItems(payData);
	   rightB.setVisible(false);
	   returnB.setVisible(false);
	   reviseB.setVisible(true);
	}
	public void red(PayBillVO m) {
		// TODO Auto-generated method stub
		id.setText(""+MainApp.getID());
		account.setText(""+m.getMemberID());
		operator.setText(""+m.getUserID());
		totalsum.setText(""+m.getSum());
	    AccountList items=m.getAccountList();
	    for(int i=0;i<items.getListLength();i++){
		   AccountLineItemData a=new AccountLineItemData(items.getItem(i));
		   payData.add(a);
	   }
	   payTable.setItems(payData);
	   deleteB.setVisible(false);
	   returnB.setVisible(false);
	   addB.setVisible(false);
	}

	

}
