package stubs;

import java.util.ArrayList;

import businesslogicservice.userblservice.UserBLService;
import po.UserPO;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{
	long ID;
	String name;
	String rank;
	@Override
	public boolean addUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return true;
	}

	@Override
	public boolean deleteUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return true;
	}

	

	@Override
	public boolean updateUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return true;
	}

	@Override
	public UserVO findUserbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findUserByID(long id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public UserVO toUserVO(UserPO userPO) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<UserVO> findUsers() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<UserVO> findUsersbyField(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
