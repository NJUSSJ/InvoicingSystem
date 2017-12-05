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
		id.setText("ID:"+MainApp.getID());
	}
	@FXML
	public void showEmailUI(){
		MainApp.showEmailUI();
	}
	@FXML
	public void showLoginUI(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showMemberUI(){
		MainApp.showMemberUI();
	}
	@FXML
	public void showImportUI(){
		MainApp.showImportUI();
	}
	@FXML
	public void showImportReturnUI(){
		MainApp.showImportReturnUI();
	}
	@FXML
	public void showSaleUI(){
		MainApp.showSaleUI();
	}
	@FXML
	public void showSaleReturnUI(){
		MainApp.showSaleReturnUI();
	}
}
