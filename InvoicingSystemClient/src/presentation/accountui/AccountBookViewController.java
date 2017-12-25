package presentation.accountui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.accountbl.AccountController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AccountBookViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Button logout;

	@FXML
	private Button returnB;
	@FXML
	private Button set;
	@FXML
	private Button showCommodity;
	@FXML
	private Button showAccount;
	@FXML
	private Button showMember;
	
	public  ObservableList<AccountBookData> bookData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<AccountBookData> bookTable;
	
	@FXML
	private TableColumn<AccountBookData,String> nameColoumn;
	
	@FXML
	private TableColumn<AccountBookData,String> dateColoumn;
	
	public AccountBookData bookdata;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
		ArrayList<AccountBookData> data=new AccountController().retore();
		for(int i=0;i<data.size();i++) {
			bookData.add(data.get(i));
		}
		bookTable.setItems(bookData);
		bookTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
    	dateColoumn.setCellValueFactory(cellData ->cellData.getValue().getTimeProperty());
	   
    	
    	
}
	private void getInf(AccountBookData newValue) {
		if(newValue!=null) {
			bookdata=newValue;
		}
	}
	@FXML
	public void logout(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	
	@FXML
	public void showFianceMain(){
		MainApp.showFianceMainUI();
	}
	
	@FXML
	public void SetNewBook(){
		boolean ifSuccess=new AccountController().backUpDataBase(DateUtil.toSQL(new java.util.Date() ));
		if(ifSuccess) {
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setContentText("账本建立成功！");
			alert.showAndWait();
		}else {
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setContentText("账本建立失败！");
			alert.showAndWait();
		}
		
		bookData.clear();
		ArrayList<AccountBookData> data=new AccountController().retore();
		for(int i=0;i<data.size();i++) {
			bookData.add(data.get(i));
		}
		
	}
	@FXML
	public void showCommodity(){
		if(bookdata==null) {
			Alert alert=new Alert(AlertType.WARNING);
			alert.setContentText("请选择一套账本！");
			alert.showAndWait();
			return ;
		}
		ObservableList<AccoutBookCommodityData> list=FXCollections.observableArrayList();
		String commodityList=bookdata.getCommodityProperty().get();
		String commoditys[]=commodityList.split(" ");
		for(int i=0;i<commoditys.length;i++) {
			String item[]=commoditys[i].split(",");
			AccoutBookCommodityData tmpdata=new AccoutBookCommodityData(item[0], item[1], item[4], item[2], item[3], item[5]);
			list.add(tmpdata);
		}
		
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/AccountBookCommodityUI.fxml"));
			AnchorPane accountUI=loader.load();
			Scene scene=new Scene(accountUI);
			Stage accountStage=new Stage();
			accountStage.setTitle("期初商品信息查看");
			accountStage.initModality(Modality.WINDOW_MODAL);
			accountStage.initOwner(MainApp.getPrimaryStage());
			accountStage.setScene(scene);
			AccountBookCommodityController controller=loader.getController();
			controller.setList(list);
            accountStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void showAccount(){
		if(bookdata==null) {
			Alert alert=new Alert(AlertType.WARNING);
			alert.setContentText("请选择一套账本！");
			alert.showAndWait();
			return ;
		}
		
		ObservableList<AccountBookAccountData> list=FXCollections.observableArrayList();
		String accountList=bookdata.getAccountProperty().get();
		String accounts[]=accountList.split(" ");
		for(int i=0;i<accounts.length;i++) {
			String item[]=accounts[i].split(",");
			AccountBookAccountData tmpData=new AccountBookAccountData(item[0], item[1]);
			list.add(tmpData);
		}
		
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/AccountBookAccountUI.fxml"));
			AnchorPane accountUI=loader.load();
			Scene scene=new Scene(accountUI);
			Stage accountStage=new Stage();
			accountStage.setTitle("期初客户信息查看");
			accountStage.initModality(Modality.WINDOW_MODAL);
			accountStage.initOwner(MainApp.getPrimaryStage());
			accountStage.setScene(scene);
			AccountBookAccountController controller=loader.getController();
			controller.setList(list);
            accountStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void showMember(){
		if(bookdata==null) {
			Alert alert=new Alert(AlertType.WARNING);
			alert.setContentText("请选择一套账本！");
			alert.showAndWait();
			return ;
		}
		ObservableList<AccountBookMemberData> list=FXCollections.observableArrayList();
		String memberList=bookdata.getMemberProperty().get();
		String members[]=memberList.split(" ");
		for(int i=0;i<members.length;i++) {
			String item[]=members[i].split(",");
			AccountBookMemberData tmpData=new AccountBookMemberData(item[0], item[1], item[2], item[3], item[4]);
			list.add(tmpData);
			
			try {
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/presentation/accountui/AccountBookMemberUI.fxml"));
				AnchorPane accountUI=loader.load();
				Scene scene=new Scene(accountUI);
				Stage accountStage=new Stage();
				accountStage.setTitle("期初客户信息查看");
				accountStage.initModality(Modality.WINDOW_MODAL);
				accountStage.initOwner(MainApp.getPrimaryStage());
				accountStage.setScene(scene);
				AccountBookMemberController controller=loader.getController();
				controller.setList(list);
	            accountStage.showAndWait();
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}