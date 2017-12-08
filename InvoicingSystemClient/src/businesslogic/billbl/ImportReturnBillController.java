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
		// TODO 自动生成的方法存根
		return importReturnBillImpl.toImportReturnBillVO(po);
	}

	@Override
	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill) {
		// TODO 自动生成的方法存根
		return importReturnBillImpl.submitImportReturnBill(importReturnBill);
	}

	@Override
	public boolean checkImportReturnBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return importReturnBillImpl.checkImportReturnBill(pass, id);
	}

	@Override
	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill) {
		// TODO 自动生成的方法存根
		return importReturnBillImpl.deleteImportReturnBill(importReturnBill);
	}

	@Override
	public ImportReturnBillVO findImportReturnBillByID(long id) {
		// TODO 自动生成的方法存根
		return importReturnBillImpl.findImportReturnBillByID(id);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return importReturnBillImpl.findImportReturnBillByTime(time);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBills() {
		// TODO 自动生成的方法存根
		return null;
	}

}
