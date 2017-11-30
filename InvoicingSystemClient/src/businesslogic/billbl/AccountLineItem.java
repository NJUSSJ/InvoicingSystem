package businesslogic.billbl;

public class AccountLineItem {
	long accountid;
	double money;
	String remark;
	public AccountLineItem(long accountid,double money,String remark){
		this.accountid=accountid;
		this.money=money;
		this.remark=remark;
	}
	public AccountLineItem(long accountid,double money){
		this.accountid=accountid;
		this.money=money;
	}
	public long getAccountID(){
		return accountid;
	}
	public double getMoney(){
		return money;
	}
	public String getRemark(){
		return remark;
	}
}
