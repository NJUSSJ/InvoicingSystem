package driver;

import stubs.AccountBLService_Stub;
import vo.AccountVO;

public class AccountBLService_Driver {

	public void drive(AccountBLService_Stub stub){
		AccountVO av1=stub.getAccount(181908203);
		if(av1!=null){
			System.out.println("account existed!");
		}
		
		if((stub.addAccount(new AccountVO()).equals("Succeed"))){
			System.out.println("add pass");
		}
		if((stub.deleteAccount(new AccountVO()).equals("Succeed"))){
			System.out.println("delete pass");
		}
		if((stub.modifyAccount(8009280).equals("Succeed"))){
			System.out.println("modify pass");
		}
		if(stub.getAccountList("yes", 90090)!=null){
			System.out.println("accountList existed!");
		}
	}
}
