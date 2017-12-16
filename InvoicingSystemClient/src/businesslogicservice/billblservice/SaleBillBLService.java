package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.SaleBillPO;
import vo.SaleBillVO;

public interface SaleBillBLService {
	public SaleBillVO toSaleBillVO(SaleBillPO po);
	public boolean submitSaleBill(SaleBillVO saleBill);
	public boolean checkSaleBill(boolean pass,long id);
	public boolean deleteSaleBill(SaleBillVO saleBill);
	public SaleBillVO findSaleBillByID(long id);
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time);
	public ArrayList<SaleBillVO> findSaleBills();
	public double handleSale(int rank,CommodityList list);
	public int handleCoupon(int rank,double sum);
}
