package businesslogic.commoditybl;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import vo.SaleBillVO;

public class MockSaleBillVO extends SaleBillVO {
	public MockSaleBillVO(String id, long userid, long memberid, CommodityList list, double sum, int state, Date time,
			String remark) {
		super(id, userid, memberid, list, sum, state, time, remark);
		// TODO 自动生成的构造函数存根
	}

	CommodityList commodityList;
}
