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
		// TODO 自动生成的方法存根
		return payBillImpl.toPayBillVO(po);
	}

	@Override
	public boolean submitPayBill(PayBillVO payBill) {
		// TODO 自动生成的方法存根
		return payBillImpl.submitPayBill(payBill);
	}

	@Override
	public boolean checkPayBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return payBillImpl.checkPayBill(pass, id);
	}

	@Override
	public boolean deletePayBill(PayBillVO payBill) {
		// TODO 自动生成的方法存根
		return payBillImpl.deletePayBill(payBill);
	}

	@Override
	public PayBillVO findPayBillByID(long id) {
		// TODO 自动生成的方法存根
		return payBillImpl.findPayBillByID(id);
	}

	@Override
	public ArrayList<PayBillVO> findPayBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return payBillImpl.findPayBillByTime(time);
	}

	@Override
	public ArrayList<PayBillVO> findPayBills() {
		// TODO 自动生成的方法存根
		return payBillImpl.findPayBills();
	}

}
