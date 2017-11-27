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
	long userid;
	CommodityList commoditys;
	int time;
	public LossBillVO(long id,long userid,CommodityList list, int time) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commoditys=list;
		this.userid=userid;
		this.time=time;
	}
}
