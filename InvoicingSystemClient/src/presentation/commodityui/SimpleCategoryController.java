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
import vo.CategoryVO;

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
	
	int style=0;
	
	CommodityBLService cbs=new CommodityController();
	
	CategoryVO a;
	
	static long times=0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setText(Long.toString(times));
	}
	public void setStage(Stage categoryStage) {
		// TODO Auto-generated method stub
		stage=categoryStage;
	}
	public void setParentID(long parentID2) {
		// TODO Auto-generated method stub
		parentid.setText(Long.toString(parentID2));
		style=1;
	}
	public void cancel(){
		stage.close();
	}
	public void setCategory(){
		if(style==1){
			String a=id.getText();
			String b=name.getText();
			String c=parentid.getText();
			this.a=new CategoryVO(Long.parseLong(a),b,Long.parseLong(c));
			cbs.addCategory(this.a);
		}else{
			times++;
			String a=id.getText();
			String b=name.getText();
			String c=parentid.getText();
			this.a=new CategoryVO(Long.parseLong(a),b,Long.parseLong(c));
			cbs.updateCategory(this.a);
		}
	}
	public void setItem(CategoryVO a) {
		// TODO Auto-generated method stub
		this.a=a;
		id.setText(Long.toString(a.getID()));
		name.setText(a.getName());
		parentid.setText(Long.toString(a.getParentID()));
	}
}
