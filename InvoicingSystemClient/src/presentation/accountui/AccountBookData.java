package presentation.accountui;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountBookData {
	StringProperty name=new SimpleStringProperty();
	StringProperty time=new SimpleStringProperty();
	StringProperty commodityList=new SimpleStringProperty();
	StringProperty accountList=new SimpleStringProperty();
	StringProperty memberList=new SimpleStringProperty();
	
	public AccountBookData(Date time,String commodityList,String accountList,String memberList) {
		// TODO Auto-generated constructor stub
		this.time.set(time+"");
		this.commodityList.set(commodityList);
		this.accountList.set(accountList);
		this.memberList.set(memberList);
		this.name.set(time+" ÆÚ³õÕËÄ¿");
	}
	
	public StringProperty getTimeProperty() {
		return time;
	}
	
	public StringProperty getCommodityProperty() {
		return commodityList;
	}
	
	public StringProperty getAccountProperty() {
		return accountList;
	}
	
	public StringProperty getMemberProperty() {
		return memberList;
	}
	
	public StringProperty getNameProperty() {
		return name;
	}
}
