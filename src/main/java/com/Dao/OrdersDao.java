package com.Dao;

import java.util.List;

import com.model.Orders;

public interface OrdersDao {
	public void insertOrders(Orders orders);
	
	public List<Orders> findByCartID(int ordersId,String username);
	
	public void deleteOrders(int ordersId);
	
	public void updateOrders(Orders or);
}
