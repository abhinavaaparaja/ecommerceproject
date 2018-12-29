package com.mysite.dao;

import java.util.List;

import com.mysite.newmodel.Product;
import com.mysite.newmodel.VW_PRD_CUST_REVIEWS;
import com.mysite.newmodel.VW_P_XPS_S;

public interface ProductDAOInt {
	public abstract List<Product> getAllProducts();
	public abstract List<VW_P_XPS_S> getBestPriceVW_P_XPS_S();
	public abstract boolean addproduct(Product p);
	public abstract Product getProductById(String productId);
	public abstract boolean updateProduct(Product p);
	public abstract boolean deleteProduct(String pid );
	public abstract List<Product> getProductsForSupplierForXMAP(String supid);
	public abstract void setRating(String pid, int rating, String ordetid);
	public abstract List<VW_PRD_CUST_REVIEWS> getProductReviews(String pid);
	

}
