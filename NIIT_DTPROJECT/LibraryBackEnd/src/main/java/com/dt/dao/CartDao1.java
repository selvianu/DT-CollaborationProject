package com.dt.dao;

import java.util.List;

import com.dt.model.Cart;

public interface CartDao {
	public void addToCart(Cart cartitem);

	public List<Cart> getCartItems(String uname);

	public void deleteCartItem(Cart cart);

	public Cart getCartItem(int citemid);

	public void updateCartItem(Cart cart);

}
