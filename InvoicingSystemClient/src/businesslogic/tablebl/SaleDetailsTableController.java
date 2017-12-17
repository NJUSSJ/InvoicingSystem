package businesslogic.tablebl;

import java.sql.Date;

import businesslogicservice.tableblservice.SaleDetailsTableBLService;
import vo.SaleDetailsTableVO;

public class SaleDetailsTableController implements SaleDetailsTableBLService{
	SaleDetailsTable impl=new SaleDetailsTable();

	@Override
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SaleDetailsTableVO findByField(Date begin, Date end, String commodityName, String memberName,
			String operatorName) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {
		// TODO 自动生成的方法存根
		return false;
	}


	
}
