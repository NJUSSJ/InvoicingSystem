package presentation.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import MainApp.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	@FXML
	private Button promotionButton;
	@FXML
	private Button examineButton;
	@FXML
	private Button manageCourseButton;
	@FXML
	private Button manageSituationButton;
	@FXML
	private Button saleDetailsButton;
	@FXML
	private Button emailButton;
	@FXML
	private Button logButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		long idLong=MainApp.getID();
		String idString=idLong+"";
		while(idString.length()<5) {
			idString="0"+idString;
		}
		id.setText("ID:"+idString);
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
}
