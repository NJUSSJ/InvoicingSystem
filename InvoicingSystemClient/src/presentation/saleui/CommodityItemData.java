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
		// TODO Auto-generated constructor stub
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
		
		
		// TODO Auto-generated constructor stub
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
	public StringProperty getTotalPrice(){
		return totalprice;
	}
	public StringProperty getNote(){
		return note;
	}
	public CommodityLineItem getItem() {
		// TODO Auto-generated method stub
		CommodityLineItem item=new CommodityLineItem(Integer.parseInt(num.get()), a.getID(), Double.parseDouble(saleprice.get()), Double.parseDouble(importprice.get()),note.get());
		return item;
	}
	public void setNum(String text) {
		// TODO Auto-generated method stub
		num.set(text);
	}
}
