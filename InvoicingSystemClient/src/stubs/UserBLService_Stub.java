package stubs;

import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{
	long ID;
	String name;
	String rank;
	@Override
	public String addUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return "add success";
	}

	@Override
	public String deleteUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return "delete success";
	}

	@Override
	public UserVO findUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return new UserVO(ID,name,rank);
	}

	@Override
	public String updateUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return "update success";
	}

}
