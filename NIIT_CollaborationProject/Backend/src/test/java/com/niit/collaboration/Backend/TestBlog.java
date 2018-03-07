package com.niit.collaboration.Backend;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

public class TestBlog {

	private static AnnotationConfigApplicationContext context;
	private static BlogDao blogdao;
	private Blog blog;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogdao = (BlogDao) context.getBean("blogdao");
		System.out.println("------init----");
	}

	/*@Test
	public void addBlogTest() {
		blog = new Blog();
		blog.setUsername("niit");
		blog.setStatus("A");
		blog.setCreateDate(new Date());
		blog.setBlogName("Connect");
		blog.setBlogContent("Review");
		System.out.println("add blog");
		assertEquals("Product Successfully added to the database", true, blogdao.addBlog(blog));
	}*/

	/*@Test
	public void getBlogTest() {
		blog = new Blog();
		blog.setBlogId(5);
		blog.setBlogName("abc");
		blog.setBlogContent("123456");
		blog.setCreateDate(new Date());
		blog.setUsername("xyz");
		blog.setStatus("A");
		System.out.println("getting blog details");
		Blog blog2 = blogdao.getBlog(5);
		assertNotNull("issue in data of blog" + blog2);
		System.out.println(blog2.getStatus() + blog2.getBlogName());
	}*/

	
}
