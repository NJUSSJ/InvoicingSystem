package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;

public class User {
	
	public boolean addUser(UserVO a) {
		try {
			return RemoteHelper.getInstance().getUserDataService().insert(a.toUserPO());	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteUser(UserVO a) {
		try {
			return RemoteHelper.getInstance().getUserDataService().delete(a.toUserPO());	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据姓名查找操作员
	 */
	public UserVO findUserbyName(String name) {
		try {
			UserPO tmpPO=RemoteHelper.getInstance().getUserDataService().findUserbyName(name);
			if(tmpPO==null) {
				return null;
			}
			return toUserVO(RemoteHelper.getInstance().getUserDataService().findUserbyName(name));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据id查找操作员
	 */
	public UserVO findUserByID(long id){
		try {
			return toUserVO(RemoteHelper.getInstance().getUserDataService().findUserbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateUser(UserVO a) {
		try {
			return RemoteHelper.getInstance().getUserDataService().update(a.toUserPO());	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public UserVO toUserVO(UserPO userPO){
		if(userPO==null){ 
			return null;
		}
		return new UserVO(userPO.getID(),userPO.getPassword(),userPO.getRank(),userPO.getUserName());
	}
	/**
	 * 查找所有操作员
	 */
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
	/**
	 * 根据关键字查找操作员
	 */
	public ArrayList<UserVO> findUserbyFiled(String field){
		ArrayList<UserVO> results=new ArrayList<>();
		try {
			ArrayList<UserPO> users=RemoteHelper.getInstance().getUserDataService().findUserbyField(field);
			if(users.isEmpty()||users==null) return results;
			for(int i=0;i<users.size();i++) {
				results.add(toUserVO(users.get(i)));
			}
			return results;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return results;
	}

}
