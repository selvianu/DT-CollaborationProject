package com.dt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dt.model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	@Transactional
	public boolean deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	public List<Product> retrieveProducts() {
		Session session = sessionFactory.openSession();
		Query q2 = session.createQuery("from Product");
		List<Product> plist = q2.list();
		session.close();
		return plist;
	}

	public boolean updateProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
		System.out.println("product upated");
		return true;
	}

	public Product getProduct(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product product = currentSession.get(Product.class, productId);
	//	currentSession.close();
		return product;
	}

}
