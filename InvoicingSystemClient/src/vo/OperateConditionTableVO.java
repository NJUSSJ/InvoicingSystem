package vo;

public class OperateConditionTableVO {
	int profit;
	int in_sale;
	int discount_sale;
	int in_commodity;
	int discount_commodity;
	int out_sale;
	int out_commodity;
	
	public OperateConditionTableVO(int profit,int in_sale,int discount_sale,int in_commodity,int discount_commodity,int out_sale,int out_commodity) {
		this.profit=profit;
		this.in_sale=in_sale;
		this.in_commodity=discount_commodity;
		this.discount_sale=discount_sale;
		this.discount_commodity=in_commodity;
		this.out_commodity=out_commodity;
		this.out_sale=out_sale;
	}
	public OperateConditionTableVO() {
		// TODO Auto-generated constructor stub
	}
}
