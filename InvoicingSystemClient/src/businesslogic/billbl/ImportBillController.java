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
	public boolean checkImportBill(boolean pass, String id) {
		return importBillImpl.checkImportBill(pass, id);
	}

	@Override
	public boolean deleteImportBill(ImportBillVO importBill) {
		return importBillImpl.deleteImportBill(importBill);
	}

	@Override
	public ImportBillVO findImportBillByID(String id) {
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

	@Override
	public ArrayList<ImportBillVO> findImportBillsByField(Date begin, Date end, String memberName, String userName) {
		return importBillImpl.findImportBillsByField(begin, end, memberName, userName);
	}

	@Override
	public ArrayList<ImportBillVO> findImportBillsByState(int state) {
		return importBillImpl.findImportBillsByState(state);
	}

	@Override
	public ArrayList<ImportBillVO> findImportBillsByUser(long userid) {
		return importBillImpl.findImportBillsByUser(userid);
	}

	@Override
	public boolean fakeDelete(String id) {
		return importBillImpl.fakeDelete(id);
	}

}
