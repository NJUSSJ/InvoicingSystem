package businesslogic.commoditybl;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import vo.SaleBillVO;

public class MockSaleBillVO extends SaleBillVO {
	public MockSaleBillVO(String id, long userid, long memberid, CommodityList list, double sum, int state, Date time,
			String remark) {
		super(id, userid, memberid, list, sum, state, time, remark);
		// TODO �Զ����ɵĹ��캯�����
	}

	CommodityList commodityList;
}
