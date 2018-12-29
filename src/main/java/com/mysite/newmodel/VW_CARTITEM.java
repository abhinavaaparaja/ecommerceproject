package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VW_CARTITEM {
	@Id
	private String cartitemid;
	private int quantity;
	private int itemwisetotal;
	private String xpsid;
	private String supplierid;
	private String suppliername;
	private String productid;
	private String productname;
	private String cartid;
	private int xpsprice;
	private int xpsstock;
	
	
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
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
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
	public int getItemwisetotal() {
		return itemwisetotal;
	}
	public void setItemwisetotal(int itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}
	public String getXpsid() {
		return xpsid;
	}
	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	

}
