package presentation.commodityui;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SimpleCategoryController implements Initializable{
	@FXML
	private Button reutrnB;
	
	@FXML
	private Button rightB;
	
	@FXML
	private TextField name;
	
	@FXML
	private Label id;
	
	@FXML
	private Label parentid;
	
	Stage stage;
	
	CommodityBLService cbs=new CommodityController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	public void setStage(Stage categoryStage) {
		// TODO Auto-generated method stub
		stage=categoryStage;
	}
	public void setid(long l) {
		// TODO Auto-generated method stub
		id.setText(Long.toString(l));
	}
	public void setParentID(long parentID2) {
		// TODO Auto-generated method stub
		parentid.setText(Long.toString(parentID2));
	}
	public void cancel(){
		stage.close();
	}
	public void setCategory(){
		
	}
}
