package vo;

import businesslogic.billbl.CommodityList;

/**
 * 
 * @author yrz
 * ¿â´æ±¨Ëðµ¥
 *
 */
public class LossBillVO {
	long id;
	String user;
	CommodityList commoditys;
	int time;
	public LossBillVO(long id,String user,CommodityList list, int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commoditys=list;
		this.user=user;
	}
}
