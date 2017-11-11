package businesslogic.billbl;

import java.sql.Time;

import vo.CommodityVO;

public class CommodityLineItem {
	int num;
	String name;
	double price;
	double stock_num;
	 int batch;//Åú´Î
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
}