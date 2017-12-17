package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.UserVO;

public class UserData {
StringProperty id;
StringProperty name=new SimpleStringProperty();
StringProperty rank=new SimpleStringProperty();
StringProperty password=new SimpleStringProperty();
UserVO a;
public UserData(UserVO a){
	id=new SimpleStringProperty(Long.toString(a.getID()));
	rank=new SimpleStringProperty(Integer.toString(a.getRank()));
	name=new SimpleStringProperty(a.getUsername());
	password=new SimpleStringProperty(a.getPassword());
	this.a=a;
}
public UserVO getVO() {
	// TODO Auto-generated method stub
	return a;
}
public StringProperty getNameProperty() {
	// TODO Auto-generated method stub
	return name;
}
public StringProperty getRankProperty() {
	// TODO Auto-generated method stub
	return rank;
}
public StringProperty getPasswordProperty() {
	// TODO Auto-generated method stub
	return password;
}
public StringProperty getIDProperty() {
	// TODO Auto-generated method stub
	return id;
}

public void setName(String name) {
	this.name.set(name);
}

public void setRank(String rank) {
	this.rank.set(rank);
}
public void setPassword(String password) {
	this.password.set(password);
}
public void setID(String id) {
	this.id.set(id);
}

}
