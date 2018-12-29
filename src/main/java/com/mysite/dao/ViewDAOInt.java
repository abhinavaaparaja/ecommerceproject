package com.mysite.dao;

import java.util.List;

import com.mysite.newmodel.VW_P_XPS_S;



public interface ViewDAOInt {
	public abstract List<VW_P_XPS_S>getBestPriceVW_P_XPS_S();
	public abstract List<VW_P_XPS_S>getAllVW_P_XPS_SbyproductId(String pid);
	public abstract List<VW_P_XPS_S>getAllVW_P_XPS_Ssuppliers();
	
}
