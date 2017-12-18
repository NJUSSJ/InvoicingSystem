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
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getUserDataService().insert(a.toUserPO());	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteUser(UserVO a) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getUserDataService().delete(a.toUserPO());	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateUser(UserVO a) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getUserDataService().update(a.toUserPO());	
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
	public UserVO toUserVO(UserPO userPO){
		if(userPO==null) return null;
		return new UserVO(userPO.getID(),userPO.getPassword(),userPO.getRank(),userPO.getUserName());
	}
	public ArrayList<UserVO> findUsers(){
		ArrayList<UserVO> temp=new ArrayList<UserVO>();
		try {
			ArrayList<UserPO> users = RemoteHelper.getInstance().getUserDataService().findUsers();
			for(int i=0;i<users.size();i++){
				temp.add(toUserVO(users.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
