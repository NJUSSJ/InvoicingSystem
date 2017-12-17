package businesslogic.tablebl;

import java.util.Date;

import businesslogicservice.tableblservice.SaleDetailsTableBLService;
import vo.SaleDetailsTableVO;

public class SaleDetailsTableController implements SaleDetailsTableBLService{
	SaleDetailsTable impl=new SaleDetailsTable();
	@Override
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		return impl.findByDate(begin, end);
	}

	@Override
	public SaleDetailsTableVO findByField(Date begin, Date end, String field) {
		return impl.findByField(begin, end, field);
	}

	@Override
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {
		return impl.exportAsExcel(vo, path);
	}
}
