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
		return saleBillImpl.toSaleBillVO(po);
	}

	@Override
	public boolean submitSaleBill(SaleBillVO saleBill) {
		return saleBillImpl.submitSaleBill(saleBill);
	}

	@Override
	public boolean checkSaleBill(boolean pass, long id) {
		return saleBillImpl.checkSaleBill(pass, id);
	}

	@Override
	public boolean deleteSaleBill(SaleBillVO saleBill) {
		return saleBillImpl.deleteSaleBill(saleBill);
	}

	@Override
	public SaleBillVO findSaleBillByID(long id) {
		return saleBillImpl.findSaleBillByID(id);
	}

	@Override
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time) {
		return saleBillImpl.findSaleBillByTime(time);
	}

	@Override
	public ArrayList<SaleBillVO> findSaleBills() {
		return saleBillImpl.findSaleBills();
	}

	@Override
	public double handleSale(int rank, CommodityList list) {
		return saleBillImpl.handleSale(rank,list);
	}

	@Override
	public int handleCoupon(int rank, double sum) {
		return saleBillImpl.handleCoupon(rank, sum);
	}
	
	

}
