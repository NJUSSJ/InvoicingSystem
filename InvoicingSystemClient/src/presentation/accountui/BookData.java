package presentation.accountui;

import javafx.beans.property.StringProperty;

public class BookData {
StringProperty name;
StringProperty date;
public StringProperty getNameProperty(){
	return name;
}
public StringProperty getDateProperty(){
	return date;
}
}
