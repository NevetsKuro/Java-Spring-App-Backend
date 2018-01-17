package com.Dao;

import java.util.List;

import com.model.Cart;

public interface CartDao {
	
	public void insertCart(Cart cart);

	public List<Cart> findByCartID(String name);
	
	public Cart getByCartID(int cartId,String username);
	
	public void deleteCart(int cartId);
	
	public void updateCart(Cart cr);
}
