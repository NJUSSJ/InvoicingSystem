package businesslogic.tablebl;

import java.sql.Time;
import java.util.ArrayList;

import vo.CommodityVO;


public class MockSaleDetailsTableVO {
	Time t;
	ArrayList<CommodityVO> commoditylist=new ArrayList<CommodityVO>();
	double total_num;
	
	public MockSaleDetailsTableVO(Time t,ArrayList<CommodityVO> commoditylist,double total_num) {
		this.t=t;
		this.commoditylist=commoditylist;
		this.total_num=total_num;
	}
	public MockSaleDetailsTableVO() {
		// TODO Auto-generated constructor stub
	}
}

