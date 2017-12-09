package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.ImportReturnBillBLService;
import po.ImportReturnBillPO;
import vo.ImportReturnBillVO;

public class ImportReturnBillController implements ImportReturnBillBLService{
	ImportReturnBill importReturnBillImpl=new ImportReturnBill();
	@Override
	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po) {
		// TODO �Զ����ɵķ������
		return importReturnBillImpl.toImportReturnBillVO(po);
	}

	@Override
	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill) {
		// TODO �Զ����ɵķ������
		return importReturnBillImpl.submitImportReturnBill(importReturnBill);
	}

	@Override
	public boolean checkImportReturnBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return importReturnBillImpl.checkImportReturnBill(pass, id);
	}

	@Override
	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill) {
		// TODO �Զ����ɵķ������
		return importReturnBillImpl.deleteImportReturnBill(importReturnBill);
	}

	@Override
	public ImportReturnBillVO findImportReturnBillByID(long id) {
		// TODO �Զ����ɵķ������
		return importReturnBillImpl.findImportReturnBillByID(id);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return importReturnBillImpl.findImportReturnBillByTime(time);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBills() {
		// TODO �Զ����ɵķ������
		return null;
	}

}
