package vo;

import java.sql.Time;
import java.util.ArrayList;


public class SaleDetailsTableVO {
	Time t;
	ArrayList<CommodityVO> commoditylist=new ArrayList<CommodityVO>();
	double total_num;
	
	public SaleDetailsTableVO(Time t,ArrayList<CommodityVO> commoditylist,double total_num) {
		this.t=t;
		this.commoditylist=commoditylist;
		this.total_num=total_num;
	}
	public SaleDetailsTableVO() {
		// TODO Auto-generated constructor stub
	}
}

