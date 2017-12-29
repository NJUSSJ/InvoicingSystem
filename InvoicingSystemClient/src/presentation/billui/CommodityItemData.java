package presentation.billui;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CommodityVO;

public class CommodityItemData {
StringProperty name=new SimpleStringProperty();
StringProperty id=new SimpleStringProperty();
StringProperty num=new SimpleStringProperty();
CommodityBLService cbs=new CommodityController();
CommodityVO item=null;
public CommodityItemData(CommodityLineItem a){
	long Id=a.getCommodityID();
	item=cbs.findCommodityByID(Id);
	name.set(item.getName());
	id.set(""+item.getID());
	num.set(""+a.getNum());
	
}
	public StringProperty getNameProperty() {
		// TODO Auto-generated method stub
		return name;
	}

	public StringProperty getNumProperty() {
		// TODO Auto-generated method stub
		return num;
	}

	public StringProperty getidProperty() {
		// TODO Auto-generated method stub
		return id;
	}

}
