package businesslogic.accountbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import runner.ClientRunner;
import vo.AccountVO;

public class AccountControllerTest {

	AccountController controller=new AccountController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAccountByID() {
		AccountVO account=controller.findAccountByID(Long.parseLong("62221902140982"));
		assertEquals("China Bank", account.getName());
	}

	@Test
	public void testAddAccount() {
		AccountVO testVO=new AccountVO(Long.parseLong("23465327819813"), 10000, "Low Bank");
		boolean ifSuccess=controller.addAccount(testVO);
		assertEquals(true, ifSuccess);
	}

	@Test
	public void testDeleteAccount() {
		AccountVO testVO=new AccountVO(Long.parseLong("23465327819813"), 10000, "Low Bank");
		boolean ifSuccess=controller.deleteAccount(testVO);
		assertEquals(true, ifSuccess);
	}

	@Test
	public void testUpdateAccount() {
		AccountVO testVO=new AccountVO(Long.parseLong("23465327819813"), 10000, "Low Bank");
		controller.addAccount(testVO);
		boolean ifSuccess=controller.updateAccount(new AccountVO(Long.parseLong("23465327819813"), 9000, "Low Bank"));
		assertEquals(true, ifSuccess);
		controller.deleteAccount(new AccountVO(Long.parseLong("23465327819813"), 9000, "Low Bank"));
	}


	@Test
	public void testFindAccountByField() {
		ArrayList<AccountVO> testVO=controller.findAccountByField("chi");
		assertEquals(testVO.get(0).getID(), Long.parseLong("62221902140982"));
	}

	@Test
	public void testFindAccounts() {
		ArrayList<AccountVO> test=controller.findAccounts();
		assertEquals(test.get(0).getID(), Long.parseLong("62221902140982"));
	}

	

}
