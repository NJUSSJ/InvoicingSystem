package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.WarningBillBLService;
import po.WarningBillPO;
import vo.PayBillVO;
import vo.WarningBillVO;

public class WarningBillController implements WarningBillBLService{
	WarningBill warningBillController=new WarningBill();
	@Override
	public WarningBillVO toWarningBillVO(WarningBillPO po) {
		return warningBillController.toWarningBillVO(po);
	}

	@Override
	public boolean submitWarningBill(WarningBillVO warningBill) {
		return warningBillController.submitWarningBill(warningBill);
	}

	@Override
	public boolean checkWarningBill(boolean pass, long id) {
		return warningBillController.checkWarningBill(pass, id);
	}

	@Override
	public boolean deleteWarningBill(WarningBillVO warningBill) {
		return warningBillController.deleteWarningBill(warningBill);
	}

	@Override
	public WarningBillVO findWarningBillByID(long id) {
		return warningBillController.findWarningBillByID(id);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillByTime(Date time) {
		return warningBillController.findWarningBillByTime(time);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBills() {
		return null;
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillsByState(int state) {
		return null;
	}

}
