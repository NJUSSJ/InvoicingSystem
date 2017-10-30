package stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.commodityblservice.CommodityBLService;
import vo.CategoryVO;
import vo.CommodityVO;

public class CommodityBLService_Stub implements CommodityBLService{
	String cvName;
	int cvID;
	int cvStock_num;
	int cvPrice;
	int cvBatch;
	int cvBatch_num;
	Time cvProduce_time;
	
	String cgvName;
	ArrayList<CategoryVO> cgvSub_category;
	ArrayList<CommodityVO> cgvSub_commodity;
	
	public CommodityBLService_Stub(String cvName,int cvID,int cvStock_num,int cvPrice,int cvBatch,
	int cvBatch_num,Time cvProduce_time,String cgvName){
		this.cvName=cvName;
		this.cvID=cvID;
		this.cvStock_num=cvStock_num;
		this.cvPrice=cvPrice;
		this.cvBatch=cvBatch;
		this.cvBatch_num=cvBatch_num;
		this.cvProduce_time=cvProduce_time;
		this.cgvName=cgvName;
	}
	

	@Override
	public CommodityVO getCommodity(String field) {
		// TODO 自动生成的方法存根
		return new CommodityVO(cvName,cvID,cvStock_num,cvPrice,cvBatch,cvBatch_num,cvProduce_time);
	}

	@Override
	public ArrayList<CategoryVO> getCategory() {
		// TODO 自动生成的方法存根
		ArrayList<CategoryVO> cgl=new ArrayList<CategoryVO>();
		cgl.add(new CategoryVO(cgvName,cgvSub_category,cgvSub_commodity));
		return cgl;
	}

	@Override
	public String addCommodity(CommodityVO c) {
		// TODO 自动生成的方法存根
		return "add commodity success";
	}

	@Override
	public String addCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return "add category success";
	}

	@Override
	public String deleteCommodity(CommodityVO c) {
		// TODO 自动生成的方法存根
		return "delete commodity success";
	}

	@Override
	public String deleteCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return "delete category success";
	}

	@Override
	public String modifyCommodity(CommodityVO c) {
		// TODO 自动生成的方法存根
		return "modify commodity success";
	}

	@Override
	public String modifyCategory(CategoryVO c) {
		// TODO 自动生成的方法存根
		return "modify category success";
	}

}
