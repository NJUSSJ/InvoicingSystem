package businesslogic.userbl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import runner.ClientRunner;
import vo.UserVO;

public class UserControllerTest {
	UserController controller=new UserController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new ClientRunner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() {
		UserVO user=new UserVO(Long.parseLong("22"),"111111",2,"小红");
		assertEquals(true,controller.addUser(user));
		controller.deleteUser(user);
	}

	@Test
	public void testDeleteUser() {
		UserVO user=new UserVO(Long.parseLong("22"),"111111",2,"小红");
		controller.addUser(user);
		assertEquals(true,controller.deleteUser(user));
	}

	@Test
	public void testFindUserbyName() {
		assertEquals(1,controller.findUserbyName("1").getRank());
	}

	@Test
	public void testUpdateUser() {
		UserVO userl=new UserVO(Long.parseLong("22"),"111111",2,"小红");
		controller.addUser(userl);
		UserVO user=new UserVO(Long.parseLong("22"),"111111",2,"小红s");
		assertEquals(true,controller.updateUser(user));
		controller.deleteUser(user);
	}

	@Test
	public void testFindUserByID() {
		assertEquals(1,controller.findUserByID(Long.parseLong("1")).getRank());
	}

	@Test
	public void testFindUsers() {
		assertEquals(7,controller.findUsers().size());
	}

	@Test
	public void testFindUsersbyField() {
		assertEquals(1,controller.findUsersbyField("1").size());
	}

}
