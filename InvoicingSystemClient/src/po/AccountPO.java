package po;

import java.io.Serializable;

public class AccountPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	double deposit;
	String bank;
	
	public AccountPO(long id,double deposit,String bank){
		this.id=id;
		this.bank=bank;
		this.deposit=deposit;
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
}

