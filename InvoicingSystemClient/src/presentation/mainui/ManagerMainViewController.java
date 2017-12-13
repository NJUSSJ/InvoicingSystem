package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ManagerMainViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private ImageView examine;
	@FXML
	private ImageView manageCourse;
	@FXML
	private ImageView manageSituation;
	@FXML
	private ImageView saleDetails;
	@FXML
	private ImageView email;
	@FXML
	private ImageView log;
	@FXML
	private ImageView strategy;
	
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
	public void showLoginUI(){
		MainApp.cancelUser();
		MainApp.showLoginUI();
	}
	@FXML
	public void showStrategyUI(){
		MainApp.showStrategyUI();
	}
	@FXML
	public void showexamineUI(){
		MainApp.showExamineUI();
	}
	@FXML
	public void showPricePromotionUI(){
		MainApp.showPricePromotionUI();
	}
}
