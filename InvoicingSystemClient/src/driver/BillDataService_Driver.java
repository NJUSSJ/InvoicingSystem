package driver;

import java.rmi.RemoteException;

import po.BillPO;
import stubs.BillDatabaseServiceMySqlImpl_Stub;

public class BillDataService_Driver {
	public void drive(BillDatabaseServiceMySqlImpl_Stub stub){
		try {
			if(stub.importBill(new BillPO())!=null){
				System.out.println("import pass");
			}
			if(stub.exportBill(new BillPO())!=null){
				System.out.println("export pass");
			}
			if(stub.salesBill(new BillPO())!=null){
				System.out.println("sales pass");
			}
			if(stub.salesExportBill(new BillPO())!=null){
				System.out.println("salesExport pass");
			}
			if(stub.payBillPO(new BillPO())!=null){
				System.out.println("payBillPO pass");
			}
			if(stub.getMoneyBill(new BillPO())!=null){
				System.out.println("moneyPO pass");
			}
			if(stub.giftBill(new BillPO())!=null){
				System.out.println("giftBill pass");
			}
			if(stub.cashBill(new BillPO())!=null){
				System.out.println("cashBill pass");
			}
			if(stub.overBill(new BillPO())!=null){
				System.out.println("overBill pass");
			}
			if(stub.damageBill(new BillPO())!=null){
				System.out.println("damageBill pass");
			}
			if(stub.warnBill(new BillPO())!=null){
				System.out.println("warnBill pass");
			}
			if(stub.find(90)!=null){
				System.out.println("find pass");
			}
			stub.delete(new BillPO());
			stub.init();
			stub.finish();
			} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
