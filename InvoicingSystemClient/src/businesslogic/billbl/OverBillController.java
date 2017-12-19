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
		return overBillImpl.toOverBillVO(overBillPO);
	}

	@Override
	public boolean submitOverBill(OverBillVO overBill) {
		return overBillImpl.submitOverBill(overBill);
	}

	@Override
	public boolean checkOverBill(boolean pass, long id) {
		return overBillImpl.checkOverBill(pass, id);
	}

	@Override
	public boolean deleteOverBill(OverBillVO overBill) {
		return overBillImpl.deleteOverBill(overBill);
	}

	@Override
	public OverBillVO findOverBillByID(long id) {
		return overBillImpl.findOverBillByID(id);
	}

	@Override
	public ArrayList<OverBillVO> findOverBillByTime(Date time) {
		return overBillImpl.findOverBillByTime(time);
	}

	@Override
	public ArrayList<OverBillVO> findOverBills() {
		return overBillImpl.findOverBills();
	}

	@Override
	public ArrayList<OverBillVO> findOverBillsByInterval(Date begin, Date end) {
		return overBillImpl.findOverBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<OverBillVO> findOverBillsByField(Date begin, Date end, String userName) {
		return overBillImpl.findOverBillsByField(begin, end, userName);
	}

	@Override
	public ArrayList<OverBillVO> findOverBillsByState(int state) {
		return overBillImpl.findOverBillsByState(state);
	}

	@Override
	public ArrayList<OverBillVO> findOverBillsByUser(long id) {
		return overBillImpl.findOverBillsByUser(id);
	}

}
