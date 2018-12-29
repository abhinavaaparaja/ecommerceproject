package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;


import org.hibernate.validator.constraints.Range;


@Entity
public class XPS {
	@Id
	private String xpsid;
	private String productid;
	private String supplierid;
	

	private int xpsprice;
	
	
	private int xpsstock;
	private boolean xpsisavaliable;
	
//	@OneToOne(mappedBy="xps")
//	private CartItem cartitem;
//	
//	public CartItem getCartitem() {
//		return cartitem;
//	}
//	public void setCartitem(CartItem cartitem) {
//		this.cartitem = cartitem;
//	}
	public String getXpsid() {
		return xpsid;
	}
	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	
	public int getXpsprice() {
		return xpsprice;
	}
	public void setXpsprice(int xpsprice) {
		this.xpsprice = xpsprice;
	}
	public int getXpsstock() {
		return xpsstock;
	}
	public void setXpsstock(int xpsstock) {
		this.xpsstock = xpsstock;
	}
	public boolean getXpsisavaliable() {
		return xpsisavaliable;
	}
	public void setXpsisavaliable(boolean xpsisavaliable) {
		this.xpsisavaliable = xpsisavaliable;
	}
		
	}
	

