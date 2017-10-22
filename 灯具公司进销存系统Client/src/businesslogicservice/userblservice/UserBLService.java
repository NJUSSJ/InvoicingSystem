package businesslogicservice.userblservice;

import vo.UserVO;

public interface UserBLService {
public String addUser(UserVO a);
public String deleteUser(UserVO a);
public UserVO findUser (UserVO a);
public String updateUser (UserVO a);
}
