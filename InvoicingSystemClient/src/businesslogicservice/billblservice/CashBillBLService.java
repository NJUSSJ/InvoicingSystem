package businesslogicservice.billblservice;

import vo.BillVO;

public interface CashBillBLService extends BillBLService{
	public BillVO makeCashbill(BillVO bill);
}
