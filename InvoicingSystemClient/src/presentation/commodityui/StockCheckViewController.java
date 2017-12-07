package presentation.commodityui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.transform.sax.SAXTransformerFactory;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class StockCheckViewController implements Initializable {

	@FXML
	ChoiceBox<String> startYear;
	
	@FXML
	ChoiceBox<String> startMonth;
	
	@FXML
	ChoiceBox<String> startDay;
	
	@FXML
	ChoiceBox<String> endYear;
	
	@FXML
	ChoiceBox<String> endMonth;
	
	@FXML
	ChoiceBox<String> endDay;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startYear.setItems(FXCollections.observableArrayList("2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		startMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		startDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));
		
		endYear.setItems(FXCollections.observableArrayList("2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"));
		endMonth.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","9","10","11","12"));
		endDay.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"));

	}
	
}
