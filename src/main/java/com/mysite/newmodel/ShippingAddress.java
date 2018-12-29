package com.mysite.newmodel;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;

@Entity
public class ShippingAddress implements Serializable {

	@Id
	private String shippingaddressid;
	
	@Length(min=5,message= "houseno min length is 5")
	private String houseno;
	
	@Length(min=5,message= "street min length is 5")
	private String street;
	
	@Length(min=5,message= "area min length is 5")
	private String area;
	
	@Length(min=5,message= "city min length is 5")
	private String city;
	
	@Length(min=5,message= "state min length is 5")
	private String state;
	
	@Length(min=5,message= "country min length is 5")
	private String country;
	
	@Length(min=5,message= "pincode min length is 5")
	private String pincode;
	
	@OneToOne(mappedBy="shippingAddress")
	private Customer customer;

	
		
		
	public String getShippingaddressid() {
		return shippingaddressid;
	}

	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}

	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
