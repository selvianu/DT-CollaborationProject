package com.dt.dao;

import java.util.List;

import com.dt.model.Product;

public interface ProductDao {
	public Product insertProduct(Product product);

	public List<Product> getAllProducts();

	public Boolean deleteProduct(int pid);// for project

	public Product getProductById(int pid);

	public Product getProductByCatId(int cid);

	public Boolean updateProduct(Product product);

}
