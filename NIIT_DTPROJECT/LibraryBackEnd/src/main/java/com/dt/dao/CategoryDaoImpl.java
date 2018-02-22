package com.dt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dt.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).list();
	}

	public void deleteCategory(int cid) {
		sessionFactory.getCurrentSession().delete(getCategoryById(cid));

	}

	public Category getCategoryById(int cid) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, cid);
	}

	public void updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
