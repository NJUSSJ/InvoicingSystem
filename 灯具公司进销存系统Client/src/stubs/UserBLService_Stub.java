package stubs;

import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{
	long ID;
	String name;
	String rank;
	@Override
	public String addUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return "��ӳɹ�";
	}

	@Override
	public String deleteUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return "ɾ���ɹ�";
	}

	@Override
	public UserVO findUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return new UserVO(ID,name,rank);
	}

	@Override
	public String updateUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return "�޸ĳɹ�";
	}

}
