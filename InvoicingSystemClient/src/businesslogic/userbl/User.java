package businesslogic.userbl;

import java.rmi.RemoteException;

import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addUser(UserVO a) {
		// TODO 自动生成的方法存根
		UserPO tmpUserPO=new UserPO(a.getID(),a.getPassword(),a.getRank(),a.getUsername());
		try {
			return RemoteHelper.getInstance().getUserDataService().insert(tmpUserPO);	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteUser(UserVO a) {
		// TODO 自动生成的方法存根
		UserPO tmpUserPO=new UserPO(a.getID(),a.getPassword(),a.getRank(),a.getUsername());
		try {
			return RemoteHelper.getInstance().getUserDataService().delete(tmpUserPO);	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	
	public UserVO findUserbyName(String name) {
		try {
			UserPO tmpUserPO=RemoteHelper.getInstance().getUserDataService().find(name);
			//未找到相同用户名的用户
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

	
	public boolean updateUser(UserVO a) {
		// TODO 自动生成的方法存根
		UserPO tmpUserPO=new UserPO(a.getID(),a.getPassword(),a.getRank(),a.getUsername());
		try {
			return RemoteHelper.getInstance().getUserDataService().update(tmpUserPO);	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	

}
