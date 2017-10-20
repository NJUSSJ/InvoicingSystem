package Client.businesslogicservice.tableblservice;

import java.util.ArrayList;

import Client.businesslogicservice.billblservice.BillBLService;
import Client.vo.BillVO;
import Client.vo.Table_operateConditionVO;
import Client.vo.Table_saleDetailsVO;

public interface TableBLService {
	public Table_saleDetailsVO getSaleDetails(String field);
	public Table_operateConditionVO getOprateCondition(String field);
	public ArrayList<BillVO> getOperateCourse(String field);
	public String Red(BillVO vo);
}
