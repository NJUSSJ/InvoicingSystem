package presentation.accountui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountBookMemberData {
	StringProperty category=new SimpleStringProperty();
	StringProperty name=new SimpleStringProperty();
	StringProperty tel=new SimpleStringProperty();
	StringProperty shouldget=new SimpleStringProperty();
	StringProperty shouldpay=new SimpleStringProperty();
	
	public AccountBookMemberData(String category,String name,String tel,String shouldget,String shouldpay) {
		// TODO Auto-generated constructor stub
		this.category.set(category);
		this.name.set(name);
		this.tel.set(tel);
		this.shouldget.set(shouldget);
		this.shouldpay.set(shouldpay);
	}
	
	public StringProperty getCategory() {
		return category;
	}
	
	public StringProperty getName() {
		return name;
	}
	
	public StringProperty getTel() {
		return tel;
	}
	
	public StringProperty getShouldGet() {
		return shouldget;
	}
	
	public StringProperty getShouldPay() {
		return shouldpay;
	}
	
	
}
