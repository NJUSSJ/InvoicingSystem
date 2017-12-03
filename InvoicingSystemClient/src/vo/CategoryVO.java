package vo;

import java.util.ArrayList;

import po.CategoryPO;

public class CategoryVO {
	long id;
	String name;
	long parentid;
	ArrayList<Long> subCategoryID;
	ArrayList<Long> subCommodityID;
	
	public CategoryVO(long id,String name,long parentid,ArrayList<Long> subCategoryID,
			ArrayList<Long> subCommodityID) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.parentid=parentid;
		this.subCategoryID=subCategoryID;
		this.subCommodityID=subCommodityID;
	}
	public CategoryPO toCategoryPO(){
		String subCategoryID="",subCommodityID="";
		for(int i=0;i<this.subCategoryID.size();i++){
			subCategoryID+=this.subCategoryID.get(i)+"";
			if(i!=this.subCategoryID.size()-1){
				subCategoryID+=" ";
			}
		}
		for(int i=0;i<this.subCommodityID.size();i++){
			subCommodityID+=this.subCommodityID.get(i)+"";
			if(i!=this.subCommodityID.size()-1){
				subCommodityID+=" ";
			}
		}
		return new CategoryPO(id,name,parentid,subCategoryID,subCommodityID);
	}
	public String getName(){
		return name;
	}
	public long getParentID(){
		return parentid;
	}
	public ArrayList<Long> getSubCategoryID(){
		return subCategoryID;
	}
	public ArrayList<Long> getSubCommodityID(){
		return subCommodityID;
	}
	public void setParentID(long id){
		this.parentid=parentid;
	}
	public void setName(String name){
		this.name=name;
	}
	
}
