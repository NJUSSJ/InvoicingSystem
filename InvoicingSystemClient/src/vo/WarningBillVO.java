package vo;
/**
 * 
 * @author yrz
 * ��汨����
 *
 */

import businesslogic.billbl.CommodityList;

public class WarningBillVO {
	long id;
	long userid;
	CommodityList list;
	int time;
	
	public WarningBillVO(long id,long userid,CommodityList list,int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userid=userid;
		this.list=list;
		this.time=time;
	}
}
