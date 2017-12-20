package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.SaleReturnBillPO;
import vo.SaleReturnBillVO;

public interface SaleReturnBillBLService {
	public SaleReturnBillVO toSaleReturnBillVO(SaleReturnBillPO po);
	public boolean submitSaleReturnBill(SaleReturnBillVO saleReturnBill);
	public boolean checkSaleReturnBill(boolean pass,long id);
	public boolean deleteSaleReturnBill(SaleReturnBillVO saleReturnBill);
	public SaleReturnBillVO findSaleReturnBillByID(long id);
	public ArrayList<SaleReturnBillVO> findSaleReturnBillByTime(Date time);
	public ArrayList<SaleReturnBillVO> findSaleReturnBills();
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByInterval(Date begin,Date end);
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByField(Date begin,Date end,String memberName,String userName);
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByState(int state);
	public ArrayList<SaleReturnBillVO> findSaleReturnBillsByUser(long userid);
}
