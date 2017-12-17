package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.PayBillBLService;
import po.PayBillPO;
import vo.PayBillVO;

public class PayBillController implements PayBillBLService{
	PayBill payBillImpl=new PayBill();
	@Override
	public PayBillVO toPayBillVO(PayBillPO po) {
		return payBillImpl.toPayBillVO(po);
	}

	@Override
	public boolean submitPayBill(PayBillVO payBill) {
		return payBillImpl.submitPayBill(payBill);
	}

	@Override
	public boolean checkPayBill(boolean pass, long id) {
		return payBillImpl.checkPayBill(pass, id);
	}

	@Override
	public boolean deletePayBill(PayBillVO payBill) {
		return payBillImpl.deletePayBill(payBill);
	}

	@Override
	public PayBillVO findPayBillByID(long id) {
		return payBillImpl.findPayBillByID(id);
	}

	@Override
	public ArrayList<PayBillVO> findPayBillByTime(Date time) {
		return payBillImpl.findPayBillByTime(time);
	}

	@Override
	public ArrayList<PayBillVO> findPayBills() {
		return payBillImpl.findPayBills();
	}

	@Override
	public ArrayList<PayBillVO> findPayBillsByInterval(Date begin, Date end) {
		return payBillImpl.findPayBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<PayBillVO> findPayBillsByField(Date begin, Date end, String memberName, String userName) {
		return payBillImpl.findPayBillsByField(begin, end, memberName, userName);
	}

	@Override
	public ArrayList<PayBillVO> findPayBillsByState(int state) {
		// TODO 自动生成的方法存根
		return null;
	}

}
