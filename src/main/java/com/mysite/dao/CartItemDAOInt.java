package com.mysite.dao;

import java.util.List;

import com.mysite.newmodel.Cart;
import com.mysite.newmodel.CartItem;
import com.mysite.newmodel.Vw_Customer_Cart_Items;

public interface CartItemDAOInt {

	public boolean addItemTOCart(CartItem citem);

	public boolean deleteCartitem(String cartitemid);

	public boolean incrQtyInCart(String cartitemid);

	public boolean decrQtyInCart(String cartitemid);

	public void updateCart(Cart cart);

	public boolean clearcartitem(String cartid);
	
	public Cart getCartById(String cartid);

	public List<Vw_Customer_Cart_Items> getCartItemsForCart(String cartid);
	
	

	


	

}
