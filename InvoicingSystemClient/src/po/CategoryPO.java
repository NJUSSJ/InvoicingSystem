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
	
	public CategoryPO(String name,String parent,ArrayList<Long> subCategoryID,
			ArrayList<Long> subCommodityID) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.parent=parent;
		for(int i=0;i<subCategoryID.size();i++){
			this.subCategoryID+=subCategoryID.get(i)+"";
			if(i!=subCategoryID.size()-1){
				this.subCategoryID+=" ";
			}
		}
		for(int i=0;i<subCommodityID.size();i++){
			this.subCommodityID+=subCommodityID.get(i)+"";
			if(i!=subCommodityID.size()-1){
				this.subCommodityID+=" ";
			}
		}
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
