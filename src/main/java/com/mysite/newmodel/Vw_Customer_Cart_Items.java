package com.mysite.newmodel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vw_Customer_Cart_Items implements Serializable {

	@Id
	private String cartitemid;
	private String cartid, xpsid, supplierid, suppliername, productid, productname;
	private int quantity, xpsprice, xpsstock;
	private double itemwisetotal;
	public String getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public double getItemwisetotal() {
		return itemwisetotal;
	}
	public void setItemwisetotal(double itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}	
	
	
}
