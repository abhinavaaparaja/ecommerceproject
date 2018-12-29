package com.mysite.newmodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VwCustUsers {
	@Id
	private String customerid;
	private String custemailid;
	private boolean enabled;
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustemailid() {
		return custemailid;
	}
	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
