package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.WarningBillBLService;
import po.WarningBillPO;
import vo.PayBillVO;
import vo.WarningBillVO;

public class WarningBillController implements WarningBillBLService{
	WarningBill warningBillImpl=new WarningBill();
	@Override
	public WarningBillVO toWarningBillVO(WarningBillPO po) {
		return warningBillImpl.toWarningBillVO(po);
	}

	@Override
	public boolean submitWarningBill(WarningBillVO warningBill) {
		return warningBillImpl.submitWarningBill(warningBill);
	}

	@Override
	public boolean checkWarningBill(boolean pass, long id) {
		return warningBillImpl.checkWarningBill(pass, id);
	}

	@Override
	public boolean deleteWarningBill(WarningBillVO warningBill) {
		return warningBillImpl.deleteWarningBill(warningBill);
	}

	@Override
	public WarningBillVO findWarningBillByID(long id) {
		return warningBillImpl.findWarningBillByID(id);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillByTime(Date time) {
		return warningBillImpl.findWarningBillByTime(time);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBills() {
		return warningBillImpl.findWarningBills();
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillsByState(int state) {
		return warningBillImpl.findWarningBillsByState(state);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillsByUser(long userid) {
		return warningBillImpl.findWarningBillsByUser(userid);
	}

}
