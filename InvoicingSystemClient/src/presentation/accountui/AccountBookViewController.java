package presentation.accountui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import Utility.DateUtil;
import businesslogic.accountbl.AccountController;
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
		// TODO Auto-generated method stub
	
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
		
	}
	@FXML
	public void showAccount(){
		
	}
	@FXML
	public void showMember(){
		
	}
}