package presentation.saleui;

import businesslogic.billbl.CommodityLineItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CommodityVO;

public class CommodityItemData {
	StringProperty num=new SimpleStringProperty();
	StringProperty commodityid=new SimpleStringProperty();
	StringProperty saleprice=new SimpleStringProperty();
	StringProperty importprice=new SimpleStringProperty();
	StringProperty model=new SimpleStringProperty();
	StringProperty totalprice=new SimpleStringProperty();
	StringProperty note=new SimpleStringProperty();
	StringProperty name=new SimpleStringProperty();
	CommodityVO a;
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
		CommodityLineItem item=new CommodityLineItem(Integer.parseInt(num.get()),a.getID(),a.getSalePrice(),a.getImportPrice());
		return item;
	}
}
