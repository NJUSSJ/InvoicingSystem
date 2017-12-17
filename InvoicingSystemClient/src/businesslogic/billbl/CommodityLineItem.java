package businesslogic.billbl;

import vo.CommodityVO;

public class CommodityLineItem {
	int num;
	long commodityid;
	double salePrice;
	double importPrice;
	
	public CommodityLineItem(CommodityVO commodity,int num) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.commodityid=commodity.getID();
		this.salePrice=commodity.getSalePrice();
		this.importPrice=commodity.getImportPrice();
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
	public void setSalePrice(double price) {
		salePrice=price;
	}
	public void setImportPrice(double price){
		importPrice=price;
	}
}