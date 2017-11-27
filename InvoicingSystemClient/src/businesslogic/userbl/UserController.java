package businesslogic.userbl;

import businesslogicservice.userblservice.UserBLService;
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

	

}
