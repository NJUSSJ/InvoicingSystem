package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.commoditydataservice.CommodityDataService;
import po.CommodityPO;

public class CommodityDataImpl implements CommodityDataService{

	/*
	 * 根据id查找商品
	 */
	@Override
	public CommodityPO findCommoditybyID(long id) throws RemoteException {
		String sql="select * from commodities where id="+id;
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String name=result.getString("name");
				String model=result.getString("model");
				int stocknum=result.getInt("stocknum");
				double importprice=result.getDouble("importprice");
				double saleprice=result.getDouble("saleprice");
				double lateimportprice=result.getDouble("lateimportprice");
				double latesaleprice=result.getDouble("latesaleprice");
				long parentid=result.getLong("parentid");
				
				CommodityPO tmpPO=new CommodityPO(name, id, model, stocknum, importprice, saleprice, lateimportprice, latesaleprice, parentid);
				
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 获取商品列表
	 */
	@Override
	public ArrayList<CommodityPO> findCommodities() throws RemoteException {
		String sql="select * from commodities";
		
		ArrayList<CommodityPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				String name=result.getString("name");
				String model=result.getString("model");
				int stocknum=result.getInt("stocknum");
				double importprice=result.getDouble("importprice");
				double saleprice=result.getDouble("saleprice");
				double lateimportprice=result.getDouble("lateimportprice");
				double latesaleprice=result.getDouble("latesaleprice");
				long parentid=result.getLong("parentid");
				long id=result.getLong("id");
				
				CommodityPO tmpPO=new CommodityPO(name, id, model, stocknum, importprice, saleprice, lateimportprice, latesaleprice, parentid);
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 根据商品名称查找商品
	 */
	@Override
	public CommodityPO findCommoditybyName(String name) throws RemoteException {
		String sql="select * from commodities where name="+name;
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String model=result.getString("model");
				int stocknum=result.getInt("stocknum");
				double importprice=result.getDouble("importprice");
				double saleprice=result.getDouble("saleprice");
				double lateimportprice=result.getDouble("lateimportprice");
				double latesaleprice=result.getDouble("latesaleprice");
				long parentid=result.getLong("parentid");
				long id=result.getLong("id");
				
				CommodityPO tmpPO=new CommodityPO(name, id, model, stocknum, importprice, saleprice, lateimportprice, latesaleprice, parentid);
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 新增商品
	 */
	@Override
	public boolean insert(CommodityPO po) throws RemoteException {
		String sql="insert into commodities (name, id, model, stocknum, importprice, saleprice, lateimportprice, latesaleprice, parentid)"
				+ "values"
				+ "('"+po.getName()+"','"+po.getID()+"','"+po.getModel()+"','"+po.getStockNum()+"','"+po.getImportPrice()+"','"+po.getSalePrice()+"','"
						+ po.getLateImportPrice()+"','"+po.getLateSalePrice()+"','"+po.getParentID()+"')";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(CommodityPO po) throws RemoteException {
		String sql="delete from commodities where id="+po.getID();
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CommodityPO po) throws RemoteException {
		String sql="update commodities set name='"+po.getName()+"',id='"+po.getID()+"',model='"+po.getModel()+"',stocknum='"+po.getStockNum()+"',importprice='"
				+ po.getImportPrice()+"',saleprice='"+po.getSalePrice()+"',lateimportprice='"+po.getLateImportPrice()+"',latesaleprice='"+po.getLateImportPrice()
				+"',parentid='"+po.getParentID()+"' where id='"+po.getID()+"'";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public ArrayList<CommodityPO> findCommoditiesbyField(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
