package com.niit.collaboration.Backend;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.Job;
import com.niit.model.User;

public class TestUser {
	private static AnnotationConfigApplicationContext context;
	private static UserDao userdao;
	private User user;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdao = (UserDao) context.getBean("userdao");
		System.out.println("------init userdao----");
	}

	/*@Test
	public void allUserTest() {
		user = new User();
		List<User> allUsers = userdao.getAllUsers();
		assertNotNull("no data" + allUsers);
		for (User user : allUsers) {
			System.out.println(user);
		}

		System.out.println("No of users:  " + allUsers.size());
	}*/

	/*
	 * @Test public void addUserTest() { user = new User();
	 * user.setUsername("selvi"); user.setUserId(10); // user.setRole(role);
	 * user.setRole("user"); user.setPhone("123456"); user.setPassword("000");
	 * user.setIsOnline('y'); user.setEnabled(true); user.setEmail("abc@gmail.com");
	 * System.out.println("add user"); assertEquals("user added to DB", true,
	 * userdao.addUser(user)); }
	 */

	/*
	 * @Test public void deleteUserTest() { user = new User();
	 * System.out.println("deleting...."); user.setUserId(10);
	 * assertEquals("User deleted", true, userdao.deleteUser(user)); }
	 */

	/*
	 * @Test public void updateUserTest() { user = new User(); user.setUserId(14);
	 * user.setIsOnline('y'); assertEquals("User Details Updated", true,
	 * userdao.updateUser(user)); }
	 */

	/*
	 * //@Test public void checkUserTest() { boolean userExists =
	 * userdao.userExists("selvi"); assertEquals("user exixts", true, userExists); }
	 * 
	 * @Test public void checkUserTestFail() { boolean userExists =
	 * userdao.userExists("bbbbb"); assertEquals("user exixts", false, userExists);
	 * }
	 */
}
