package dataservice.tabledataservice;

import po.BillPO;
import po.*;

public interface TableDataService {

	public String find(String field);
    public BillPO clone(BillPO po);
    public Table_operateConditionPO insertTable_operateCondition(String field);
    public Table_saleDetailsPO insertTable_saleDetails(String field);
    public BillPO getbill(BillPO po);

}
