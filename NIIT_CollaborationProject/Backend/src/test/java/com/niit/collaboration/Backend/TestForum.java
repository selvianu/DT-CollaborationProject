package com.niit.collaboration.Backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDao;
import com.niit.model.Forum;

public class TestForum {

	private static AnnotationConfigApplicationContext context;
	private static ForumDao forumdao;
	private Forum forum;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumdao = (ForumDao) context.getBean("forumdao");
		System.out.println("------init----");
	}

	/*
	 * @Test public void addForumTest() { forum = new Forum();
	 * forum.setForumName("empowerment"); forum.setForumstatus("A");
	 * forum.setForumusername("Aravind"); forum.setForumcreateDate(new Date());
	 * forum.setForumContent("Issues for woring women in the society");
	 * System.out.println("forum added");
	 * assertEquals("Product Successfully added to the database", true,
	 * forumdao.addForum(forum)); }
	 */

	/*
	 * @Test public void getForumTest() { // forum = new Forum(); //
	 * forum.setForumId(2); System.out.println("Get Forum Details"); Forum f =
	 * forumdao.getForum(2); assertNotNull("prbm in getting data" + f);
	 * System.out.println(f.getForumName()); System.out.println(f.getForumusername()
	 * + " " + f.getForumcreateDate());
	 * 
	 * }
	 */
	/*
	 * @Test public void deleteForumTest() { forum = new Forum();
	 * forum.setForumId(2); System.out.println("Forum Deleted");
	 * assertEquals("****deleted***", true, forumdao.deleteForum(forum));
	 * 
	 * }
	 */

	/*
	 * @Test public void updateForumTest() { forum.setForumId(4);
	 * forum.setForumName("Strong kids ###"); assertTrue("***updated***",
	 * forumdao.updateForum(forum)); // assertEquals("****updated***", true,
	 * forumdao.updateForum(forum)); }
	 */

	/*
	 * @Test public void approveForumTest() { forum = new Forum();
	 * forum.setForumstatus("A"); forum.setForumContent("zzz");
	 * forum.setForumusername("big"); forum.setForumId(4);
	 * forum.setForumcreateDate(new Date()); forum.setForumName("QQQQ");
	 * 
	 * System.out.println("Form Approval Status"); assertEquals("Forum Approved",
	 * true, forumdao.approveForum(forum)); }
	 */
	/*@Test
	public void UserListTest() {
		List<Forum> ulist = forumdao.listForum("QQQQ");
		System.out.println("list");
		for (Forum forum : ulist) {
			System.out.println(forum);
		}
		// assertEquals("list of users in blog", true, forumdao.listForum("Abi"));
	}*/
}
