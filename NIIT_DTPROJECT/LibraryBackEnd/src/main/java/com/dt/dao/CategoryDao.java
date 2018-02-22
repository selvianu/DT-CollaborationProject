package com.dt.dao;

import java.util.List;

import com.dt.model.Category;

public interface CategoryDao {
	public void insertCategory(Category category);

	public List<Category> getAllCategories();

	public void deleteCategory(int cid);

	public Category getCategoryById(int cid);

	public void updateCategory(Category category);

}
