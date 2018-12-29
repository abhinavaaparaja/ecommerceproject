package com.mysite.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.newmodel.VW_CARTITEM;



@Repository

 class VW_cartitemDAOImpl implements VW_cartitemDAOInt {

	
	
	@Autowired
	private SessionFactory sessionfactory;
	
	//@Override
	public List<VW_CARTITEM> getALLCartitems(String cartid) {
		
		Session session=sessionfactory.openSession();
		String qr="from VW_CARTITEM where cartid='"+cartid+"'";
		Query qry=session.createQuery(qr);
		List<VW_CARTITEM> data =qry.list();
		session.close();
		return data;
		
		
		
		
	}
		
	

	
}
	
	
	
	

