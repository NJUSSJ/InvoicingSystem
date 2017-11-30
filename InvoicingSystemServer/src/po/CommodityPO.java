package po;

import java.io.Serializable;

public class CommodityPO implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	long id;
	String model;
	int stockNum;
	double importPrice;
	double salePrice;
	double lateImportPrice;
	double lateSalePrice;
	long parentid;
	 	
	public CommodityPO(String name,long id,String model, int stockNum, double importPrice, double salePrice,
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
	
	public String getName() {
		return name;
	}
	public long getID() {
		return id;
	}
	public String getModel(){
		return model;
	}
	public int getStockNum(){
		return stockNum;
	}
	public double getImportPrice(){
		return importPrice;
	}
	public double getSalePrice(){
		return salePrice;
	}
	public double getLateImportPrice(){
		return lateImportPrice;
	}
	public double getLateSalePrice(){
		return lateSalePrice;
	}
	public long getParentID(){
		return parentid;
	}
}

