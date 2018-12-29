package com.mysite.dao;

import java.util.List;


import com.mysite.newmodel.Supplier;

public interface SupplierDAOInt {
	public abstract List<Supplier> getAllSuppliers();
	public abstract boolean addSupplier(Supplier s);
	public abstract Supplier getSupplierById(String supplierid);
	
	public abstract boolean updateSupplier(Supplier s);
	public abstract boolean deleteSupplier(String supplierid);
	
	


}
