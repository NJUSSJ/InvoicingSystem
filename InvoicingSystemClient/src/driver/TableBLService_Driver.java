package driver;

import stubs.TableBLService_Stub;

public class TableBLService_Driver {
	public void drive(TableBLService_Stub tableblservice) {
		tableblservice.getOperateCourse("123");
		tableblservice.getOprateCondition("123");
		tableblservice.getSaleDetails("123");
		tableblservice.Red("123", "123");
	}
}
