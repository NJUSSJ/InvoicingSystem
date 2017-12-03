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
		// TODO 自动生成的方法存根
		return importBillImpl.toImportBillVO(po);
	}

	@Override
	public boolean submitImportBill(ImportBillVO importBill) {
		// TODO 自动生成的方法存根
		return importBillImpl.submitImportBill(importBill);
	}

	@Override
	public boolean checkImportBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return importBillImpl.checkImportBill(pass, id);
	}

	@Override
	public boolean deleteImportBill(ImportBillVO importBill) {
		// TODO 自动生成的方法存根
		return importBillImpl.deleteImportBill(importBill);
	}

	@Override
	public ImportBillVO findImportBillByID(long id) {
		// TODO 自动生成的方法存根
		return importBillImpl.findImportBillByID(id);
	}

	@Override
	public ArrayList<ImportBillVO> findImportBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return importBillImpl.findImportBillByTime(time);
	}

}
