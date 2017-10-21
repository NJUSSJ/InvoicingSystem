package businesslogicservice.userblservice;

import vo.UserVO;

public interface UserBLService {
public UserVO addUser(UserVO a);
public UserVO deleteUser(UserVO a);
public UserVO findUser (UserVO a);
public UserVO updateUser (UserVO a);
}
