package com.Dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	public void insertProduct(Product product);

	public List<Product> retrieve();
	
	public Product findByProdId(int pid);
	
	public Product findByProdName(String pname);

	public void update(Product p);
	
	public void deleteProd(int pid);
	
	public List<Product> getProdByCatId(int cid);
	
	public List<Product> getProdBySupId(int sid);

	//public int findStockByProdId(String cartname);
	
	public List<Product> findByProdNameFrSearch(String pname);
}
