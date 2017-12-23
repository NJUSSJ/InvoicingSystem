package presentation.commodityui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CategoryVO;

public class CategoryData {
	StringProperty id=new SimpleStringProperty();
	StringProperty name=new SimpleStringProperty();
	StringProperty parentname=new SimpleStringProperty();
	CategoryVO vo;
	public  CategoryData(CategoryVO vo){
         this.vo=vo;
         id.set(Long.toString(vo.getID()));
         name.set(vo.getName());
         parentname.set(Long.toString(vo.getParentID()));
	}
	public StringProperty getID(){
		return id;
	}
	public StringProperty getName(){
		return name;
	}
	public StringProperty getParentName(){
		return parentname;
	}	
	public CategoryVO getVO(){
		return vo;
	}
	public void setName(String name){
		this.name.set(name);
	}
}
