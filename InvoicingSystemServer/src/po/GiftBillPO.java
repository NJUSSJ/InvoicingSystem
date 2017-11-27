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
	String member;
	String list;
	Date time;
	Boolean state=false;
	public GiftBillPO(long id,long userid,String member,String list,Date time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
		this.member=member;
	}
	public long getID() {
		return id;
	}
	
	public long getUser() {
		return userid;
	}
	
	public String getMember() {
		return member;
	}
	
	public String getList() {
		return list;
	}
	
	public Date getDate() {
		return time;
	}
}
