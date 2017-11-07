package businesslogic.billbl;

import java.sql.Time;

import vo.CommodityVO;

public class MockCommodityVO extends CommodityVO {
	
	 String name;
	 int ID;
	 int stock_num;
	 double price;
	 int batch;//批次
	 int batch_num;
	 Time produce_time;
	
	public MockCommodityVO(String name,
	int ID,
	int stock_num,
	int price,
	int batch,
	int batch_num,
	Time produce_time) {
		// TODO Auto-generated constructor stub
		this.ID=ID;
		this.stock_num=stock_num;
		this.batch=batch;
		this.batch_num=batch_num;
		this.name=name;
		this.price=price;
		this.produce_time=produce_time;
	}
	


	public MockCommodityVO(int price) {
		// TODO 自动生成的构造函数存根
		this.price=price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
