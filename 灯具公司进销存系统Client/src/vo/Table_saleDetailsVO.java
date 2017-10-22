package vo;

import java.sql.Time;
import java.util.ArrayList;


public class Table_saleDetailsVO {
	Time t;
	ArrayList<CommodityVO> commoditylist=new ArrayList<CommodityVO>();
	double total_num;
	
	public Table_saleDetailsVO(Time t,ArrayList<CommodityVO> commoditylist,double total_num) {
		this.t=t;
		this.commoditylist=commoditylist;
		this.total_num=total_num;
	}
}

