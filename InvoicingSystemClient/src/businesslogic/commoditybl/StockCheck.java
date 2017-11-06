package businesslogic.commoditybl;

import vo.CommodityVO;

public class StockCheck {
	int start_time;
	int end_time;
	CommodityVO commodity;
	
	public StockCheck(int start,int end,CommodityVO c) {
		start_time=start;
		end_time=end;
		commodity=c;
	}
	
	public int getInNum(int start,int end,CommodityVO c) {
		
		return 0;
	}
	
	public int getOutNum(int satrt,int end,CommodityVO c) {
		return 0;
	}
	
}
