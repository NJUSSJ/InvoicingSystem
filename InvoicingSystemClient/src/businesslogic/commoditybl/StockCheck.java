package businesslogic.commoditybl;

import java.util.ArrayList;

import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;

public class StockCheck {
	int start_time;
	int end_time;
	int importNum;
	double importAmount;
	int importReturnNum;
	double importReturnAmount;
	int saleNum;
	double saleAmount;
	int saleReturnNum;
	double saleReturnAmount;
	
	ArrayList<ImportBillVO> array1;
	ArrayList<ImportReturnBillVO> array2;
	ArrayList<SaleBillVO> array3;
	ArrayList<SaleReturnBillVO> array4;
	
	public StockCheck(int start,int end) {
		start_time=start;
		end_time=end;
	}
	
	public void addBill(ImportBillVO p,int t) {
		array1.add(p);
	}
	public void addBill(ImportReturnBillVO p,int t) {
		array2.add(p);
	}
	public void addBill(SaleBillVO p,int t) {
		array3.add(p);
	}
	public void addBill(SaleReturnBillVO p,int t) {
		array4.add(p);
	}
	
	public void clearAll() {
	
	}
	
	public int getImportNum(){
		for(ImportBillVO p:array1){
			importNum=importNum+p.getnum();
		}
		return importNum;
	}
	
	public double getImportAmount(){
		for(ImportBillVO p:array1){
			importAmount=importAmount+p.getsum();
		}
		return importAmount;
	}
	
	public int getImportReturnNum(){
		for(ImportReturnBillVO p:array2){
			importReturnNum=importReturnNum+p.getnum();
		}
		return importReturnNum;
	}
	
	public double getImportReturnAmount(){
		for(ImportReturnBillVO p:array2){
			importReturnAmount=importReturnAmount+p.getsum();
		}
		return importReturnAmount;
	}
	
	public int getSaleNum(){
		for(SaleBillVO p:array3){
			saleNum=saleNum+p.getnum();
		}
		return saleNum;
	}
	
	public double getSaleAmount(){
		for(SaleBillVO p:array3){
			saleAmount=saleAmount+p.getsum();
		}
		return saleAmount;
	}
	
	public int getSaleReturnNum(){
		for(SaleReturnBillVO p:array4){
			saleReturnNum=saleReturnNum+p.getnum();
		}
		return saleReturnNum;
	}
	
	public double getSaleReturnAmount(){
		for(SaleReturnBillVO p:array4){
			saleReturnAmount=saleReturnAmount+p.getsum();
		}
		return saleReturnAmount;
	}
}
