package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;
import com.niit.model.Forum;

@Repository("blogdao")
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			System.out.println("Blog Added");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBlog(Blog blog) {
		sessionFactory.getCurrentSession().remove(blog);
		System.out.println("BlogRemoved");
		return true;
	}

	public boolean updateBlog(Blog blog) {
		System.out.println("******");
		sessionFactory.getCurrentSession().update(blog);
		System.out.println("Forum Updated");
		return true;
	}

	public Blog getBlog(int blogId) {
		Session session = sessionFactory.openSession();
		Blog blog = session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		blog.setStatus("A");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	@Transactional
	public boolean rejectBlog(Blog blog) {
		blog.setStatus("NA");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	public List<Blog> listBlog(String username) {
		System.out.println("List of users in Blog");
		return sessionFactory.getCurrentSession().createQuery("from Blog where username='" + username + "'", Blog.class)
				.getResultList();
	}

}
