package com.mysite.dao;

import java.util.List;


import com.mysite.newmodel.XPS;

public interface XPSDAOInt {

	public abstract List<XPS> getAllXPS();

	public abstract boolean addXps(XPS xps);
	public abstract XPS getXPSById(String xpsid);
	public abstract boolean updateXPS(XPS xps);
	public boolean  deleteXPS(String xpsid);
	
}
