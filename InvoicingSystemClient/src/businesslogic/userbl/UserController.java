package businesslogic.userbl;

import java.util.ArrayList;

import businesslogicservice.userblservice.UserBLService;
import po.UserPO;
import vo.UserVO;

public class UserController implements UserBLService {

	User userImpl=new User();
	@Override
	public boolean addUser(UserVO a) {
		return userImpl.addUser(a);
	}

	@Override
	public boolean deleteUser(UserVO a) {
		return userImpl.deleteUser(a);
	}

	@Override
	public UserVO findUserbyName(String name) {
		return userImpl.findUserbyName(name);
	}

	@Override
	public boolean updateUser(UserVO a) {
		return userImpl.updateUser(a);
	}

	@Override
	public UserVO toUserVO(UserPO userPO) {
		return userImpl.toUserVO(userPO);
	}

	@Override
	public UserVO findUserByID(long id) {
		return userImpl.findUserByID(id);
	}

	@Override
	public ArrayList<UserVO> findUsers() {
		return userImpl.findUsers();
	}

	

}
