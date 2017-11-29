package vo;

import po.AccountPO;

public class AccountVO {
	long id;
	double deposit;
	String bank;
	
	public AccountVO(long id,double deposit,String bank){
		this.id=id;
		this.bank=bank;
		this.deposit=deposit;
	}
	public AccountPO toAccountPO(){
		return new AccountPO(id,deposit,bank);
	}
	public long getID(){
		return id;
	}
	public double getDeposit(){
		return deposit;
	}
	public String getBank(){
		return bank;
	}
	public void setDeposit(double deposit){
		this.deposit=deposit;
	}
	public void setBank(String bank){
		this.bank=bank;
	}
}
