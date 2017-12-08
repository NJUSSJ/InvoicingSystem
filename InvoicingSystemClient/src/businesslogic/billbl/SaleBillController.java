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
		// TODO 自动生成的方法存根
		return saleBillImpl.toSaleBillVO(po);
	}

	@Override
	public boolean submitSaleBill(SaleBillVO saleBill) {
		// TODO 自动生成的方法存根
		return saleBillImpl.submitSaleBill(saleBill);
	}

	@Override
	public boolean checkSaleBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return saleBillImpl.checkSaleBill(pass, id);
	}

	@Override
	public boolean deleteSaleBill(SaleBillVO saleBill) {
		// TODO 自动生成的方法存根
		return saleBillImpl.deleteSaleBill(saleBill);
	}

	@Override
	public SaleBillVO findSaleBillByID(long id) {
		// TODO 自动生成的方法存根
		return saleBillImpl.findSaleBillByID(id);
	}

	@Override
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return saleBillImpl.findSaleBillByTime(time);
	}

	@Override
	public ArrayList<SaleBillVO> findSaleBills() {
		// TODO 自动生成的方法存根
		return null;
	}

}
