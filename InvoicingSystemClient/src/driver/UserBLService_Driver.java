package driver;

import stubs.UserBLService_Stub;
import vo.UserVO;

public class UserBLService_Driver {
public void drive(UserBLService_Stub stub){
	if(stub.addUser(new UserVO()).equals("add success")){
		System.out.println("add pass");
	}
	if(stub.deleteUser(new UserVO()).equals("delete success")){
		System.out.println("delete pass");
	}
	if(stub.findUser(new UserVO())!=null){
		System.out.println("find pass");
	}
	if(stub.updateUser(new UserVO()).equals("update success")){
		System.out.println("update pass");
	}
}
}
