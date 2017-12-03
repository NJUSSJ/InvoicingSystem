package po;

import java.io.Serializable;

public class AccountPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	double deposit;
	String name;
	
	public AccountPO(long id,double deposit,String name){
		this.id=id;
		this.name=name;
		this.deposit=deposit;
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
}

