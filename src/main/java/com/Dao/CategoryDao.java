package com.Dao;

import java.util.List;

import com.model.Category;

public interface CategoryDao {

	public void insertCategory(Category category);
	
	public List<Category> retrieve();
	
	public Category findByCatId(int cid);
}
