package stubs;

import po.BillPO;

public class TableDatabaseServiceMySqlImpl_Stub  {
	public BillPO find(String field){
		BillPO po=new BillPO();
		return po;
	}
	public void clonebill(BillPO po){
    System.out.println("Clone successed");
    }
    public void insertTable_operateCondition(String field){
    	System.out.println("Insert successed");
    }
    public void insertTable_saleDetails(String field){
    	System.out.println("Insert successed");
    }
    public BillPO getbill(){
    	BillPO bp=new BillPO();
    	System.out.println("Get Succeed");
    	return bp;
    }

}
