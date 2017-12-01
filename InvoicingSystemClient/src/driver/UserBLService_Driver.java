package driver;

import stubs.UserBLService_Stub;
import vo.UserVO;

public class UserBLService_Driver {
public void drive(UserBLService_Stub stub){
	if(stub.addUser(new UserVO(0, null, 0, null))){
		System.out.println("add pass");
	}
	if(stub.deleteUser(new UserVO(0, null, 0, null))){
		System.out.println("delete pass");
	}
	if(stub.addUser(new UserVO(0, null, 0, null))){
		System.out.println("find pass");
	}
	if(stub.updateUser(new UserVO(0, null, 0, null))){
		System.out.println("update pass");
	}
}
}
