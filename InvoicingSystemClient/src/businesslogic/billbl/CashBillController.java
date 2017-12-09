package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.CashBillBLService;
import po.CashBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;

public class CashBillController implements CashBillBLService{
	CashBill cashBillImpl=new CashBill();
	@Override
	public CashBillVO toCashBillVO(CashBillPO po) {
		return cashBillImpl.toCashBillVO(po);
	}

	@Override
	public boolean submitCashBill(CashBillVO cashBill) {
		// TODO �Զ����ɵķ������
		return cashBillImpl.submitCashBill(cashBill);
	}

	@Override
	public boolean checkCashBill(boolean pass,long id) {
		// TODO �Զ����ɵķ������
		return cashBillImpl.checkCashBill(pass, id);
	}

	@Override
	public boolean deleteCashBill(CashBillVO cashBill) {
		// TODO �Զ����ɵķ������
		return cashBillImpl.deleteCashBill(cashBill);
	}

	@Override
	public ArrayList<CashBillVO> findCashBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return cashBillImpl.findCashBillByTime(time);
	}

	@Override
	public ArrayList<CashBillVO> findCashBills() {
		// TODO �Զ����ɵķ������
		return cashBillImpl.findCashBills();
	}
	

}
