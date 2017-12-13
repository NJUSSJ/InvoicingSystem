package presentation.commodityui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CategoryVO;

public class CategoryData {
StringProperty id=new SimpleStringProperty();
StringProperty name=new SimpleStringProperty();
StringProperty parentname=new SimpleStringProperty();
CategoryVO a;
public  CategoryData(CategoryVO a){
         this.a=a;
         id.set(Long.toString(a.getID()));
         name.set(a.getName());
         parentname.set(Long.toString(a.getParentID()));
}
public StringProperty getId(){
	return id;
}
public StringProperty getName(){
	return name;
}
public StringProperty getParentName(){
	return parentname;
}
public CategoryVO getVO(){
	return a;
}
}
