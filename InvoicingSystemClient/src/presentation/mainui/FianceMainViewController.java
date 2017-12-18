package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	private ImageView cashBill;
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
	@FXML
	private Button AccountButton;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
	}
	@FXML
	public void showLogUI(){
		MainApp.showLogUI();
	}
	@FXML
	public void showEmailUI(){
		MainApp.showEmailUI();
	}
	@FXML
	public void showManageCourseUI(){
		MainApp.showManageCourseUI();
	}
	@FXML
	public void showManageSituationUI(){
		MainApp.showManageSituationUI();
	}
	@FXML
	public void showSaleDetailsUI(){
		MainApp.showSaleDetailsUI();
	}
	@FXML
	public void showaccountUI(){
		MainApp.showAccountUI();
	}
	@FXML
	public void showReceiveBillUI(){
		MainApp.showReceiveBillUI();
	}
	@FXML
	public void showLoginUI(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showpayBillUI(){
		MainApp.showPayBillUI();
	}
	@FXML
	public void showcashBill(){
		MainApp.showcashBill();
	}
	@FXML
	public void showaccountBookUI(){
		MainApp.showAccountBookUI();
	}
}
