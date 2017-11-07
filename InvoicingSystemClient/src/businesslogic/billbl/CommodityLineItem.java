package businesslogic.billbl;

import vo.CommodityVO;

public class CommodityLineItem {
	int num;
	String name;
	double price;
	public CommodityLineItem(CommodityVO commodity,int num) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.name=commodity.getName();
		this.price=commodity.getPrice();
	}
}
