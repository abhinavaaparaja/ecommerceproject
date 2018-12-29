package com.mysite.dao;

import java.util.List;


import com.mysite.newmodel.Cart;
import com.mysite.newmodel.OrderDetails;
import com.mysite.newmodel.Orders;
import com.mysite.newmodel.VW_PRD_CUST_REVIEWS;

public interface OrderDAOInt {
	public abstract void confirmCustomerOrder(Cart cart); 
	List<Orders> getcustomerorders(String customerid);
	public abstract List<OrderDetails> getOrderDetailsByOrderId(String orderid);
	
	public abstract OrderDetails getOrderDetailsById(String ordetid);
	public abstract void addProductReview(String ordetid, String reviewtitle, String reviewbody);
	
}
