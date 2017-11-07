package businesslogicservice.tableblservice;

import java.util.ArrayList;

import vo.BillVO;
import vo.OperateConditionTableVO;
import vo.SaleDetailsTableVO;

public interface TableBLService {
	public SaleDetailsTableVO getSaleDetails(String field);
	public OperateConditionTableVO getOprateCondition(String field);
	public ArrayList<BillVO> getOperateCourse(String field);
	public void Red(String id,String Note);
}
