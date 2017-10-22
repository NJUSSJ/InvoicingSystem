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
		return "添加成功";
	}

	@Override
	public String deleteUser(UserVO a) {
		// TODO 自动生成的方法存根
		return "删除成功";
	}

	@Override
	public UserVO findUser(UserVO a) {
		// TODO 自动生成的方法存根
		return new UserVO(ID,name,rank);
	}

	@Override
	public String updateUser(UserVO a) {
		// TODO 自动生成的方法存根
		return "修改成功";
	}

}
