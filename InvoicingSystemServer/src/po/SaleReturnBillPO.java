package po;

import java.io.Serializable;



public class SaleReturnBillPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String commodityList;
	int sum;
	int time;
	int num;
	boolean state=false;
	
	public SaleReturnBillPO(String id,long userid,long memberid,String list,int sum,int time) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		
	}
	
	public String getID() {
		return id;
	}
	
	public long getUserID() {
		return userid;
	}
	
	public void setUserID(long userid) {
		this.userid=userid;
	}
	
	public long getMemberID() {
		return memberid;
	}
	
	public void setMemberID(long memberid) {
		this.memberid=memberid;
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
}
