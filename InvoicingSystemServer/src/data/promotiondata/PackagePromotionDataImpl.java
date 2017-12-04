package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.promotiondataservice.PackagePromotionDataService;
import po.PackagePromotionPO;

/**
 * 
 * @author shisj
 *
 */
public class PackagePromotionDataImpl implements PackagePromotionDataService {

	@Override
	public boolean insert(PackagePromotionPO po) throws RemoteException {
		String sql="insert into packagepromotions (id,commoditylist,discount)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getCommoditylist()+"','"+po.getDiscount();
		
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
	public boolean delete(PackagePromotionPO po) throws RemoteException {
		String sql="delete from packagepromotions where id='"+po.getID()+"'";
		
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
	public boolean update(PackagePromotionPO po) throws RemoteException {
		String sql="updates packagepromotions set id='"+po.getID()+"',commoditylist='"+po.getCommoditylist()+"',discount='"+po.getDiscount()+"'";
		
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
	public ArrayList<PackagePromotionPO> findPackagePromotions() throws RemoteException {
		String sql="select * from packagepromotions";
		
		ArrayList<PackagePromotionPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				String commoditylist=result.getString("commoditylist");
				double discount=result.getDouble("discount");
				
				PackagePromotionPO tmpPO=new PackagePromotionPO(id, commoditylist, discount);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
