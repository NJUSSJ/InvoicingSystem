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
	 * ֻ������ʱ��β������ۼ�¼
	 */
	public SaleDetailsTableVO findByDate(Date begin, Date end) {
		ArrayList<SaleBillVO> result=new SaleBillController().findSaleBillsByInterval(begin, end);
		return new SaleDetailsTableVO(begin,end,result);
	}
	/**����ʱ��κ͹ؼ��ֲ������ۼ�¼
	 * @param commodityName ��Ʒ������Ϊnull
	 * @param userName �ͻ�������Ϊnull
	 * @param operatorName ����Ա������Ϊnull
	 */
	public SaleDetailsTableVO findByField(Date begin, Date end,String commodityName,
			String memberName,String userName) {
		ArrayList<SaleBillVO> bills=new SaleBillController().findSaleBillsByField(begin, end, commodityName, memberName, userName);
		return new SaleDetailsTableVO(begin,end,bills);
	}
	/**
	 * ��������ϸ�����ָ����·������Ϊexcel��
	 * @param ����·��
	 * @return �������
	 */
	public boolean exportAsExcel(SaleDetailsTableVO vo, String path) {
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("������ϸ��:"+vo.getBegin()+"~"+vo.getEnd());
		HSSFRow row=sheet.createRow(0);
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("ʱ��");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("��Ʒ��");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("�ͺ�");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("����");
		cell.setCellStyle(style);
		cell=row.createCell(4);
		cell.setCellValue("����");
		cell.setCellStyle(style);
		cell=row.createCell(5);
		cell.setCellValue("�ܶ�");
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
