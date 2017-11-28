package po;

import java.io.Serializable;
import java.sql.Date;

public class ImportReturnBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String commodityList;
	int sum;
	Date time;
	int num;
	public ImportReturnBillPO(String id,long userid,long memberid,String list,int sum,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;this.userid=userid;
		this.memberid=memberid;
		this.commodityList=list;
		this.sum=sum;
		this.time=time;
		
	}
	
	public String getID() {
		return id;
	}
	
	public long getUser() {
		return userid;
	}
	
	public long getMember() {
		return memberid;
	}
	
	public Date getTime() {
		return time;
	}
	public int getnum(){
		return num;
	}

	public double getsum() {
		return sum;
	}
}
