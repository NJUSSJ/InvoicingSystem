package businesslogic.billbl;

public class CommodityLineItem {
	int num;
	long commodityid;
	double salePrice;
	double importPrice;
	String remark;
	
	public CommodityLineItem(int num,long commodityid,double salePrice,double importPrice,String remark) {
		this.num=num;
		this.commodityid=commodityid;
		this.salePrice=salePrice;
		this.importPrice=importPrice;
		this.remark=remark;
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
	public String getRemark(){
		return remark;
	}
	public void setNum(int num){
		this.num=num;
	}
	public void setSalePrice(double price) {
		salePrice=price;
	}
	public void setImportPrice(double price){
		importPrice=price;
	}
}