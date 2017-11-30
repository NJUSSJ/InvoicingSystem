package businesslogicservice.billblservice;

import po.SaleBillPO;
import vo.SaleBillVO;

public interface SaleBillBLService {
	public SaleBillVO toSaleBillVO(SaleBillPO po);
	public String conveyBill(SaleBillVO salebill);
	public SaleBillVO checkBill(SaleBillVO salebill);
}
