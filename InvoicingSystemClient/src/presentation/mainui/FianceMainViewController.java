package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FianceMainViewController implements Initializable  {
	@FXML
	private ImageView accountBook;
	@FXML
	private ImageView manageCourse;
	@FXML
	private ImageView manageSituation;
	@FXML
	private ImageView saleDetails;
	@FXML
	private Label id;
	@FXML
	private ImageView account;
	@FXML
	private ImageView email;
	@FXML
	private ImageView payBill;
	@FXML
	private ImageView receiveBill;
	@FXML
	private ImageView log;
	@FXML
	private Label logout;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void showLogUI(){
		MainApp.showLogUI();
	}
	
	public void showEmailUI(){
		MainApp.showEmailUI();
	}
	
	public void showManageCourseUI(){
		MainApp.showManageCourseUI();
	}
	
	public void showManageSituationUI(){
		MainApp.showManageSituationUI();
	}
	
	public void showSaleDetailsUI(){
		MainApp.showSaleDetailsUI();
	}
	
	public void showaccountUI(){
		MainApp.showAccountUI();
	}
	
	public void showReceiveBillUI(){
		MainApp.showReceiveBillUI();
	}
	
	public void showLoginUI(){
		MainApp.showLoginUI();
	}
	
	public void showpayBillUI(){
		MainApp.showPayBillUI();
	}
	
	public void showaccountBookUI(){
		MainApp.showAccountBookUI();
	}
}
