package com.dt.dao;

import java.util.List;

import com.dt.model.Product;

public interface ProductDao {

	public boolean addProduct(Product product);

	public boolean deleteProduct(Product product);

	public List<Product> retrieveProducts();

	public boolean updateProduct(Product product);

	public Product getProduct(int productId);

	public List<Product> getAllProducts();
}
