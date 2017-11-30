package vo;

import java.util.ArrayList;

public class CategoryVO {
	long id;
	String name;
	String parent;
	ArrayList<Long> subCategoryID;
	ArrayList<Long> subCommodityID;
	
	public CategoryVO(long id,String name,String parent,ArrayList<Long> subCategoryID,
			ArrayList<Long> subCommodityID) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.parent=parent;
		this.subCategoryID=subCategoryID;
		this.subCommodityID=subCommodityID;
	}
	public String getName(){
		return name;
	}
	public String getParent(){
		return parent;
	}
}
