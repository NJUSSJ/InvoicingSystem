package presentation.saleui;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBLService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CommodityVO;

public class CommodityItemData {
	StringProperty num=new SimpleStringProperty("0");
	StringProperty commodityid=new SimpleStringProperty("0");
	StringProperty saleprice=new SimpleStringProperty("0");
	StringProperty importprice=new SimpleStringProperty("0");
	StringProperty model=new SimpleStringProperty("0");
	StringProperty totalprice=new SimpleStringProperty("0");
	StringProperty note=new SimpleStringProperty("0");
	StringProperty name=new SimpleStringProperty("0");
	CommodityVO a;
	CommodityBLService cbs=new CommodityController();
	public CommodityItemData(int style,CommodityVO commodity,int num,double price,String note) {
		a=commodity;
		this.num.set(""+num);
		commodityid.set(""+commodity.getID());
		if(style==1){
		saleprice.set(""+price);
		totalprice.set(""+num*price);
		}else{
		importprice.set(""+price);
		totalprice.set(""+num*price);
		}
		model.set(commodity.getModel());
		name.set(commodity.getName());
		this.note.set(note);
		}
	public CommodityItemData(CommodityLineItem item) {
		a=cbs.findCommodityByID(item.getCommodityID());
		commodityid.set(""+item.getCommodityID());
		name.set(""+a.getName());
		model.set(""+a.getModel());
		saleprice.set(""+item.getSalePrice());
		importprice.set(""+item.getImportPrice());
		num.set(""+item.getNum());
		totalprice.set(""+item.getImportPrice()*item.getNum());
	}
	public StringProperty getId(){
		return commodityid;
	}
	public StringProperty getName(){
		return name;
	}
	public StringProperty getModel(){
		return model;
	}
	public StringProperty getNum(){
		return num;
	}
	public StringProperty getSalePrice(){
		return saleprice;
	}
	public StringProperty getImportPrice(){
		return importprice;
	}
	public StringProperty getImportTotalPrice(){
		double price=Double.parseDouble(importprice.get());
		int number=Integer.parseInt(num.get());
		return new SimpleStringProperty(price*number+"");
	}
	public StringProperty getSaleTotalPrice(){
		double price=Double.parseDouble(saleprice.get());
		int number=Integer.parseInt(num.get());
		return new SimpleStringProperty(price*number+"");
	}
	public StringProperty getNote(){
		return note;
	}
	public CommodityLineItem getItem() {
		CommodityLineItem item=new CommodityLineItem(Integer.parseInt(num.get()), a.getID(), Double.parseDouble(saleprice.get()), Double.parseDouble(importprice.get()),note.get());
		return item;
	}
	public void setNum(String text) {
		num.set(text);
	}
}
