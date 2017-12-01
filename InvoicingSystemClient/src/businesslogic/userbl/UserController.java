package businesslogic.userbl;

import businesslogicservice.userblservice.UserBLService;
import po.UserPO;
import vo.UserVO;

public class UserController implements UserBLService {

	User userImpl=new User();
	@Override
	public boolean addUser(UserVO a) {
		// TODO Auto-generated method stub
		return userImpl.addUser(a);
	}

	@Override
	public boolean deleteUser(UserVO a) {
		// TODO Auto-generated method stub
		return userImpl.deleteUser(a);
	}

	@Override
	public UserVO findUserbyName(String name) {
		// TODO Auto-generated method stub
		return userImpl.findUserbyName(name);
	}

	@Override
	public boolean updateUser(UserVO a) {
		// TODO Auto-generated method stub
		return userImpl.updateUser(a);
	}

	@Override
	public UserVO toUserVO(UserPO userPO) {
		// TODO 自动生成的方法存根
		return userImpl.toUserVO(userPO);
	}

	@Override
	public UserVO findUserByID(long id) {
		// TODO 自动生成的方法存根
		return userImpl.findUserByID(id);
	}

	

}
