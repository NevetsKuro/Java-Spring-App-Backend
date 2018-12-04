package com.Dao;

import java.util.List;

import com.model.Product;
import java.sql.Blob;

public interface ProductDao {

	public void insertProduct(Product product);
        
        public Blob insertImage(byte[] image);

	public List<Product> retrieve();
	
	public Product findByProdId(int pid);
	
	public Product findByProdName(String pname);

	public void update(Product p);
	
	public void deleteProd(int pid);
	
	public List<Product> getProdByCatId(int cid);
	
	public List<Product> getProdBySupId(int sid);

	//public int findStockByProdId(String cartname);
	
	public List<Product> findByProdNameFrSearch(String pname);
        
	public List<Product> findByProdByTopChoice(String tc);

        public List<Product> findByProdByCols(String coll);
        
	public List<Product> findByProdNameFrSearch(String pname,int CatType);
}
