package businesslogic.billbl;

import javafx.beans.property.StringProperty;

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
	public void setAccountID(long id){
		accountid=id;
	}
	public void setMoney(double money){
		this.money=money;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}

}
