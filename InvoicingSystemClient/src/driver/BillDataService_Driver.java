package driver;

import java.rmi.RemoteException;

import po.BillPO;
import stubs.BillDatabaseServiceMySqlImpl_Stub;

public class BillDataService_Driver {
	public void drive(BillDatabaseServiceMySqlImpl_Stub stub){
		/*try {
			if(stub.find(90)!=null){
				System.out.println("find pass");
			}
			stub.insert(new BillPO());
			stub.delete(new BillPO());
			stub.update(new BillPO());
			stub.init();
			stub.finish();
			} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		*/
	}
}
