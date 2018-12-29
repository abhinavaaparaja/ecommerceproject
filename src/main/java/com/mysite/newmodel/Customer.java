package com.mysite.newmodel;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Customer implements Serializable {
	@Id
	private String customerid;
	
	@Length(min=5,message= "custname min length is 5")
	private  String custname;
	
	@Length(min=10,message="min length is 10")
	private String custemailid;
	
	@Length(min=10,message="min length is 10")
	private String custmobileno;
	
	@Transient
	private MultipartFile imageFile;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")

	private UserDetails userDetails;	
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billingaddressid")
	private BillingAddress billingAddress;
	
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippingaddressid")
	private ShippingAddress shippingAddress;
	
	
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;

	
	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public  String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustemailid() {
		return custemailid;
	}

	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}

	public String getCustmobileno() {
		return custmobileno;
	}

	public void setCustmobileno(String custmobileno) {
		this.custmobileno = custmobileno;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	
}
