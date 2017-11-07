package vo;

/**
 * 
 * @author yrz
 * 现金费用单
 *
 */
public class CashBillVO {
	long id;
	String user;
	String member;
	Boolean state=false;
	int time;
	public CashBillVO(long id,String user,String member,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.member=member;
		this.user=user;
		this.time=time;
	}
	
	public void passState() {
		state=true;
	}
	
	public String getUser() {
		return user;
	}
	
	public void changeUser(String user) {
		this.user=user;
	}
	
	public long getID() {
		return id;
	}
	
	public String getMember() {
		return member;
	}
	
	public void changeMember(String member)
	{
		this.member=member;
	}
}
