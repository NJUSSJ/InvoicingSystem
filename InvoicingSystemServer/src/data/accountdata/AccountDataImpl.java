package data.accountdata;
/**
 * @author shisj
 */
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.accountdataservice.accountdataservice;
import po.AccountPO;
import po.UserPO;

public class AccountDataImpl implements accountdataservice {

	/**
	 * 根据id查找账户
	 */
	@Override
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="SELECT id, bank, deposit FROM accounts";
		
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String bank=result.getString("bank");
				double deposit=result.getDouble("deposit");
				
				AccountPO tmpAccount=new AccountPO(tmpid, bank, deposit);
				if(tmpid==id) {
					return tmpAccount;
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 插入新的账户对象
	 */
	@Override
	public boolean insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO users(id,bank,deposit) VALUES("+po.getID()
		+",'"+po.getBank()+"','"+po.getDposit()+"')";
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * 删除账户对象
	 */
	@Override
	public boolean delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM users WHERE id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 维护账户对象
	 */
	@Override
	public boolean update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="UPDATE users SET deposit="+po.getDposit()+" WHERE id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<AccountPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		
		String sql="SELECT id, bank, deposit FROM accounts";
		ArrayList<AccountPO> results=new ArrayList<>();
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String bank=result.getString("bank");
				double deposit=result.getDouble("deposit");
				
				AccountPO tmpAccount=new AccountPO(tmpid, bank, deposit);
				results.add(tmpAccount);
				return results;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
