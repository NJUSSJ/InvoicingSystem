package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.ImportBillPO;
import vo.ImportBillVO;

public interface ImportBillBLService  {
	public ImportBillVO toImportBillVO(ImportBillPO po);
	public boolean submitImportBill(ImportBillVO importBill);
	public boolean checkImportBill(boolean pass,String id);
	public boolean deleteImportBill(ImportBillVO importBill);
	public ImportBillVO findImportBillByID(String id);
	public ArrayList<ImportBillVO> findImportBillByTime(Date time);
	public ArrayList<ImportBillVO> findImportBills();
	public ArrayList<ImportBillVO> findImportBillsByInterval(Date begin,Date end);
	public ArrayList<ImportBillVO> findImportBillsByField(Date begin,Date end,String memberName,String userName);
	public ArrayList<ImportBillVO> findImportBillsByState(int state);
	public ArrayList<ImportBillVO> findImportBillsByUser(long userid);
	public boolean fakeDelete(String id);
}
