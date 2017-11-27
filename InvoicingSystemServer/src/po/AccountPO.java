package po;

import java.io.Serializable;

public class AccountPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String bank;
	double deposit;
	
	public AccountPO() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountPO(long id, String bank,double deposit) {
		this.bank=bank;
		this.deposit=deposit;
		this.id=id;
	}
	
	public double getDposit() {
		return deposit;
	}
	
	public String getBank() {
		return bank;
	}
	
	public long getID() {
		return id;
	}
}

