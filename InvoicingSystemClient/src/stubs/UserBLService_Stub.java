package stubs;

import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{
	long ID;
	String name;
	String rank;
	@Override
	public boolean addUser(UserVO a) {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public boolean deleteUser(UserVO a) {
		// TODO 自动生成的方法存根
		return true;
	}

	

	@Override
	public boolean updateUser(UserVO a) {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public UserVO findUserbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
