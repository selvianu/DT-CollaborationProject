package dt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dt.model.Supplier;

@Transactional
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean insertSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
		return false;
	}

	public boolean updateSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return false;
	}

	public boolean deleteSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().remove(supplier);
		return false;
	}

}
