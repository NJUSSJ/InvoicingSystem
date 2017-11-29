package po;

import java.io.Serializable;
import java.sql.Date;

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
	 String parent;
	 	
	 public CommodityPO(String name,long id,String model, int stockNum, double importPrice, double salePrice,
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
}

