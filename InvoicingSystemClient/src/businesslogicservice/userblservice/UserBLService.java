package businesslogicservice.userblservice;

import java.util.ArrayList;

import po.UserPO;
import vo.UserVO;

public interface UserBLService {
	
public boolean addUser(UserVO a);
public boolean deleteUser(UserVO a);
public UserVO findUserbyName (String name);
public UserVO findUserByID(long id);
public boolean updateUser (UserVO a);
public UserVO toUserVO(UserPO userPO);
public ArrayList<UserVO> findUsers();
}
