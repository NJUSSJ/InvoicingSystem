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
	public boolean checkSaleReturnBill(boolean pass, String id) {
		return saleReturnBillImpl.checkSaleReturnBill(pass, id);
	}

	@Override
	public boolean deleteSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		return saleReturnBillImpl.deleteSaleReturnBill(saleReturnBill);
	}

	@Override
	public SaleReturnBillVO findSaleReturnBillByID(String id) {
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
		return saleReturnBillImpl.findSaleReturnBillsByState(state);
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByField(Date begin, Date end, String memberName,
			String userName) {
		return saleReturnBillImpl.findSaleReturnBillsByField(begin, end, memberName, userName);
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByUser(long userid) {
		return saleReturnBillImpl.findSaleReturnBillsByUser(userid);
	}

	@Override
	public boolean fakeDelete(String id) {
		return saleReturnBillImpl.fakeDelete(id);
	}
	
}
