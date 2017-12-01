package po;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String name;
	String parent;
	String subCategoryID;
	String subCommodityID;
	
	public CategoryPO(long id,String name,String parent,String subCategoryID,String subCommodityID) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.parent=parent;
		this.subCategoryID=subCategoryID;
		this.subCommodityID=subCommodityID;
		
	}
	public long getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getParent(){
		return parent;
	}
	public String getSubCategoryID(){
		return subCategoryID;
	}
	public String getSubCommodityID(){
		return subCommodityID;
	}
}
