package stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.tableblservice.TableBLService;
import vo.BillVO;
import vo.CommodityVO;
import vo.OperateConditionTableVO;
import vo.SaleDetailsTableVO;

public class TableBLService_Stub implements TableBLService {
	BillVO bv;
	String id;
	String Note;
	OperateConditionTableVO tov;
	int profit;
    int in_sale;
	int discount_sale;
	int in_commodity; 
	int discount_commodity;
	int out_sale;
	int out_commodity;
	SaleDetailsTableVO tao;
	Time t;
	ArrayList<BillVO> billlist=new ArrayList<BillVO>();
	ArrayList<CommodityVO> commoditylist=new ArrayList<CommodityVO>();
	double total_num;
	public TableBLService_Stub(String id,String Note,int profit,int in_sale,int discount_sale,int in_commodity,int discount_commodity,int out_sale,int out_commodity,Time t,ArrayList<CommodityVO> commoditylist,int total_num,ArrayList<BillVO> billlist){
		this.id=id;
		this.Note=Note;
		this.profit=profit;
		this.in_sale=in_sale;
		this.in_commodity=in_commodity;
		this.out_sale=out_sale;
		this.out_commodity=out_commodity;
		this.t=t;
		this.commoditylist=commoditylist;
		this.total_num=total_num;
		this.billlist=billlist;
	}
	
	public SaleDetailsTableVO getSaleDetails(String field){
		tao=new SaleDetailsTableVO(t,commoditylist,total_num);
		System.out.println("Get SaleDetails Succeed");
		return tao;
	};
	public OperateConditionTableVO getOprateCondition(String field){
	 tov=new OperateConditionTableVO(profit,in_sale,discount_sale,in_commodity,discount_commodity,out_sale,out_commodity);
	 System.out.println("Get OprateCondition Succeed");	
	 return tov;
	};
	public ArrayList<BillVO> getOperateCourse(String field){
	    System.out.println("Get OperateCourse Succeed");
	    return billlist;
	    
	};
	public void Red(String id,String Note){
		System.out.println("新账单建立");
		bv=new BillVO();
	};
}

