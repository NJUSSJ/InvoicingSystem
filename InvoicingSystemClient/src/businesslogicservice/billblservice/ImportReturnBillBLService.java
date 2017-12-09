package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.ImportReturnBillPO;
import vo.ImportReturnBillVO;

public interface ImportReturnBillBLService {
	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po);
	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill);
	public boolean checkImportReturnBill(boolean pass,long id);
	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill);
	public ImportReturnBillVO findImportReturnBillByID(long id);
	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time);
	public ArrayList<ImportReturnBillVO> findImportReturnBills();
}
