package presentation.commodityui;

import javafx.beans.property.StringProperty;
import vo.CategoryVO;

public class CategoryData {
StringProperty id;
StringProperty name;
StringProperty parentname;
CategoryVO a;
public  CategoryData(CategoryVO a){
         this.a=a;
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
