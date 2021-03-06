package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.ImportReturnBillPO;
import vo.ImportReturnBillVO;

public interface ImportReturnBillBLService {
	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po);
	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill);
	public boolean checkImportReturnBill(boolean pass,String id);
	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill);
	public ImportReturnBillVO findImportReturnBillByID(String id);
	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time);
	public ArrayList<ImportReturnBillVO> findImportReturnBills();
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByInterval(Date begin,Date end);
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByField(Date begin,Date end,String memberName,String userName);
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByState(int state);
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByUser(long userid);
	public boolean fakeDelete(String id);
}
