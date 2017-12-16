package businesslogic.billbl;

import vo.CommodityVO;

public class CommodityLineItem {
	int num;
	long commodityid;
	double salePrice;
	double importPrice;
	
	public CommodityLineItem(int num,long commodityid,double salePrice,double importPrice) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.commodityid=commodityid;
		this.salePrice=salePrice;
		this.importPrice=importPrice;
	}
	public int getNum(){
		return num;
	}
	
	public long getCommodityID() {
		return commodityid;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public double getImportPrice(){
		return importPrice;
	}
	
}