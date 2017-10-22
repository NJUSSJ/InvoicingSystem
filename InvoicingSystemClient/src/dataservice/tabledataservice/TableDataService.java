package dataservice.tabledataservice;

import po.BillPO;
import po.*;

public interface TableDataService {

	public BillPO find(String field);
    public void clonebill(BillPO po);
    public void insertTable_operateCondition(String field);
    public void insertTable_saleDetails(String field);
    public BillPO getbill();

}
