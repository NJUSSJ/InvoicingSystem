package data.accountdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Test;

import po.AccountPO;
import runner.ServerRunner;

public class AccountDataImplTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAccountbyID() {
		new ServerRunner();
		AccountPO expectPO=new AccountPO(Long.parseLong("62221902140982"),1000000, "China Bank");
		try {
			assertEquals(expectPO.getDeposit(), new AccountDataImpl().findAccountbyID(Long.parseLong("62221902140982")).getDeposit(),1);
			assertEquals(expectPO.getName(), new AccountDataImpl().findAccountbyID(Long.parseLong("62221902140982")).getName());

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAcountbyField() {
		fail("Not yet implemented");
	}

	@Test
	public void testBackUpDataBase() {
		fail("Not yet implemented");
	}

	@Test
	public void testRestore() {
		fail("Not yet implemented");
	}

}
