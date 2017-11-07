package vo;

/**
 * 
 * @author yrz
 *	�տ
 */
public class ReceiveBillVO {
	long id;
	String user;
	String member;
	int sum;
	int time;
	
	public ReceiveBillVO(long id ,String user,String member,int sum,int time) {
		this.id=id;
		this.sum=sum;
		this.member=member;
		this.user=user;
		this.time=time;
	}
}
