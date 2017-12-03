package vo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import po.AccountPO;

public class AccountVO {
	long id;
	double deposit;
	String name;
	StringProperty namePro;
	StringProperty depositPro;
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
	public StringProperty getNameProperty(){
		namePro.set(name);
		return namePro;
	}
	
	public StringProperty getDepositProperty(){
		depositPro.set(Double.toString(deposit));
		return depositPro;
	}
}
