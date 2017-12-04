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
	
	public CategoryPO(long id,String name,long parentid) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.parentid=parentid;
		
		
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
}
