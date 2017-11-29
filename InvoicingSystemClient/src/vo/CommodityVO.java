package vo;

import java.sql.Date;

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
	 String parent;
	 	
	public CommodityVO(String name,long id,String model, int stockNum, double importPrice, double salePrice,
			double lateImportPrice, double lateSalePrice,String parent) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.id=id;
		this.model=model;
		this.stockNum=stockNum;
		this.importPrice=importPrice;
		this.salePrice=salePrice;
		this.lateImportPrice=lateImportPrice;
		this.lateSalePrice=lateSalePrice;
	}
	public CommodityPO toCommodityPO(){
		return new CommodityPO(name,id,model,stockNum,importPrice,salePrice,lateImportPrice,lateSalePrice,parent);
	}
	
	public String getName() {
		return name;
	}
	public long getID() {
		return id;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setStockNum(int stockNum){
		this.stockNum=stockNum;
	}
	public double getSalePrice(){
		return salePrice;
	}
	public double getImportPrice(){
		return importPrice;
	}
	
}
