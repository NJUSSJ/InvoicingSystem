package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.UserVO;

public class UserData {
StringProperty id=new SimpleStringProperty();
StringProperty name=new SimpleStringProperty();
StringProperty rank=new SimpleStringProperty();
StringProperty password=new SimpleStringProperty();
UserVO a;
public UserData(UserVO a){
	id.set(Long.toString(a.getID()));
	rank.set(Integer.toString(a.getRank()));
	name.set(a.getUsername());
	password.set(a.getPassword());
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

}
