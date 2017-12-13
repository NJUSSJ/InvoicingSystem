package presentation.accountui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.AccountVO;

public class AccountData {
	StringProperty namePro=new SimpleStringProperty();
	StringProperty depositPro=new SimpleStringProperty();
	StringProperty idPro=new SimpleStringProperty();
	AccountVO a;
	public AccountData(AccountVO a){
		namePro.set(a.getName());
		depositPro.set(Double.toString(a.getDeposit()));
		idPro.set(Long.toString(a.getID()));
		this.a=a;
	}
	public StringProperty getNameProperty() {
		// TODO Auto-generated method stub
		return namePro;
	}
	public StringProperty getDepositProperty() {
		// TODO Auto-generated method stub
		return depositPro;
	}
	public AccountVO getVO(){
		return a;
	}
	public StringProperty getidProperty() {
		// TODO Auto-generated method stub
		return idPro;
	}
}
