package vo;

import java.sql.Time;

public class CommodityVO {
	String name;
	int ID;
	int stock_num;
	int price;
	int batch;//����
	int batch_num;
	Time produce_time;
	
	public CommodityVO(String name,
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

	public CommodityVO() {
		// TODO �Զ����ɵĹ��캯�����
	}
}