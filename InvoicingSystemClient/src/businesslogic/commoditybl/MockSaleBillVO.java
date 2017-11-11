package businesslogic.commoditybl;

import businesslogic.billbl.CommodityList;
import vo.SaleBillVO;

public class MockSaleBillVO extends SaleBillVO {
	CommodityList commodityList;
	public MockSaleBillVO(CommodityList list) {
		// TODO Auto-generated constructor stub
		this.commodityList=list;
	}
	
	public int getnum(){
		return commodityList.getNum();
	}
}
