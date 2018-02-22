package com.dt.dao;

import java.util.List;

import com.dt.model.Supplier;

public interface SupplierDao {
	public void insertSupplier(Supplier supplier);

	public List<Supplier> getAllSuppliers();

	public void deleteSupplier(int sid);// for project
	// public boolean deleteSupplier(Supplier supplier);//for test case

	public Supplier getSupplierById(int sid);

	public void updateSupplier(Supplier supplier);

}
