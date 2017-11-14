package vo;

/**
 * 
 * @author yrz
 *	¸¶¿îµ¥
 */
public class PayBillVO {
	long id;
	String  user;
	String member;
	double sum;
	int time;
	Boolean state=false;
	
	
	public PayBillVO() {
		// TODO Auto-generated constructor stub
	}
	public PayBillVO(long id ,String user,String member,int sum,int time) {
		this.id=id;
		this.sum=sum;
		this.member=member;
		this.user=user;
		this.time=time;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void setSum(double sum) {
		this.sum=sum;
	}
	
	public String getMember() {
		return member;
	}
	
	public void setMember(String member) {
		this.member=member;
	}
	
	public void setState(Boolean state) {
		this.state=state;
	}
	
	
}
