package businesslogic.billbl;

import vo.CommodityVO;

public class CommodityLineItem {
	double num;
	String name;
	double price;
	public CommodityLineItem(CommodityVO commodity,int num) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.name=commodity.getName();
		this.price=commodity.getPrice();
	}
	
	public String getCommodity() {
		return name;
	}
	
	public double getPrice() {
		return num;
	}
}
