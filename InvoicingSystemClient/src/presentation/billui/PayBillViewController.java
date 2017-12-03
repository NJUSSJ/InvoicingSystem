package presentation.billui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.accountbl.AccountController;
import businesslogic.billbl.AccountLineItem;
import businesslogic.billbl.AccountList;
import businesslogicservice.accountblservice.AccountBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PayBillViewController  implements Initializable{
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private Label operator;
	@FXML
	private Label billid;
	@FXML
	private TextField account;
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
	private Button reviseB;
	
	@FXML
	private Button updateB;
	
	@FXML
	private Button deleteB;
	
	AccountLineItem ali;
	
	AccountList aclist;
	
    AccountListController controller;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		operator.setText(Long.toString(MainApp.getID()));
		payTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));	
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getName());
		amountColoumn.setCellValueFactory(cellData ->cellData.getValue().getMoney());
		noteColoumn.setCellValueFactory(cellData ->cellData.getValue().getRemark());
	}

    public void add(){
    	try{
    	FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/presentation/billui/AccountListUI.fxml"));
		AnchorPane payBillUI=loader.load();
		Scene scene=new Scene(payBillUI);
		Stage payStage=new Stage();
		payStage.setTitle("Create/Change Item");
		payStage.initModality(Modality.WINDOW_MODAL);
		payStage.initOwner(MainApp.getPrimaryStage());
		payStage.setScene(scene);
		controller=loader.getController();
        controller.setStage(payStage);
        payStage.showAndWait();
    	}catch (IOException e) {
    		// TODO: handle exception
    	}
    }
    public void update(){
    try{
     	FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/presentation/billui/AccountListUI.fxml"));
		AnchorPane payBillUI=loader.load();
		Scene scene=new Scene(payBillUI);
		Stage payStage=new Stage();
		payStage.setTitle("Create/Change Item");
		payStage.initModality(Modality.WINDOW_MODAL);
		payStage.initOwner(MainApp.getPrimaryStage());
		payStage.setScene(scene);
		controller=loader.getController();
        controller.setStage(payStage);
        controller.setAccountid(Double.toString(ali.getAccountID()));
        controller.setRemark(ali.getRemark());
        controller.setMoney(ali.getMoney());
        payStage.showAndWait();
    } catch (IOException e) {
		// TODO: handle exception
	}
    }
    public void delete(){
    	int selectedIndex = payTable.getSelectionModel().getSelectedIndex();
   	 if (selectedIndex >= 0) {
   	        payTable.getItems().remove(selectedIndex);
             aclist.
             
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
	}
 
	

	


	
}
