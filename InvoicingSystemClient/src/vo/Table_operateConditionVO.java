package vo;

public class Table_operateConditionVO {
	int profit;
	int in_sale;
	int discount_sale;
	int in_commodity;
	int discount_commodity;
	int out_sale;
	int out_commodity;
	
	public Table_operateConditionVO(int profit,int in_sale,int discount_sale,int in_commodity,int discount_commodity,int out_sale,int out_commodity) {
		this.profit=profit;
		this.in_sale=in_sale;
		this.in_commodity=discount_commodity;
		this.discount_sale=discount_sale;
		this.discount_commodity=in_commodity;
		this.out_commodity=out_commodity;
		this.out_sale=out_sale;
	}
	public Table_operateConditionVO() {
		// TODO Auto-generated constructor stub
	}
}
