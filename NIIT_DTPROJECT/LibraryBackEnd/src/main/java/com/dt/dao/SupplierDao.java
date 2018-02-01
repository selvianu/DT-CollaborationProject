package com.dt.dao;

import com.dt.model.Supplier;

public interface SupplierDao {

	public boolean insertSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

}
