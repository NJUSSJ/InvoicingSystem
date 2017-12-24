package presentation.tableui;

import java.sql.Date;
import java.text.SimpleDateFormat;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.beans.property.StringProperty;
import vo.CommodityVO;
public class CommodityItemData {
StringProperty name;
StringProperty date;
StringProperty model;
StringProperty price;
StringProperty num;
StringProperty totalprice;
CommodityVO commodity=null;
Date its=null;
CommodityBLService cbs=new CommodityController();
public CommodityItemData(CommodityLineItem a,Date b){
	commodity=cbs.findCommodityByID(a.getCommodityID());
	name.set(commodity.getName());
	model.set(commodity.getModel());
	price.set(""+a.getSalePrice());
	num.set(""+a.getNum());
	totalprice.set(""+a.getNum()*a.getSalePrice());
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	String str=sdf.format(a);
	date.set(""+str);
}
public StringProperty getNameProperty(){
	return name;
}
public StringProperty getModelProperty(){
	return model;
}
public StringProperty getPriceProperty(){
	return price;
}
public StringProperty getNumProperty(){
	return num;
}
public StringProperty getTotalPriceProperty(){
	return totalprice;
}
public StringProperty getDateProperty(){
	return date;
}
}