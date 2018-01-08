package com.Dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	public void insertProduct(Product product);

	public List<Product> retrieve();
	
	public Product findByProdId(int pid);

	public void update(Product p);
	
	public void deleteProd(int pid);
	
	public List<Product> getProdByCatId(int cid);
	
	public List<Product> getProdBySupId(int sid);
}
