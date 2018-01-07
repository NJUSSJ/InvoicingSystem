package presentation.commodityui;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MainApp.MainApp;
import businesslogic.commoditybl.CommodityController;
import businesslogic.logbl.LogController;
import businesslogic.utilitybl.Utility;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import vo.CategoryVO;
import vo.CommodityVO;
import vo.LogVO;

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
	
	private ObservableList<CategoryData> list =FXCollections.observableArrayList();
	
	CategoryVO categoryVO;
	
	CategoryData data;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void setStage(Stage categoryStage) {
		stage=categoryStage;
	}
	public void setParentID(long parentID) {
		parentid.setText(Long.toString(parentID));
		style=1;
		long idNum=cbs.findLargestIDofCategory()+1;
		id.setText(idNum+"");
	}
	public void cancel(){
		stage.close();
	}
	public void setCategory(){
		String idText=id.getText();
		String nameText=name.getText();
		String parentidText=parentid.getText();
		if(style==1){
			CategoryVO parentCate=cbs.findCategoryByID(Long.parseLong(parentidText));
			ArrayList<CommodityVO> child=cbs.findDownCommodity(parentCate);
			if(child!=null&&child.size()>0) {
				Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(MainApp.getPrimaryStage());
		        alert.setTitle("Parent has commodity");
		        alert.setHeaderText("Parent has commodity");
		        alert.setContentText("Parent has commodity:"+parentidText);
		        alert.showAndWait();
		        return;
			}
			
			
			long idNum=cbs.findLargestIDofCategory()+1;
			/*String id=idNum+"";
			while(id.length()<5) {
				id="0"+id;
			}*/
			categoryVO=new CategoryVO(idNum,nameText,Long.parseLong(parentidText));
			cbs.addCategory(categoryVO);
			//记录日志
			LogController logController=new LogController();
			long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"addCategory:"+categoryVO.getID(),MainApp.getID());
	        logController.addLog(logVO);
			if(Long.parseLong(parentidText)==-1){
				list.add(new CategoryData(categoryVO));
			}
		}else{
			categoryVO=new CategoryVO(Long.parseLong(idText),nameText,Long.parseLong(parentidText));
			cbs.updateCategory(categoryVO);
			//记录日志
			LogController logController=new LogController();
			long logID=logController.findLargestID()+1;
	        LogVO logVO=new LogVO(logID,new Date(Utility.getNow().getTime()),"updateCategory:"+categoryVO.getID(),MainApp.getID());
	        logController.addLog(logVO);
			data.setName(nameText);
		}
		stage.close();
	}
	public void setItem(CategoryVO vo,CategoryData data) {
		categoryVO=vo;
		id.setText(Long.toString(vo.getID()));
		name.setText(vo.getName());
		parentid.setText(Long.toString(vo.getParentID()));
		this.data=data;
	}
	public void setList(ObservableList<CategoryData> list){
		this.list=list;
	}
}
