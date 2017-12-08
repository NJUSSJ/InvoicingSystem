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
		// TODO 自动生成的方法存根
		return warningBillController.toWarningBillVO(po);
	}

	@Override
	public boolean submitWarningBill(WarningBillVO warningBill) {
		// TODO 自动生成的方法存根
		return warningBillController.submitWarningBill(warningBill);
	}

	@Override
	public boolean checkWarningBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return warningBillController.checkWarningBill(pass, id);
	}

	@Override
	public boolean deleteWarningBill(WarningBillVO warningBill) {
		// TODO 自动生成的方法存根
		return warningBillController.deleteWarningBill(warningBill);
	}

	@Override
	public WarningBillVO findWarningBillByID(long id) {
		// TODO 自动生成的方法存根
		return warningBillController.findWarningBillByID(id);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return warningBillController.findWarningBillByTime(time);
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBills() {
		// TODO 自动生成的方法存根
		return null;
	}

}
