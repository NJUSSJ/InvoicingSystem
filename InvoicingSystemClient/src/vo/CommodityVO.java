package vo;

import po.CommodityPO;

public class CommodityVO {
	 String name;
	 long id;
	 String model;
	 int stockNum;
	 double importPrice;
	 double salePrice;
	 double lateImportPrice;
	 double lateSalePrice;
	 long parentid;
	 int limit;
	 	
	public CommodityVO(String name,long id,String model, int stockNum, double importPrice, double salePrice,
			double lateImportPrice, double lateSalePrice,long parentid,int limit) {
		this.name=name;
		this.id=id;
		this.model=model;
		this.stockNum=stockNum;
		this.importPrice=importPrice;
		this.salePrice=salePrice;
		this.lateImportPrice=lateImportPrice;
		this.lateSalePrice=lateSalePrice;
		this.parentid=parentid;
		this.limit=limit;
	}
	public CommodityPO toCommodityPO(){
		return new CommodityPO(name,id,model,stockNum,importPrice,salePrice,lateImportPrice,
				lateSalePrice,parentid,limit);
	}
	
	public String getName() {
		return name;
	}
	public long getID() {
		return id;
	}
	public String getModel(){
		return model;
	}
	public int getStockNum() {
		return stockNum;
	}
	public double getSalePrice(){
		return salePrice;
	}
	public double getImportPrice(){
		return importPrice;
	}
	public double getLateSalePrice(){
		return lateSalePrice;
	}
	public double getLateImportPrice(){
		return lateImportPrice;
	}
	public long getParent(){
		return parentid;
	}
	public int getLimit(){
		return limit;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setModel(String model){
		this.model=model;
	}
	public void setStockNum(int stockNum){
		this.stockNum=stockNum;
	}
	public void setImportPrice(double importPrice){
		this.importPrice=importPrice;
	}
	public void setSalePrice(double salePrice){
		this.salePrice=salePrice;
	}
	public void setLateImportPrice(double lateImportPrice){
		this.lateImportPrice=lateImportPrice;
	}
	public void setLateSalePrice(double lateSalePrice){
		this.lateSalePrice=lateSalePrice;
	}
	public void setParentID(long parentid){
		this.parentid=parentid;
	}
	public void setLimit(int limit){
		this.limit=limit;
	}
}
