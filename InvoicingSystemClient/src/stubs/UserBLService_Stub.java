package stubs;

import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{
	long ID;
	String name;
	String rank;
	@Override
	public String addUser(UserVO a) {
		// TODO 自动生成的方法存根
		return "add success";
	}

	@Override
	public String deleteUser(UserVO a) {
		// TODO 自动生成的方法存根
		return "delete success";
	}

	

	@Override
	public String updateUser(UserVO a) {
		// TODO 自动生成的方法存根
		return "update success";
	}

	@Override
	public UserVO findUserbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
