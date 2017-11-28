package po;

import java.io.Serializable;
import java.sql.Date;



public class ImportBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	long userid;
	long memberid;
	String commodityList;
	int sum;
	int state=0;
	Date time;
	int num;
	
	public ImportBillPO(long id,long userid,long memberid,String list,int sum,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.state=state;
		this.time=time;
	}
	
	public long getID() {
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
	
	public int getsum() {
		return sum;
	}
	public int getnum(){
		return num;
	}
	public Date getDate() {
		return time;
	}
	public int getState() {
		return state;
	}
	
	public Date getTime() {
		return time;
	}
}
