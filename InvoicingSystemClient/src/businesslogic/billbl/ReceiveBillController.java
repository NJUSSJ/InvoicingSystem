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
		return receiveBillImpl.toReceiveBillVO(po);
	}

	@Override
	public boolean submitReceiveBill(ReceiveBillVO receiveBill) {
		return receiveBillImpl.submitReceiveBill(receiveBill);
	}

	@Override
	public boolean checkReceiveBill(boolean pass, long id) {
		return receiveBillImpl.checkReceiveBill(pass, id);
	}

	@Override
	public boolean deleteReceiveBill(ReceiveBillVO payBill) {
		return receiveBillImpl.deleteReceiveBill(payBill);
	}

	@Override
	public ReceiveBillVO findReceiveBillByID(long id) {
		return receiveBillImpl.findReceiveBillByID(id);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBillByTime(Date time) {
		return receiveBillImpl.findReceiveBillByTime(time);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBills() {
		return receiveBillImpl.findReceiveBills();
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBillsByInterval(Date begin, Date end) {
		return receiveBillImpl.findReceiveBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBillsByState(int state) {
		return receiveBillImpl.findReceiveBillsByState(state);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBillsByField(Date begin, Date end, String memberName, String userName) {
		return receiveBillImpl.findReceiveBillsByField(begin, end, memberName, userName);
	}

	@Override
	public ArrayList<ReceiveBillVO> findReceiveBillsByUser(long userid) {
		return receiveBillImpl.findReceiveBillsByUser(userid);
	}

}
