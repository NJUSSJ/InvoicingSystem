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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
	private Label name;
	
	@FXML
	private Label amount;
	
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
	
	private ObservableList<AccountVO> accountData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<AccountVO> accountTable;
	
	@FXML
	private TableColumn<AccountVO,String> nameColoumn;
	
	@FXML
	private TableColumn<AccountVO,String> amountColoumn;
	
	ArrayList<AccountVO> accountList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
		nameColoumn.setEditable(false);
		amountColoumn.setEditable(false);
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
		amountColoumn.setCellValueFactory(cellData ->cellData.getValue().getDepositProperty());
	}
	
	
	public void searchAccount(){
		String findName=search.getText();
		AccountBLService abs=new AccountController();
		accountList=abs.findAccountByField(findName);
		for(AccountVO a:accountList){
			accountData.add(a);
		}
		accountTable.setItems(accountData);
		
	}
	
    public void addAccount(){
    	try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/presentation/accountui/SimpleAccountUI.fxml"));
			AnchorPane accountUI=loader.load();
			Scene scene=new Scene(accountUI);
			Stage accountStage=new Stage();
			accountStage.setTitle("Create/Change Account");
			accountStage.initModality(Modality.WINDOW_MODAL);
			accountStage.initOwner(MainApp.getPrimaryStage());
			accountStage.setScene(scene);
            SimpleAccountController controller=loader.getController();
            controller.setStage(accountStage);
            accountStage.showAndWait();
            
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
    
    public void deleteAccount(){
		
   	}
    
    public void updateAccount(){
		
   	}
    public void showFianceMainUI(){
		MainApp.showFianceMainUI();
   	}
    
    
}
