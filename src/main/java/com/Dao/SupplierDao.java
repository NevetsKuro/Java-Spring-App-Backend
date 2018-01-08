package com.Dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDao {

	public void insertSupplier(Supplier supllier);
	
	public List<Supplier> retrieve();
	
	public Supplier findBySuppId(int sid);
}
