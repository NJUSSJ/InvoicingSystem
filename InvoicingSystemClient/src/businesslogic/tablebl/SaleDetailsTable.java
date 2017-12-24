package businesslogic.tablebl;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.SaleBillController;
import businesslogic.commoditybl.CommodityController;
import vo.CommodityVO;
import vo.SaleBillVO;
import vo.SaleDetailsTableVO;

public class SaleDetailsTable{
	/**
	 * 只跟根据时间段查找销售记录
	 */
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillsByInterval(begin, end);
		return new SaleDetailsTableVO(begin,end,result);
	}
	/**根据时间段和关键字查找销售记录
	 * @param commodityName 商品名，可为null
	 * @param userName 客户名，可为null
	 * @param operatorName 操作员名，可为null
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end,String commodityName,
			String memberName,String userName) {
		ArrayList<SaleBillVO> bills=new SaleBillController().findSaleBillsByField(begin, end, commodityName, memberName, userName);
		return new SaleDetailsTableVO(begin,end,bills);
	}
	/**
	 * 将销售明细表根据指定的路径导出为excel表
	 * @param 导出路径
	 * @return 导出结果
	 */
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("销售明细表:"+vo.getBegin()+"~"+vo.getEnd());
		HSSFRow row=sheet.createRow(0);
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("时间");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("商品名");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("型号");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("数量");
		cell.setCellStyle(style);
		cell=row.createCell(4);
		cell.setCellValue("单价");
		cell.setCellStyle(style);
		cell=row.createCell(5);
		cell.setCellValue("总额");
		cell.setCellStyle(style);
		
		CommodityController con=new CommodityController();
		ArrayList<SaleBillVO> bills=vo.getList();
		CommodityList list;
		CommodityLineItem item;
		CommodityVO commodityVO;
		int index=0;
		for(int i=0;i<bills.size();i++){
			list=bills.get(i).getList();
			Date time=bills.get(i).getTime();
			for(int j=0;j<list.getListSize();j++){
				index++;
				item=list.get(j);
				commodityVO=con.findCommodityByID(item.getCommodityID());
				row=sheet.createRow(index);
				cell=row.createCell(0);
				cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(time));
				row.createCell(1).setCellValue(commodityVO.getName());
				row.createCell(2).setCellValue(commodityVO.getModel());
				row.createCell(3).setCellValue(item.getNum());
				row.createCell(4).setCellValue(item.getSalePrice());
				row.createCell(5).setCellValue(item.getSalePrice()*item.getNum());
			}
			
		}
		try {
			FileOutputStream fout = new FileOutputStream(path+".xls");
			wb.write(fout);
			wb.close();
			fout.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}



}
