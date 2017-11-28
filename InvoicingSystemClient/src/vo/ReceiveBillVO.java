package vo;

import java.sql.Date;

/**
 * 
 * @author yrz
 *	�տ
 */
public class ReceiveBillVO {
	String id;
	long userid;
	long memberid;
	double sum;
	Date time;
	boolean state=false;
	
	public ReceiveBillVO(String id ,long userid,long memberid,double sum,Date time) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
	}
	
	public String getID() {
		return id;
	}
	
	public double getSum() {
		return sum;
	}
	
	public long getMemberID() {
		return memberid;
	}
	
	public long getUserID() {
		return userid;
	}
	
	public Date getTime() {
		return time;
	}
}
