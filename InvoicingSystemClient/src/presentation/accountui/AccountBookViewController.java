package presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.AccountVO;

public class AccountBookViewController implements Initializable {
	@FXML
	private Label id;
	
	@FXML
	private Label logout;

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
	
public  ObservableList<BookData> bookData =FXCollections.observableArrayList();
	
	@FXML
	private TableView<BookData> bookTable;
	
	@FXML
	private TableColumn<BookData,String> nameColoumn;
	
	@FXML
	private TableColumn<BookData,String> dateColoumn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
		bookTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> getInf(newValue));
		nameColoumn.setCellValueFactory(cellData ->cellData.getValue().getNameProperty());
    	dateColoumn.setCellValueFactory(cellData ->cellData.getValue().getDateProperty());
	   
}
	private void getInf(BookData newValue) {
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