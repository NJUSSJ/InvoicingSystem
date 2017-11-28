package po;

import java.io.Serializable;
import java.sql.Date;



public class SaleBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String commodityList;
	double sum;
	Date time;
	int num=0;
	boolean state=false;
	
	public SaleBillPO() {
		// TODO Auto-generated constructor stub
	}
	public SaleBillPO(String id,long userid,long memberid,String list,double sum,Date time) {
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
	
	public long getUser() {
		return userid;
	}
	
	public void changeUser(long userid) {
		this.userid=userid;
	}
	
	public long getMember() {
		return memberid;
	}
	
	public void changeMember(long memberid) {
		this.memberid=memberid;
	}
	
	public String getList() {
		return commodityList;
	}
	
	public double getsum() {
		return sum;
	}
}
