package businesslogicservice.tableblservice;

import java.sql.Date;
import vo.SaleDetailsTableVO;

public interface SaleDetailsTableBLService {
	public SaleDetailsTableVO findByDate(Date begin,Date end);
	public SaleDetailsTableVO findByField(Date begin,Date end,String commodityName,
			String memberName,String userName);
	public boolean exportAsExcel(SaleDetailsTableVO vo,String path);
}
