package com.mysite.newmodel;

import java.io.Serializable;
import java.util.List;

public class CartItemCheckOut implements Serializable {

	private List<Vw_Customer_Cart_Items> vwCartItems;

	public List<Vw_Customer_Cart_Items> getVwCartItems() {
		return vwCartItems;
	}

	public void setVwCartItems(List<Vw_Customer_Cart_Items> vwCartItems) {
		this.vwCartItems = vwCartItems;
	}	
}


