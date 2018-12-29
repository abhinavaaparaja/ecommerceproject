package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VW_PRD_CUST_REVIEWS {
	@Id
	private String orderDetid;
	private String customerid; 
	private String custname;
	private String orderid;
	private String productid;
	private String reviewtitle;
	private String reviewbody;
	private boolean isratinggiven, isreviewgiven;
	private int rating;
	public String getOrderDetid() {
		return orderDetid;
	}
	public void setOrderDetid(String orderDetid) {
		this.orderDetid = orderDetid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getorderid() {
		return orderid;
	}
	public void setPriorderid(String orderid) {
		this.orderid = orderid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
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
	

}
