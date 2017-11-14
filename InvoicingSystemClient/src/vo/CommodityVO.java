package vo;

public class CommodityVO {
	
	 String name;
	 int ID;
	 int stock_num;
	 double price;
	 int batch;//批次
	 int batch_num;
	 int  produce_time;
	 double averagePrice;
	 	
	public CommodityVO(String name, int ID, int stock_num, double price, int batch, int batch_num, int produce_time) {
		// TODO Auto-generated constructor stub
		this.ID=ID;
		this.stock_num=stock_num;
		this.batch=batch;
		this.batch_num=batch_num;
		this.name=name;
		this.price=price;
		this.produce_time=produce_time;
	}

	public CommodityVO() {
		// TODO 自动生成的构造函数存根
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getStockNum() {
		return stock_num;
	}
	
	public int getBatch() {
		return batch;
	}
	
	public int getBatchNum() {
		return batch_num;
	}
	
	
	public int getProduceTime() {
		return produce_time;
	}
}
