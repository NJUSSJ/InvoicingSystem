package vo;

/**
 * 
 * @author yrz
 *	�տ
 */
public class ReceiveBillVO {
	long id;
	long userid;
	long memberid;
	double sum;
	int time;
	boolean state=false;
	
	public ReceiveBillVO(long id ,long userid,long memberid,double sum,int time) {
		this.id=id;
		this.sum=sum;
		this.memberid=memberid;
		this.userid=userid;
		this.time=time;
	}
}
