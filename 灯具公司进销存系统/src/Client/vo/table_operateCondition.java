package Client.vo;

public class table_operateCondition {
	int profit;
	int in_sale;
	int in_commodity;
	int out_sale;
	int out_commodity;
	
	public table_operateCondition(int profit,int in_sale,int in_commodity,int out_sale,int out_commodity) {
		this.profit=profit;
		this.in_sale=in_sale;
		this.in_commodity=in_commodity;
		this.out_commodity=out_commodity;
		this.out_sale=out_sale;
	}
}
