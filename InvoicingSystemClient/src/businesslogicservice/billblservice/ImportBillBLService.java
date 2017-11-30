package businesslogicservice.billblservice;

import po.ImportBillPO;
import vo.ImportBillVO;

public interface ImportBillBLService  {
	public ImportBillVO toImportBillVO(ImportBillPO po);
	public boolean conveyBill(ImportBillVO importbill);
	public ImportBillVO checkBill(ImportBillVO importbill);
}
