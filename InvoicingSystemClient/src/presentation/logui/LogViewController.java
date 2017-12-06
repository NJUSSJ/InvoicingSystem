package presentation.logui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogViewController implements Initializable {
	@FXML
	private Label id;
	@FXML
	private Label logout;
	@FXML
	private Button rightB;
	@FXML
	private Button returnB;
	@FXML
	private TextField operator;
	@FXML
	private ChoiceBox<Integer> year1;
	@FXML
	private ChoiceBox<Integer> year2;
	@FXML
	private ChoiceBox<Integer> month1;
	@FXML
	private ChoiceBox<Integer> month2;
	@FXML
	private ChoiceBox<Integer> day1;
	@FXML
	private ChoiceBox<Integer> day2;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
