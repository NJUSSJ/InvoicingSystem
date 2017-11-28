package po;

import java.io.Serializable;
import java.sql.Date;


public class GiftBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	long userid;
	long memberid;
	String list;
	Date time;
	int state=0;
	public GiftBillPO(long id,long userid,long memberid,String list,Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
		this.memberid=memberid;
		this.state=state;
	}
	public long getID() {
		return id;
	}
	
	public long getUser() {
		return userid;
	}
	
	public long getMember() {
		return memberid;
	}
	
	public String getList() {
		return list;
	}
	
	public Date getDate() {
		return time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state=state;
	}
}
