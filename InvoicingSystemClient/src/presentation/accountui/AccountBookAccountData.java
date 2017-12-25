package presentation.accountui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountBookAccountData {
	StringProperty id=new SimpleStringProperty();
	StringProperty deposit=new SimpleStringProperty();
	
	public AccountBookAccountData(String id,String deposit) {
		// TODO Auto-generated constructor stub
		this.id.set(id);
		this.deposit.set(deposit);	
	}
	
	public StringProperty getID() {
		return id;
	}
	
	public StringProperty getDeposit() {
		return deposit;
	}
	
}
