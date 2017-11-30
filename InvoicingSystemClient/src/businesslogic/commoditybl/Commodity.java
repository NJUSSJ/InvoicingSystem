package businesslogic.commoditybl;

import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import po.CategoryPO;
import po.CommodityPO;
import vo.CategoryVO;
import vo.CommodityVO;

public class Commodity{
	public boolean addCommodity(CommodityVO commodityVO){
		return false;
		
	}
	public boolean deleteCommodity(CommodityVO commodityVO){
		return false;
		
	}
	public boolean updateCommodity(CommodityVO commodityVO){
		return false;
	}
	public CommodityVO findCommodityByName(String name){
		return null;
		
	}
	public CommodityVO findCommodityByID(long id){
		return null;
	}
	public ArrayList<CommodityVO> findCommodityByField(String field) {
		return null;
	}
	public CommodityVO toCommodityVO(CommodityPO commodityPO){
		return new CommodityVO(commodityPO.getName(),commodityPO.getID(),commodityPO.getModel(),
				commodityPO.getStockNum(),commodityPO.getImportPrice(),commodityPO.getSalePrice(),
				commodityPO.getLateImportPrice(),commodityPO.getLateSalePrice(),commodityPO.getParentID());
	}
}
