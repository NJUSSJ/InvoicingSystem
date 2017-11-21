package businesslogicservice.userblservice;

import vo.UserVO;

public interface UserBLService {
	
public String addUser(UserVO a);
public String deleteUser(UserVO a);
public UserVO findUserbyName (String name);
public String updateUser (UserVO a);

}
