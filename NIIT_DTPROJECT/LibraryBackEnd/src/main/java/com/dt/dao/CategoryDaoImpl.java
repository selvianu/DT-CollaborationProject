package com.dt.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dt.model.Category;
@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(category);
		System.out.println("category added");
		return true;
	}

	public List<Category> retrieveCategory() {
		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("from Category");
		List<Category> clist = q1.list();
		session.close();
		return clist;
	}

	@Transactional
	public boolean deleteCategory(Category category) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(category);
		System.out.println("Category Deleted");
		return true;
	}

	public Category getCategory(int cId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Category category = currentSession.get(Category.class, cId);
		currentSession.close();
		return category;
	}

	public boolean updateCategory(Category category) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(category);
		System.out.println("category upated");
		return true;
	}

}
