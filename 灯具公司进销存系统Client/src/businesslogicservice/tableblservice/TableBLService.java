package businesslogicservice.tableblservice;

import java.util.ArrayList;

import vo.BillVO;
import vo.Table_operateConditionVO;
import vo.Table_saleDetailsVO;

public interface TableBLService {
	public Table_saleDetailsVO getSaleDetails(String field);
	public Table_operateConditionVO getOprateCondition(String field);
	public ArrayList<BillVO> getOperateCourse(String field);
	public String Red(BillVO vo);
}
