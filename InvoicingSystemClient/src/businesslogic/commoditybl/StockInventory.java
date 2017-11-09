package businesslogic.commoditybl;

import businesslogic.billbl.CommodityList;

public class StockInventory {
	CommodityList cl;
	int time;
	
	public StockInventory(){
		//读入当天时间
	}
	
	public CommodityList getList(int time){
		return cl;
	}
	
	
}
