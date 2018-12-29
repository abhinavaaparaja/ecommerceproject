package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VW_P_XPS_S {

	@Id
	private String xpsid;
	private int xpsprice;
	private int xpsstock;
	private String xpsisavaliable;
	private String productid;
	private String productname;
	private String productdescription;
	private boolean isproductavaliable;
	private String supplierid;
	private String suppliername;
	private String supplierdescription;
	private boolean isavaliable;
	private int no_itemssold;
	private int no_rating;
	private float product_ratings;
	private int no_reviews;
	public String getXpsid() {
		return xpsid;
	}
	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
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
	public String getXpsisavaliable() {
		return xpsisavaliable;
	}
	public void setXpsisavaliable(String xpsisavaliable) {
		this.xpsisavaliable = xpsisavaliable;
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
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public boolean isIsproductavaliable() {
		return isproductavaliable;
	}
	public void setIsproductavaliable(boolean isproductavaliable) {
		this.isproductavaliable = isproductavaliable;
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
	public String getSupplierdescription() {
		return supplierdescription;
	}
	public void setSupplierdescription(String supplierdescription) {
		this.supplierdescription = supplierdescription;
	}
	public boolean isIsavaliable() {
		return isavaliable;
	}
	public void setIsavaliable(boolean isavaliable) {
		this.isavaliable = isavaliable;
	}
	public int getNo_itemssold() {
		return no_itemssold;
	}
	public void setNo_itemssold(int no_itemssold) {
		this.no_itemssold = no_itemssold;
	}
	public float getProduct_ratings() {
		return product_ratings;
	}
	public void setProduct_ratings(float product_ratings) {
		this.product_ratings = product_ratings;
	}
	public int getNo_reviews() {
		return no_reviews;
	}
	public void setNo_reviews(int no_reviews) {
		this.no_reviews = no_reviews;
	}
	public int getNo_rating() {
		return no_rating;
	}
	public void setNo_rating(int no_rating) {
		this.no_rating = no_rating;
	}
	
	
}