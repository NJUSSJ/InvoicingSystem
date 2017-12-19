package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.commoditydataservice.CategoryDataService;
import po.CategoryPO;
/**
 * 
 * @author shisj
 *
 */
public class CategoryDataImpl implements CategoryDataService{

	/**
	 * 新增商品类型
	 */
	@Override
	public boolean insert(CategoryPO po) throws RemoteException {
		String sql="insert into categories (id,name,parentid)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getName()+"','"+po.getParentID()+"')";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 维护商品类型
	 */
	@Override
	public boolean update(CategoryPO po) throws RemoteException {
		String sql="update categories set id='"+po.getID()+"',name='"+po.getName()+"',parentid='"+po.getParentID()+"'";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除商品类型
	 */
	@Override
	public boolean delete(CategoryPO po) throws RemoteException {
		String sql="delete from categories where id='"+po.getID()+"'";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询商品类型列表
	 */
	@Override
	public ArrayList<CategoryPO> findCategories() throws RemoteException {
		String sql="select * from categories";
		ArrayList<CategoryPO> results= new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				String name=result.getString("name");
				long parentid=result.getLong("parentid");
				
				CategoryPO tmpPO=new CategoryPO(id, name, parentid);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据父类查找商品类型
	 */
	@Override
	public ArrayList<CategoryPO> findCategorybyParent(long parentid) throws RemoteException {
		String sql="select * from categories where parentid='"+parentid+"'";
		ArrayList<CategoryPO> results= new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				String name=result.getString("name");
				
				
				CategoryPO tmpPO=new CategoryPO(id, name, parentid);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public CategoryPO findCategorybyID(long id) throws RemoteException {
		String sql="select * from categories where id='"+id+"'";
		
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long parentid=result.getLong("parentid");
				String name=result.getString("name");
				CategoryPO tmpPO=new CategoryPO(id, name, parentid);
				
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryPO findCategorybyName(String Name) throws RemoteException {
		String sql="select * from categories where name='"+Name+"'";
		
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long parentid=result.getLong("parentid");
				long id=result.getLong("id");
				
				CategoryPO tmpPO=new CategoryPO(id, Name, parentid);
				
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
