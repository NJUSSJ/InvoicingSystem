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
		// TODO �Զ����ɵķ������
		return saleReturnBillImpl.toSaleReturnBillVO(po);
	}

	@Override
	public boolean submitSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		// TODO �Զ����ɵķ������
		return saleReturnBillImpl.submitSaleReturnBill(saleReturnBill);
	}

	@Override
	public boolean checkSaleReturnBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return saleReturnBillImpl.checkSaleReturnBill(pass, id);
	}

	@Override
	public boolean deleteSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		// TODO �Զ����ɵķ������
		return saleReturnBillImpl.deleteSaleReturnBill(saleReturnBill);
	}

	@Override
	public SaleReturnBillVO findSaleReturnBillByID(long id) {
		// TODO �Զ����ɵķ������
		return saleReturnBillImpl.findSaleReturnBillByID(id);
	}

	@Override
	public ArrayList<SaleReturnBillVO> findSaleReturnBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return saleReturnBillImpl.findSaleReturnBillByTime(time);
	}
	
}
