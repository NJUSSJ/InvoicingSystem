package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.promotiondataservice.PricePromotionDataService;
import po.PricePromotionPO;

/**
 * 
 * @author shisj
 *
 */
public class PricePromotionDataImpl implements PricePromotionDataService{

	@Override
	public boolean insert(PricePromotionPO po) throws RemoteException {
		String sql="insert into pricepromotions (id,priceline,gifts,coupon)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getPriceline()+"','"+po.getGifts()+"','"+po.getCoupon()+"')";
		
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
	public boolean delete(PricePromotionPO po) throws RemoteException {
		String sql="delete from pricepromotions where id='"+po.getID()+"'";
		
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
	public boolean update(PricePromotionPO po) throws RemoteException {
		String sql="update pricepromotions set id='"+po.getID()+"',priceline='"+po.getPriceline()+"',gifts='"+po.getGifts()+",coupon='"+po.getCoupon()+"'";
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
	public ArrayList<PricePromotionPO> findPricePromotions() throws RemoteException {
		String sql="select * from pricepromotions";
		
		ArrayList<PricePromotionPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				double priceline=result.getDouble("priceline");
				String gifts=result.getString("gifts");
				int coupon=result.getInt("coupon");
				PricePromotionPO tmpPo=new PricePromotionPO(id, priceline, gifts, coupon);
				
				results.add(tmpPo);
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
