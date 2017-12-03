package presentation.billui;

import businesslogic.billbl.AccountLineItem;
import javafx.beans.property.StringProperty;

public class AccountLineItemData {
	StringProperty idPro;
	StringProperty moneyPro;
	StringProperty remarkPro;
	AccountLineItem a;
	public AccountLineItemData(AccountLineItem a){
		idPro.set(Long.toString(a.getAccountID()));
		moneyPro.set(Double.toString(a.getMoney()));
		remarkPro.set(a.getRemark());
		this.a=a;
	}
	public StringProperty getName(){
		return idPro;
	}
    public StringProperty getMoney(){
		return moneyPro;
	}
    public StringProperty getRemark(){
	    return remarkPro;
    }
    public AccountLineItem getVO(){
	    return a;
    }
}
