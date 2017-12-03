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
		// TODO �Զ����ɵķ������
		return importBillImpl.toImportBillVO(po);
	}

	@Override
	public boolean submitImportBill(ImportBillVO importBill) {
		// TODO �Զ����ɵķ������
		return importBillImpl.submitImportBill(importBill);
	}

	@Override
	public boolean checkImportBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return importBillImpl.checkImportBill(pass, id);
	}

	@Override
	public boolean deleteImportBill(ImportBillVO importBill) {
		// TODO �Զ����ɵķ������
		return importBillImpl.deleteImportBill(importBill);
	}

	@Override
	public ImportBillVO findImportBillByID(long id) {
		// TODO �Զ����ɵķ������
		return importBillImpl.findImportBillByID(id);
	}

	@Override
	public ArrayList<ImportBillVO> findImportBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return importBillImpl.findImportBillByTime(time);
	}

}
