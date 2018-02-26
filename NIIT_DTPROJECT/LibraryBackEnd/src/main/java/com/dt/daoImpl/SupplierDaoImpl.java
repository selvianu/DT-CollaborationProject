package com.dt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dt.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertSupplier(com.dt.model.Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);

	}

	public List<Supplier> getAllSuppliers() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier", Supplier.class).list();
	}

	public void deleteSupplier(int supplierid) {
		sessionFactory.getCurrentSession().delete(getSupplierById(supplierid));

	}

	public com.dt.model.Supplier getSupplierById(int sid) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, sid);
	}

	public void updateSupplier(com.dt.model.Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);

	}

}
