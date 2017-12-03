package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
	
	public void showLoginUI(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	
	public void showEmailUI(){
		MainApp.showEmailUI();
	}
	
	public void showCategoryUI(){
		MainApp.showCategoryUI();
	}

	public void showCommodityUI(){
		MainApp.showCommodityUI();
	}

	public void showStockCheckUI(){
		MainApp.showStockCheckUI();
	}

	public void showStockInventoryUI(){
		MainApp.showStockInventoryUI();
	}
	
    public void showWarningUI(){
       MainApp.showWarningUI();
    }
	 
}
