package presentation.billui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemData {
  StringProperty name=new SimpleStringProperty();
  StringProperty money=new SimpleStringProperty();
  StringProperty note=new SimpleStringProperty();
  public ItemData(String name,String money,String note){
	  this.name.set(name);
	  this.money.set(money);
	  this.note.set(note);
  }
public StringProperty getName() {
	// TODO Auto-generated method stub
	return name;
}
public StringProperty getMoney() {
	// TODO Auto-generated method stub
	return money;
}
public StringProperty getNote() {
	
	return note;
}
public String getname(){
	return name.get();
}
public String getmoney(){
	return money.get();
}
public String getnote(){
	return note.get();
}
public void setName(String name) {
	this.name.set(name);
}
public void setMoney(String money) {
	this.money.set(money);
}
public void setNote(String note) {
	this.note.set(note);
}
}
