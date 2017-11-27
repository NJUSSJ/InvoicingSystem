package businesslogicservice.userblservice;

import vo.UserVO;

public interface UserBLService {
	
public boolean addUser(UserVO a);
public boolean deleteUser(UserVO a);
public UserVO findUserbyName (String name);
public boolean updateUser (UserVO a);

}
