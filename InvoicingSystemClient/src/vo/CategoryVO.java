package vo;

import po.CategoryPO;

public class CategoryVO {
	long id;
	String name;
	long parentid;
	
	public CategoryVO(long id,String name,long parentid) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.parentid=parentid;
	}
	public CategoryPO toCategoryPO(){
		return new CategoryPO(id,name,parentid);
	}
	public String getName(){
		return name;
	}
	public long getParentID(){
		return parentid;
	}
	public void setParentID(long id){
		this.parentid=parentid;
	}
	public void setName(String name){
		this.name=name;
	}
	
}
