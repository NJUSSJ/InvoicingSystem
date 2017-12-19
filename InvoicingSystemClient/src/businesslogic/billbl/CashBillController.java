package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.CashBillBLService;
import po.CashBillPO;
import vo.CashBillVO;

public class CashBillController implements CashBillBLService{
	CashBill cashBillImpl=new CashBill();
	@Override
	public CashBillVO toCashBillVO(CashBillPO po) {
		return cashBillImpl.toCashBillVO(po);
	}

	@Override
	public boolean submitCashBill(CashBillVO cashBill) {
		return cashBillImpl.submitCashBill(cashBill);
	}

	@Override
	public boolean checkCashBill(boolean pass,long id) {
		return cashBillImpl.checkCashBill(pass, id);
	}

	@Override
	public boolean deleteCashBill(CashBillVO cashBill) {
		return cashBillImpl.deleteCashBill(cashBill);
	}

	@Override
	public ArrayList<CashBillVO> findCashBills() {
		return cashBillImpl.findCashBills();
	}

	@Override
	public ArrayList<CashBillVO> findCashBillByTime(Date time) {
		return cashBillImpl.findCashBillByTime(time);
	}

	@Override
	public ArrayList<CashBillVO> findCashBillsByInterval(Date begin, Date end) {
		return cashBillImpl.findCashBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<CashBillVO> findCashBillsByField(Date begin, Date end,String userName) {
		return cashBillImpl.findCashBillsByField(begin, end, userName);
	}

	@Override
	public ArrayList<CashBillVO> findCashBillsByState(int state) {
		return cashBillImpl.findCashBillsByState(state);
	}

	@Override
	public ArrayList<CashBillVO> findCashBillsByUser(long userid) {
		return cashBillImpl.findCashBillsByUser(userid);
	}
	

}
