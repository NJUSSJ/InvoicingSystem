package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.OverBillBLService;
import po.OverBillPO;
import vo.OverBillVO;

public class OverBillController implements OverBillBLService{
	OverBill overBillImpl=new OverBill();
	@Override
	public OverBillVO toOverBillVO(OverBillPO overBillPO) {
		// TODO �Զ����ɵķ������
		return overBillImpl.toOverBillVO(overBillPO);
	}

	@Override
	public boolean submitOverBill(OverBillVO overBill) {
		// TODO �Զ����ɵķ������
		return overBillImpl.submitOverBill(overBill);
	}

	@Override
	public boolean checkOverBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return overBillImpl.checkOverBill(pass, id);
	}

	@Override
	public boolean deleteOverBill(OverBillVO overBill) {
		// TODO �Զ����ɵķ������
		return overBillImpl.deleteOverBill(overBill);
	}

	@Override
	public OverBillVO findOverBillByID(long id) {
		// TODO �Զ����ɵķ������
		return overBillImpl.findOverBillByID(id);
	}

	@Override
	public ArrayList<OverBillVO> findOverBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return overBillImpl.findOverBillByTime(time);
	}

	@Override
	public ArrayList<OverBillVO> findOverBills() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
