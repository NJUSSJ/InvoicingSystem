package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.SaleBillBLService;
import po.SaleBillPO;
import vo.SaleBillVO;

public class SaleBillController implements SaleBillBLService{
	SaleBill saleBillImpl=new SaleBill();
	@Override
	public SaleBillVO toSaleBillVO(SaleBillPO po) {
		// TODO �Զ����ɵķ������
		return saleBillImpl.toSaleBillVO(po);
	}

	@Override
	public boolean submitSaleBill(SaleBillVO saleBill) {
		// TODO �Զ����ɵķ������
		return saleBillImpl.submitSaleBill(saleBill);
	}

	@Override
	public boolean checkSaleBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return saleBillImpl.checkSaleBill(pass, id);
	}

	@Override
	public boolean deleteSaleBill(SaleBillVO saleBill) {
		// TODO �Զ����ɵķ������
		return saleBillImpl.deleteSaleBill(saleBill);
	}

	@Override
	public SaleBillVO findSaleBillByID(long id) {
		// TODO �Զ����ɵķ������
		return saleBillImpl.findSaleBillByID(id);
	}

	@Override
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return saleBillImpl.findSaleBillByTime(time);
	}

	@Override
	public ArrayList<SaleBillVO> findSaleBills() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
