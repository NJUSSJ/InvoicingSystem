package vo;

/**
 * 
 * @author yrz
 *	¸¶¿îµ¥
 */
public class PayBillVO {
	long id;
	long userid;
	long memberid;
	double sum;
	int time;
	boolean state=false;
	
	
	public PayBillVO() {
		// TODO Auto-generated constructor stub
	}
	public PayBillVO(long id ,long user,long memberid,int sum,int time) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void setSum(double sum) {
		this.sum=sum;
	}
	
	public long getMemberID() {
		return memberid;
	}
	
	public void setMemberID(long memberid) {
		this.memberid=memberid;
	}
	
	public void setState(Boolean state) {
		this.state=state;
	}
	
	
}
