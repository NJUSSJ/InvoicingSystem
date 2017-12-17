package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.SaleReturnBillBLService;
import po.SaleReturnBillPO;
import vo.SaleReturnBillVO;

public class SaleReturnBillController implements SaleReturnBillBLService{
	SaleReturnBill saleReturnBillImpl=new SaleReturnBill();
	@Override
	public SaleReturnBillVO toSaleReturnBillVO(SaleReturnBillPO po) {
		return saleReturnBillImpl.toSaleReturnBillVO(po);
	}

	@Override
	public boolean submitSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		return saleReturnBillImpl.submitSaleReturnBill(saleReturnBill);
	}

	@Override
	public boolean checkSaleReturnBill(boolean pass, long id) {
		return saleReturnBillImpl.checkSaleReturnBill(pass, id);
	}

	@Override
	public boolean deleteSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		return saleReturnBillImpl.deleteSaleReturnBill(saleReturnBill);
	}

	@Override
	public SaleReturnBillVO findSaleReturnBillByID(long id) {
		return saleReturnBillImpl.findSaleReturnBillByID(id);
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBillByTime(Date time) {
		return saleReturnBillImpl.findSaleReturnBillByTime(time);
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBills() {
		return saleReturnBillImpl.findSaleReturnBills();
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByInterval(Date begin, Date end) {
		return saleReturnBillImpl.findSaleReturnBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByState(int state) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
