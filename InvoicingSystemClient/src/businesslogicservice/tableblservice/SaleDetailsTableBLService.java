package businesslogicservice.tableblservice;

import java.util.Date;
import vo.SaleDetailsTableVO;

public interface SaleDetailsTableBLService {
	public SaleDetailsTableVO findByDate(Date begin,Date end);
	public SaleDetailsTableVO findByField(Date begin,Date end,String field);
	public boolean exportAsExcel(SaleDetailsTableVO vo,String path);
}
