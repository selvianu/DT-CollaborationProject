package com.niit;

import com.niit.DBConfig.dbConfig;
import com.niit.daoImpl.BlogDaoImpl;
import com.niit.model.Blog;

public class TestClass {

	public static void main(String[] args) {
		Blog b = new Blog();
		b.setBlogName("wordpress");
		b.setBlogId(1);
		b.setBlogContent("ur views");
		b.setCreateDate(null);
		b.setStatus("A");
		b.setUsername("Selvi");
		BlogDaoImpl bi = new BlogDaoImpl();
		String name = b.getBlogName();
		bi.addBlog(b);
		System.out.println(name);
		dbConfig db = new dbConfig();
		db.getDataSource();
//		db.getBlogDao();
	}

}
