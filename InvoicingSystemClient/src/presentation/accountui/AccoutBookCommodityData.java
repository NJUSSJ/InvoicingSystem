package presentation.accountui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccoutBookCommodityData {
	StringProperty id=new SimpleStringProperty();
	StringProperty name=new SimpleStringProperty();
	StringProperty mode=new SimpleStringProperty();
	StringProperty importprice=new SimpleStringProperty();
	StringProperty saleprice=new SimpleStringProperty();
	StringProperty parent=new SimpleStringProperty();
	
	public AccoutBookCommodityData(String id,String name,String mode,String importprice,String saleprice,String parent) {
		// TODO Auto-generated constructor stub
		this.id.set(id);
		this.name.set(name);
		this.mode.set(mode);
		this.importprice.set(importprice);
		this.saleprice.set(saleprice);
		this.parent.set(parent);
	}
	
	public StringProperty getID() {
		return id;
	}
	
	public StringProperty getName() {
		return name;
	}
	
	public StringProperty getModel() {
		return mode;
	}
	
	public StringProperty getImportPrice() {
		return importprice;
	}
	
	public StringProperty getSalePrice() {
		return saleprice;
	}
	
	public StringProperty getParent() {
		return parent;
	}
}
