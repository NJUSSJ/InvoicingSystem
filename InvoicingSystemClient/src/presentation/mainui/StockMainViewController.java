package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class StockMainViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private ImageView category;
	@FXML
	private ImageView commodity;
	@FXML
	private ImageView stockCheck;
	@FXML
	private ImageView stockInventory;
	@FXML
	private ImageView email;
	@FXML
	private ImageView warn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText("ID:"+MainApp.getID());
	}
	@FXML
	public void showLoginUI(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showEmailUI(){
		MainApp.showEmailUI();
	}
	@FXML
	public void showCategoryUI(){
		MainApp.showCategoryUI();
	}
	@FXML
	public void showCommodityUI(){
		MainApp.showCommodityUI();
	}
	@FXML
	public void showStockCheckUI(){
		MainApp.showStockCheckUI();
	}
	@FXML
	public void showStockInventoryUI(){
		MainApp.showStockInventoryUI();
	}
	@FXML
    public void showWarningUI(){
       MainApp.showWarningUI();
    }
	 
}
