package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addUser(UserVO a) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getUserDataService().insert(a.toUserPO());	
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteUser(UserVO a) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getUserDataService().delete(a.toUserPO());	
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	
	public UserVO findUserbyName(String name) {
		try {
			UserPO tmpPO=RemoteHelper.getInstance().getUserDataService().findUserbyName(name);
			if(tmpPO==null) {
				return null;
			}
			return toUserVO(RemoteHelper.getInstance().getUserDataService().findUserbyName(name));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserVO findUserByID(long id){
		try {
			return toUserVO(RemoteHelper.getInstance().getUserDataService().findUserbyID(id));
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateUser(UserVO a) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getUserDataService().update(a.toUserPO());	
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	
	public UserVO toUserVO(UserPO userPO){
		return new UserVO(userPO.getID(),userPO.getPassword(),userPO.getRank(),userPO.getUserName());
	}
	public ArrayList<UserVO> findUsers(){
		return null;
	}

}
