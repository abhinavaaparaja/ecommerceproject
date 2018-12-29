package com.mysite.newmodel;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class CartItem  implements Serializable{

	@Id
	private String cartitemid;
	private int quantity;
	private double itemwisetotal;

	@ManyToOne
	@JoinColumn(name = "cartid")
	private Cart cart;
	private String xpsid;
	

//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="xpsid")
//	private XPS xps;

	public String getXpsid() {
		return xpsid;
	}

	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}

	public String getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemwisetotal() {
		return itemwisetotal;
	}

	public void setItemwisetotal(double itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}

	public Cart getCart() {
		return cart;
	}

	public  void setCart(Cart cart) {
		this.cart = cart;
	}

//	public XPS getXps() {
//		return xps;
//	}
//
//	public void setXps(XPS xps) {
//		this.xps = xps;
//	}
//	
	

}
