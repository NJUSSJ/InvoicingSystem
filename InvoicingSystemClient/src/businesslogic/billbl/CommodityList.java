package businesslogic.billbl;

import java.util.ArrayList;

public class CommodityList {
	ArrayList<CommodityLineItem> list;
	
	public CommodityList() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCommodity(CommodityLineItem item) {
		list.add(item);
	}
	
	public void deleteCommodity(CommodityLineItem item) {
		list.remove(item);
	}
	
	public int getTotal() {
		int total=0;
		for(int i=0;i<list.size();i++) {
			total+=list.get(i).num*list.get(i).price;
		}
		return total;
	}
}
