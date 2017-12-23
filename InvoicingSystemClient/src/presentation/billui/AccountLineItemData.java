package presentation.billui;

import businesslogic.billbl.AccountLineItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountLineItemData {
	private StringProperty idPro;
	private StringProperty moneyPro;
	private StringProperty remarkPro;
	AccountLineItem a;
	public AccountLineItemData(AccountLineItem a){
		this.idPro=new SimpleStringProperty(Long.toString(a.getAccountID()));
		this.moneyPro=new SimpleStringProperty(Double.toString(a.getMoney()));
		this.remarkPro=new SimpleStringProperty(a.getRemark());
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
