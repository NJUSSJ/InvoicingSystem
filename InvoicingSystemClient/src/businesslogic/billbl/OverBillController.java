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
		// TODO 自动生成的方法存根
		return overBillImpl.toOverBillVO(overBillPO);
	}

	@Override
	public boolean submitOverBill(OverBillVO overBill) {
		// TODO 自动生成的方法存根
		return overBillImpl.submitOverBill(overBill);
	}

	@Override
	public boolean checkOverBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return overBillImpl.checkOverBill(pass, id);
	}

	@Override
	public boolean deleteOverBill(OverBillVO overBill) {
		// TODO 自动生成的方法存根
		return overBillImpl.deleteOverBill(overBill);
	}

	@Override
	public OverBillVO findOverBillByID(long id) {
		// TODO 自动生成的方法存根
		return overBillImpl.findOverBillByID(id);
	}

	@Override
	public ArrayList<OverBillVO> findOverBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return overBillImpl.findOverBillByTime(time);
	}

	@Override
	public ArrayList<OverBillVO> findOverBills() {
		// TODO 自动生成的方法存根
		return null;
	}

}
