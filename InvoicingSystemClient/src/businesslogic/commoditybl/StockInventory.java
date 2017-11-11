package businesslogic.commoditybl;

import businesslogic.billbl.CommodityList;

public class StockInventory {
	CommodityList cl;
	int time;
	
	public StockInventory(){
		//
	}
	
	public CommodityList getList(int time){
		return cl;
	}
	
	
}
