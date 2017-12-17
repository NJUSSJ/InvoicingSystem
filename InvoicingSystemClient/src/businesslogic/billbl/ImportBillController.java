package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.ImportBillBLService;
import po.ImportBillPO;
import vo.ImportBillVO;

public class ImportBillController implements ImportBillBLService{
	ImportBill importBillImpl=new ImportBill();
	@Override
	public ImportBillVO toImportBillVO(ImportBillPO po) {
		return importBillImpl.toImportBillVO(po);
	}

	@Override
	public boolean submitImportBill(ImportBillVO importBill) {
		return importBillImpl.submitImportBill(importBill);
	}

	@Override
	public boolean checkImportBill(boolean pass, long id) {
		return importBillImpl.checkImportBill(pass, id);
	}

	@Override
	public boolean deleteImportBill(ImportBillVO importBill) {
		return importBillImpl.deleteImportBill(importBill);
	}

	@Override
	public ImportBillVO findImportBillByID(long id) {
		return importBillImpl.findImportBillByID(id);
	}

	@Override
	public ArrayList<ImportBillVO> findImportBillByTime(Date time) {
		return importBillImpl.findImportBillByTime(time);
	}

	@Override
	public ArrayList<ImportBillVO> findImportBills() {
		return importBillImpl.findImportBills();
	}

	@Override
	public ArrayList<ImportBillVO> findImportBillsByInterval(Date begin, Date end) {
		return importBillImpl.findImportBillsByInterval(begin, end);
	}

}
