package vo;

import po.AccountPO;

public class AccountVO {
	long id;
	double deposit;
	String name;
	
	public AccountVO(long id,double deposit,String name){
		this.id=id;
		this.name=name;
		this.deposit=deposit;
	}
	public AccountPO toAccountPO(){
		return new AccountPO(id,deposit,name);
	}
	public long getID(){
		return id;
	}
	public double getDeposit(){
		return deposit;
	}
	public String getName(){
		return name;
	}
	public void setDeposit(double deposit){
		this.deposit=deposit;
	}
	public void setName(String name){
		this.name=name;
	}
}
