package vo;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import po.LossBillPO;

/**
 * 
 * @author yrz
 * ��汨��
 *
 */
public class LossBillVO {
	long id;
	long userid;
	CommodityList commodityList;
	Date time;
	int state;
	public LossBillVO(long id,long userid,CommodityList commodityList, Date time,int state) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.commodityList=commodityList;
		this.userid=userid;
		this.time=time;
	}
	public LossBillPO toLossBillPO(){
		return new LossBillPO(id,userid,commodityList.toString(),time);
	}
	public void setState(int state){
		this.state=state;
	}
}
