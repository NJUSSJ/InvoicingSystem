 package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.SaleBillBLService;
import po.SaleBillPO;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;

public class SaleBill implements SaleBillBLService {

	@Override
	public SaleBillVO toSaleBillVO(SaleBillPO po) {
		// TODO �Զ����ɵķ������
		CommodityList commodityList=new CommodityList();
		String[] tempInfo=po.getCommodityList().split(" ");
		for(int i=0;i<tempInfo.length;i++){
			String[] temp=tempInfo[i].split(",");
		}
		return null;
	}

	@Override
	public String conveyBill(SaleBillVO salebill) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SaleBillVO checkBill(SaleBillVO salebill) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
