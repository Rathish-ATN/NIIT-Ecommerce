package com.niit.Dao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.User;

public interface CartItemDao {
	
	User getUser(String email);
	void saveOrUpdateCartItem(CartItem cartItem);
	List<CartItem> getCartItems(String username);
	void removeCartItem(int itemId);
	public CartItem getCartItems(int itemid);

}
