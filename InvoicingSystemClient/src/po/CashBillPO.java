package po;

import java.io.Serializable;

public class CashBillPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String user;
	String member;
	Boolean state=false;
	int time;
	public CashBillPO(String id,String user,String member,int time) {
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
	
	public String getID() {
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
