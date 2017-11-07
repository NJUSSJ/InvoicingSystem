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
	int sum;
	int time;
	
	public PayBillVO(long id ,String user,String member,int sum,int time) {
		this.id=id;
		this.sum=sum;
		this.member=member;
		this.user=user;
		this.time=time;
	}
}
