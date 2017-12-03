package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.ImportBillPO;
import vo.ImportBillVO;

public interface ImportBillBLService  {
	public ImportBillVO toImportBillVO(ImportBillPO po);
	public boolean submitImportBill(ImportBillVO importBill);
	public boolean checkImportBill(boolean pass,long id);
	public boolean deleteImportBill(ImportBillVO importBill);
	public ImportBillVO findImportBillByID(long id);
	public ArrayList<ImportBillVO> findImportBillByTime(Date time);
}
