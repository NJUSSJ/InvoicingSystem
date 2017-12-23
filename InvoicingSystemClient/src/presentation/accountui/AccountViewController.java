package presentation.accountui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vo.AccountVO;

public class AccountViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Label logout;
	
	@FXML
	private TextField search;
	
	@FXML
	private Button rightB;
	
	@FXML
	private Button addB;
	
	@FXML
	private Button deleteB;
	
	@FXML
	private Button updateB;
	
	@FXML
	private Button returnB;
	
	public  ObservableList<AccountData> accountData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<AccountData> accountTable;
	
	@FXML
	private TableColumn<AccountData,String> nameColoumn;
	
	@FXML
	private TableColumn<AccountData,String> amountColoumn;
	@FXML
	private TableColumn<AccountData,String> idColoumn;
	
	ArrayList<AccountVO> accountList;
	
	AccountVO acco;
	
	AccountBLService abs=new AccountController();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		amountColoumn.setCellValueFactory(cellData ->cellData.getValue().getDepositProperty());
		idColoumn.setCellValueFactory(cellData ->cellData.getValue().getidProperty());
	    accountList=abs.findAccounts();
	    for(AccountVO a:accountList){
			accountData.add(new AccountData(a));
		}
	    accountTable.setItems(accountData);
	    search.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getCode().equals(KeyCode.ENTER)) {
					searchAccount();
				}
			}
		});
	}
	
	@FXML
	public void searchAccount(){
		String findName=search.getText();
		if(findName.equals("")) {
			MainApp.showAccountUI();
			return;
		}
		accountData.clear();
		if(findName.charAt(0)>='0'&&findName.charAt(0)<='9'){
			acco=abs.findAccountByID(Long.parseLong(findName));
			accountData.add(new AccountData(acco));
			
		}else{
		accountList=abs.findAccountByField(findName);
		for(AccountVO a:accountList){
			accountData.add(new AccountData(a));
		}
		
		}
		
	}
	@FXML
    public void addAccount(){
    	try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/SimpleAccount.fxml"));
			AnchorPane accountUI=loader.load();
			Scene scene=new Scene(accountUI);
			Stage accountStage=new Stage();
			accountStage.setTitle("Create/Change Account");
			accountStage.initModality(Modality.WINDOW_MODAL);
			accountStage.initOwner(MainApp.getPrimaryStage());
			accountStage.setScene(scene);
            SimpleAccountController controller=loader.getController();
            controller.setStage(accountStage);
            controller.setStyle(0);
            controller.setList(accountData);
            accountStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    public void deleteAccount(){
    	int selectedIndex = accountTable.getSelectionModel().getSelectedIndex();
    	 if (selectedIndex >= 0) {
    		 	AccountData data=accountTable.getSelectionModel().getSelectedItem();
    	        accountTable.getItems().remove(selectedIndex);
    	        
    	        String name=data.getNameProperty().get();
    	        long id=Long.parseLong(data.getidProperty().get());
    	        double deposit=Double.parseDouble(data.getDepositProperty().get());
    	        
    	        AccountVO tmpVO=new AccountVO(id, deposit, name);
    	        abs.deleteAccount(tmpVO);
    			
    	    } else {
    	        // Nothing selected.
    	        Alert alert = new Alert(AlertType.WARNING);
    	        alert.initOwner(MainApp.getPrimaryStage());
    	        alert.setTitle("No Selection");
    	        alert.setHeaderText("No Account Selected");
    	        alert.setContentText("Please select an account in the table.");
    	        
    	        alert.showAndWait();
    	    }
   	}
    @FXML
    public void updateAccount(){
    	try {
    		AccountData data=accountTable.getSelectionModel().getSelectedItem();
    		if(data==null) {
    			// Nothing selected.
    	        Alert alert = new Alert(AlertType.WARNING);
    	        alert.initOwner(MainApp.getPrimaryStage());
    	        alert.setTitle("No Selection");
    	        alert.setHeaderText("No Account Selected");
    	        alert.setContentText("Please select an account in the table.");
    	        
    	        alert.showAndWait();
    		}
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/SimpleAccount.fxml"));
			AnchorPane accountUI=loader.load();
			Scene scene=new Scene(accountUI);
			Stage accountStage=new Stage();
			accountStage.setTitle("Create/Change Account");
			accountStage.initModality(Modality.WINDOW_MODAL);
			accountStage.initOwner(MainApp.getPrimaryStage());
			accountStage.setScene(scene);
            SimpleAccountController controller=loader.getController();
            controller.setStage(accountStage);
            controller.setSelect(data);
            controller.setStyle(1);
            accountStage.showAndWait();
            
		} catch (IOException e) {
			e.printStackTrace();
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
    
}
