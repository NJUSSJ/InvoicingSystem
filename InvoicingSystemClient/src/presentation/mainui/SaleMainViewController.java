package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SaleMainViewController implements Initializable  {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private ImageView email;
	@FXML
	private ImageView member;
	@FXML
	private ImageView importReturn;
	@FXML
	private ImageView importBill;
	@FXML
	private ImageView sale;
	@FXML
	private ImageView saleReturn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void showEmailUI(){
		MainApp.showEmailUI();
	}

	public void showLoginUI(){
		MainApp.showLoginUI();
	}
	
	public void showMemberUI(){
		MainApp.showMemberUI();
	}
	
	public void showImportUI(){
		MainApp.showImportUI();
	}
	
	public void showImportReturnUI(){
		MainApp.showImportReturnUI();
	}
	
	public void showSaleUI(){
		MainApp.showSaleUI();
	}
	
	public void showSaleReturnUI(){
		MainApp.showSaleReturnUI();
	}
}
