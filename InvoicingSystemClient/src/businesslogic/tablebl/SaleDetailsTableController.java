package businesslogic.tablebl;

import java.sql.Date;

import businesslogicservice.tableblservice.SaleDetailsTableBLService;
import vo.SaleDetailsTableVO;

public class SaleDetailsTableController implements SaleDetailsTableBLService{
	SaleDetailsTable impl=new SaleDetailsTable();

	@Override
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SaleDetailsTableVO findByField(Date begin, Date end, String commodityName, String memberName,
			String operatorName) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {
		// TODO �Զ����ɵķ������
		return false;
	}


	
}
