package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityList;
import po.SaleBillPO;
import vo.SaleBillVO;

public interface SaleBillBLService {
	public SaleBillVO toSaleBillVO(SaleBillPO po);
	public boolean submitSaleBill(SaleBillVO saleBill);
	public boolean checkSaleBill(boolean pass,String id);
	public boolean deleteSaleBill(SaleBillVO saleBill);
	public SaleBillVO findSaleBillByID(String id);
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time);
	public ArrayList<SaleBillVO> findSaleBillsByInterval(Date begin,Date end);
	public ArrayList<SaleBillVO> findSaleBillsByField(Date begin,Date end,String commodityName,String memberName,String userName);
	public ArrayList<SaleBillVO> findSaleBills();
	public ArrayList<SaleBillVO> findSaleBillsByState(int state);
	public ArrayList<SaleBillVO> findSaleBillsByUser(long userid);
	public double handleSale(int rank,CommodityList list);
	public int handleCoupon(int rank,double sum);
}
