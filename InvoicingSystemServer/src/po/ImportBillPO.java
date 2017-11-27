package po;

import java.io.Serializable;
import java.sql.Date;



public class ImportBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String user;
	String member;
	String commodityList;
	int sum;
	Boolean state=false;
	Date time;
	int num;
	
	public ImportBillPO(long id,String user,String member,String list,int sum,Date time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.member=member;
		this.user=user;
		this.sum=sum;	
		this.time=time;
	}
	
	public long getID() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void changeUser(String user) {
		this.user=user;
	}
	
	public String getMember() {
		return member;
	}
	
	public void changeMember(String member) {
		this.member=member;
	}
	
	public String getList() {
		return commodityList;
	}
	
	public int getsum() {
		return sum;
	}
	public int getnum(){
		return num;
	}
	public Date getDate() {
		return time;
	}
}
