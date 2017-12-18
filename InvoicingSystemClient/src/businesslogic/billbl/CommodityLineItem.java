package businesslogic.billbl;

public class CommodityLineItem {
	int num;
	long commodityid;
	double salePrice;
	double importPrice;
	
	public CommodityLineItem(int num,long commodityid,double salePrice,double importPrice) {
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
	public void setSalePrice(double price) {
		salePrice=price;
	}
	public void setImportPrice(double price){
		importPrice=price;
	}
}