package driver;

import po.BillPO;
import stubs.TableDatabaseServiceMySqlImpl_Stub;

public class TableDataService_Driver {
	public void drive(TableDatabaseServiceMySqlImpl_Stub tabledataservice) {
		tabledataservice.clonebill(new BillPO());
		tabledataservice.find("123");
		tabledataservice.getbill();
		tabledataservice.insertTable_operateCondition("123");
		tabledataservice.insertTable_saleDetails("123");
	}
}
