package presentation.commodityui;

import java.net.URL;
import java.util.ResourceBundle;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
	private ObservableList<CategoryData> list =FXCollections.observableArrayList();
	
	CategoryVO categoryVO;
	
	CategoryData data;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(style==1){
			long largest=-1;
			for(int i=0;i<list.size();i++) {
				if(Long.parseLong(list.get(i).getID().get())>largest)
					largest=Long.parseLong(list.get(i).getID().get());
			}
			id.setText(largest+1+"");
		}
	}
	public void setStage(Stage categoryStage) {
		stage=categoryStage;
	}
	public void setParentID(long parentID) {
		parentid.setText(Long.toString(parentID));
		style=1;
	}
	public void cancel(){
		stage.close();
	}
	public void setCategory(){
		String idText=id.getText();
		String nameText=name.getText();
		String parentidText=parentid.getText();
		if(style==1){
			long largest=-1;
			for(int i=0;i<list.size();i++) {
				if(Long.parseLong(list.get(i).getID().get())>largest)
					largest=Long.parseLong(list.get(i).getID().get());
			}
			String id=largest+1+"";
			while(id.length()<5) {
				id="0"+id;
			}
			categoryVO=new CategoryVO(Long.parseLong(id),nameText,Long.parseLong(parentidText));
			cbs.addCategory(categoryVO);
			if(Long.parseLong(parentidText)==-1){
				list.add(new CategoryData(categoryVO));
			}
		}else{
			categoryVO=new CategoryVO(Long.parseLong(idText),nameText,Long.parseLong(parentidText));
			cbs.updateCategory(categoryVO);
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
