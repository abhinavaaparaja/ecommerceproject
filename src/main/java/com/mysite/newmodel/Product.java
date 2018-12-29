package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
@Id
	private String productid;

	
	private String productname;
	private String productdescription;
	
	private boolean isproductavaliable;
	private int no_itemssold;
	private int no_rating;
	private float product_ratings;
	private int no_reviews;
	
	@Transient
	private MultipartFile imageFile;
	
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
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
	public boolean getIsproductavaliable() {
		return isproductavaliable;
	}
	public void setIsproductavaliable(boolean isproductavaliable) {
		this.isproductavaliable = isproductavaliable;
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
