package businesslogic.memberbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import runner.ClientRunner;
import vo.MemberVO;

public class MemberControllerTest {
    MemberController controller=new MemberController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddMember() {
		MemberVO member=new MemberVO(Long.parseLong("0011"), 1,1001, 1, "小红", Long.parseLong("33333333333"), "南大", "2@qq.com", 2,2, 2,Long.parseLong("1"));
		assertEquals(true,controller.addMember(member));
	}

	@Test
	public void testFindMemberByName() {
		MemberVO member=new MemberVO(Long.parseLong("0011"), 1,1001, 1, "小红", Long.parseLong("33333333333"), "南大", "2@qq.com", 2,2, 2,Long.parseLong("1"));
		controller.addMember(member);
		assertEquals(Long.parseLong("0011"),controller.findMemberByName("小红").getID());
	}
	
	@Test
	public void testUpdateMember() {
		MemberVO member=new MemberVO(Long.parseLong("0011"), 1,1001, 1, "小红", Long.parseLong("33333333333"), "南大", "2@qq.com", 2,2, 2,Long.parseLong("1"));
		controller.addMember(member);
		MemberVO memberl=new MemberVO(Long.parseLong("0011"), 2,1001, 1, "小红", Long.parseLong("33333333333"), "南大", "2@qq.com", 2,2, 2,Long.parseLong("1"));
		assertEquals(true,controller.updateMember(memberl));
	}

	@Test
	public void testFindMemberByID() {
		MemberVO member=new MemberVO(Long.parseLong("0011"), 1,1001, 1, "小红", Long.parseLong("33333333333"), "南大", "2@qq.com", 2,2, 2,Long.parseLong("1"));
		controller.addMember(member);
		assertEquals(Long.parseLong("0011"),controller.findMemberByID(Long.parseLong("0011")).getID());
	}
	
	@Test
	public void testDeleteMember() {
		MemberVO member=new MemberVO(Long.parseLong("0011"), 1,1001, 1, "小红", Long.parseLong("33333333333"), "南大", "2@qq.com", 2,2, 2,Long.parseLong("1"));
		controller.addMember(member);
		assertEquals(true,controller.deleteMember(member));
	}

	@Test
	public void testFindMembersByField() {
		ArrayList<MemberVO> list=controller.findMembersByField("3");
		assertEquals(true,list.isEmpty());
	}


	@Test
	public void testFindMembers() {
		ArrayList<MemberVO> list=controller.findMembers();
		assertEquals(2,list.size());
	}




}
