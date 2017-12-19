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
		return importReturnBillImpl.toImportReturnBillVO(po);
	}

	@Override
	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill) {
		return importReturnBillImpl.submitImportReturnBill(importReturnBill);
	}

	@Override
	public boolean checkImportReturnBill(boolean pass, long id) {
		return importReturnBillImpl.checkImportReturnBill(pass, id);
	}

	@Override
	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill) {
		return importReturnBillImpl.deleteImportReturnBill(importReturnBill);
	}

	@Override
	public ImportReturnBillVO findImportReturnBillByID(long id) {
		return importReturnBillImpl.findImportReturnBillByID(id);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time) {
		return importReturnBillImpl.findImportReturnBillByTime(time);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBills() {
		return importReturnBillImpl.findImportReturnBills();
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByInterval(Date begin, Date end) {
		return importReturnBillImpl.findImportReturnBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByField(Date begin, Date end, String memberName,
			String userName) {
		return importReturnBillImpl.findImportReturnBillsByField(begin, end, memberName, userName);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByState(int state) {
		return importReturnBillImpl.findImportReturnBillsByState(state);
	}

	@Override
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByUser(long userid) {
		return importReturnBillImpl.findImportReturnBillsByUser(userid);
	}

}
