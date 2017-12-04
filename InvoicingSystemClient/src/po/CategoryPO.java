package po;

import java.io.Serializable;

public class CategoryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String name;
	long parentid;
	String subCategoryID;
	String subCommodityID;
	
	public CategoryPO(long id,String name,long parentid,String subCategoryID,String subCommodityID) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.parentid=parentid;
		this.subCategoryID=subCategoryID;
		this.subCommodityID=subCommodityID;
		
	}
	public long getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public long getParentID(){
		return parentid;
	}
	public String getSubCategoryID(){
		return subCategoryID;
	}
	public String getSubCommodityID(){
		return subCommodityID;
	}
}
