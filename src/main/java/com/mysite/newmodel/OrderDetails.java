package com.mysite.newmodel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetails implements Serializable {

	@Id
	private String orderDetid;
	private String orderid;
	private String productid;
	private String productname;
	private String supplierid;
	private String suppliername;
	private int quantity;
	private double productprice;
	private boolean isratinggiven;
	private boolean isreviewgiven;
	private int rating;
	private String review;
	private String reviewtitle;
	private String reviewbody;
	public String getOrderDetid() {
		return orderDetid;
	}
	public void setOrderDetid(String orderDetid) {
		this.orderDetid = orderDetid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public boolean isIsratinggiven() {
		return isratinggiven;
	}
	public void setIsratinggiven(boolean isratinggiven) {
		this.isratinggiven = isratinggiven;
	}
	public boolean isIsreviewgiven() {
		return isreviewgiven;
	}
	public void setIsreviewgiven(boolean isreviewgiven) {
		this.isreviewgiven = isreviewgiven;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getReviewtitle() {
		return reviewtitle;
	}
	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}
	public String getReviewbody() {
		return reviewbody;
	}
	public void setReviewbody(String reviewbody) {
		this.reviewbody = reviewbody;
	}
	
	
	
	}
