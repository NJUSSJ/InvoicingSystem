package businesslogic.userbl;

import java.rmi.RemoteException;

import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

public class User {

	String name;
	long id;
	String password;
	int rank;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name) {
		this.name=name;
	}
	
	public String addUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return null;
	}

	
	public String deleteUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return null;
	}

	
	public UserVO findUserbyName(String name) {
		try {
			UserPO tmpUserPO=RemoteHelper.getInstance().getUserDataService().find(name);
			//δ�ҵ���ͬ�û������û�
			if(tmpUserPO==null) {
				return null;
			}
			return new UserVO(tmpUserPO.getID(), tmpUserPO.getPassword(), tmpUserPO.getRank(), tmpUserPO.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public String updateUser(UserVO a) {
		// TODO �Զ����ɵķ������
		return null;
	}
	

}
