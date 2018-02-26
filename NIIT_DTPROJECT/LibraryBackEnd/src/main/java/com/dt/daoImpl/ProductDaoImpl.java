package com.dt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dt.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public Product insertProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return product;
	}

	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).list();

	}

	public Boolean deleteProduct(int pid) {
		sessionFactory.getCurrentSession().delete(getProductById(pid));
		return true;

	}

	public Product getProductById(int pid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, pid);
	}

	public Product getProductByCatId(int cid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, cid);

	}

	public Boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;

	}

}
