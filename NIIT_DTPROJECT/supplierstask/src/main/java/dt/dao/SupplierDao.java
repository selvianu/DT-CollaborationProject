package dt.dao;

import dt.model.Supplier;

public interface SupplierDao {

	public boolean insertSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

}
