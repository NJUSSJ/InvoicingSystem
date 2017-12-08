package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.ReceiveBillBLService;
import po.ReceiveBillPO;
import vo.ReceiveBillVO;

public class ReceiveBillController implements ReceiveBillBLService{
	ReceiveBill receiveBillImpl=new ReceiveBill();
	@Override
	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po) {
		// TODO �Զ����ɵķ������
		return receiveBillImpl.toReceiveBillVO(po);
	}

	@Override
	public boolean submitReceiveBill(ReceiveBillVO receiveBill) {
		// TODO �Զ����ɵķ������
		return receiveBillImpl.submitReceiveBill(receiveBill);
	}

	@Override
	public boolean checkReceiveBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return receiveBillImpl.checkReceiveBill(pass, id);
	}

	@Override
	public boolean deleteReceiveBill(ReceiveBillVO payBill) {
		// TODO �Զ����ɵķ������
		return receiveBillImpl.deleteReceiveBill(payBill);
	}

	@Override
	public ReceiveBillVO findReceiveBillByID(long id) {
		// TODO �Զ����ɵķ������
		return receiveBillImpl.findReceiveBillByID(id);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return receiveBillImpl.findReceiveBillByTime(time);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBills() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
