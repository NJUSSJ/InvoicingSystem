package businesslogic.promotionbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import runner.ClientRunner;
import vo.MemberPromotionVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;

public class PromotionControllerTest {
   PromotionController controller=new PromotionController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMemberPromotion() {
		CommodityList list=new CommodityList();
		CommodityLineItem item=new CommodityLineItem(3, 1, 45000, 30000, "无");
		list.addCommodity(item);
	MemberPromotionVO promotion=new	MemberPromotionVO(Long.parseLong("5"),1,0.8,list,50);
		assertEquals(true,controller.addMemberPromotion(promotion));
		controller.deleteMemberPromotion(promotion);
	}

	@Test
	public void testAddPackagePromotion() {
		CommodityList list=new CommodityList();
		CommodityLineItem item=new CommodityLineItem(3, 1, 45000, 30000, "无");
		list.addCommodity(item);
		 PackagePromotionVO promotion =new  PackagePromotionVO(Long.parseLong("6"),list,0.8);
		 assertEquals(false,controller.addPackagePromotion(promotion));
		 controller.deletePackagePromotion(promotion);
	}

	@Test
	public void testAddPricePromotion() {
		CommodityList list=new CommodityList();
		CommodityLineItem item=new CommodityLineItem(3, 1, 45000, 30000, "无");
		list.addCommodity(item);
		PricePromotionVO promotion=new	PricePromotionVO(Long.parseLong("7"),80000,list,50);
			assertEquals(true,controller.addPricePromotion(promotion));
			controller.deletePricePromotion(promotion);
	}

	@Test
	public void testDeleteMemberPromotion() {
		CommodityList list=new CommodityList();
		CommodityLineItem item=new CommodityLineItem(3, 1, 45000, 30000, "无");
		list.addCommodity(item);
	MemberPromotionVO promotion=new	MemberPromotionVO(Long.parseLong("5"),1,0.8,list,50);
		controller.addMemberPromotion(promotion);
	assertEquals(true,controller.deleteMemberPromotion(promotion));

	}

	@Test
	public void testDeletePackagePromotion() {
		CommodityList list=new CommodityList();
		CommodityLineItem item=new CommodityLineItem(3, 1, 45000, 30000, "无");
		list.addCommodity(item);
		 PackagePromotionVO promotion =new  PackagePromotionVO(Long.parseLong("6"),list,0.8);
		controller.addPackagePromotion(promotion);
		 assertEquals(false,controller.deletePackagePromotion(promotion));

	}

	@Test
	public void testDeletePricePromotion() {
		CommodityList list=new CommodityList();
		CommodityLineItem item=new CommodityLineItem(3, 1, 45000, 30000, "无");
		list.addCommodity(item);
		PricePromotionVO promotion=new	PricePromotionVO(Long.parseLong("7"),80000,list,50);
		controller.addPricePromotion(promotion);
		assertEquals(true,controller.deletePricePromotion(promotion));

	}

	@Test
	public void testFindMemberPromotions() {
		ArrayList<MemberPromotionVO> list=controller.findMemberPromotions();
		assertEquals(1,list.size());
	}

	@Test
	public void testFindPackagePromotions() {
		ArrayList<PackagePromotionVO> list=controller.findPackagePromotions();
		assertEquals(true,list.isEmpty());
	}

	@Test
	public void testFindPricePromotions() {
		ArrayList<PricePromotionVO> list=controller.findPricePromotions();
		assertEquals(true,list.isEmpty());
	}

	@Test
	public void testFindMemberPromotionByRank() {
		ArrayList<MemberPromotionVO> list=controller.findMemberPromotionByRank(2);
		assertEquals(true,list.isEmpty());
		
	}

}
