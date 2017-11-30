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
	 	
	public CommodityVO(String name,long id,String model, int stockNum, double importPrice, double salePrice,
			double lateImportPrice, double lateSalePrice,long parentid) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.id=id;
		this.model=model;
		this.stockNum=stockNum;
		this.importPrice=importPrice;
		this.salePrice=salePrice;
		this.lateImportPrice=lateImportPrice;
		this.lateSalePrice=lateSalePrice;
		this.parentid=parentid;
	}
	public CommodityPO toCommodityPO(){
		return new CommodityPO(name,id,model,stockNum,importPrice,
				salePrice,lateImportPrice,lateSalePrice,parentid);
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
	public void setName(String name){
		this.name=name;
	}
	public void setStockNum(int stockNum){
		this.stockNum=stockNum;
	}
}
