package com.mysite.dao;

import java.util.List;

import com.mysite.newmodel.Customer;
import com.mysite.newmodel.VwCustUsers;

public interface CustomerDAOInt {
	public String addCustomer(Customer cust) ;
	public Customer getCustomerById(String uid);
	public Customer getCustomerByCustId(String cid);
	public abstract List<VwCustUsers> getCustUsers();
	public abstract boolean disableCustomer(String custid);
	public abstract boolean enableCustomer(String custid);
	public abstract boolean changePassword(String custid, String currentpwd, String newpwd);
	
}
