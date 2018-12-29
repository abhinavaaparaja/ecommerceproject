package com.mysite.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.newmodel.VW_P_XPS_S;

@Repository
public class ViewDAOImp implements ViewDAOInt {
	@Autowired
	private SessionFactory sessionfactory;
	


	public List<VW_P_XPS_S> getBestPriceVW_P_XPS_S() {
		
		Session session = sessionfactory.openSession();
		String qr = " from VW_P_XPS_S v1 where xpsprice= (select min(xpsprice) from VW_P_XPS_S  v2 where v1.productid=v2.productid)";
		Query qry = session.createQuery(qr);
		List<VW_P_XPS_S> data =qry.list();
		session.close();
		return data;
		
	}

	public List<VW_P_XPS_S> getAllVW_P_XPS_SbyproductId(String pid) {

		Session session= sessionfactory.openSession();
		String qr="from VW_P_XPS_S where productid='"+pid+"'";
		Query qry=session.createQuery(qr);
		List<VW_P_XPS_S> data =qry.list();
		session.close();
		return data;
		
		
		
		
		
	}

	//@Override
	public List<VW_P_XPS_S> getAllVW_P_XPS_Ssuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

}
