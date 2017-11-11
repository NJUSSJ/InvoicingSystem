package businesslogic.billbl;

import java.sql.Time;

import vo.CommodityVO;

public class CommodityLineItem {
	double num;
	String name;
	double price;
	double stock_num;
	 int batch;//批次
	 int batch_num;
	 Time produce_time;
	 double averagePrice;
	public CommodityLineItem(CommodityVO commodity,int num) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.name=commodity.getName();
		this.price=commodity.getPrice();
		this.stock_num=commodity.getStockNum();
		this.batch=commodity.getBatch();
		this.batch_num=commodity.getBatchNum();
		this.produce_time=commodity.getProduceTime();
		this.averagePrice=commodity.getAveragePrice();
	}
	
	public String getCommodity() {
		return name;
	}
	
	public double getPrice() {
		return num;
	}
}
