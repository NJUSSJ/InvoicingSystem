package businesslogicservice.billblservice;

import po.ImportReturnBillPO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;

public interface ImportReturnBillBLService {
	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po);
	public boolean conveyBill(ImportBillVO importbill);
	public ImportReturnBillVO checkBill(ImportReturnBillVO importbill);
}
