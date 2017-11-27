package vo;

import java.sql.Date;

public class CommodityVO {
	
	 String name;
	 long id;
	 int stockNum;
	 double price;
	 int batch;//����
	 int batchNum;
	 Date  produce_time;
	 double averagePrice;
	 	
	public CommodityVO(String name, int id, int stock_num, double price, int batch, int batch_num, Date produce_time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.stockNum=stock_num;
		this.batch=batch;
		this.batchNum=batch_num;
		this.name=name;
		this.price=price;
		this.produce_time=produce_time;
	}

	public CommodityVO() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public long getID() {
		return id;
	}
	
	public int getStockNum() {
		return stockNum;
	}
	
	public int getBatch() {
		return batch;
	}
	
	public int getBatchNum() {
		return batchNum;
	}
	
	
	public Date getProduceTime() {
		return produce_time;
	}
}
