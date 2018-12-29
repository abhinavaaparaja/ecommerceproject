package com.mysite.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.newmodel.Supplier;
import com.mysite.newmodel.XPS;
@Repository
public class XPSDAOImp implements XPSDAOInt {
@Autowired
private SessionFactory sessionfactory;
	//@Override
	public List<XPS> getAllXPS() {
		List<XPS> data;
		Session session = sessionfactory.openSession();
		Query qry = session.createQuery("from XPS");
		data = qry.list();
		session.close();
		return data;

	}
	
	private String generateXPSId() {
		String newid=null;	
	
		Session ses = sessionfactory.openSession();
		Query qry = ses.createQuery(" from XPS");
		int nor = qry.list().size();
		ses.close();
		if(nor>0) {	 // if table is not empty		
			Session ses1 = sessionfactory.openSession();			
			String qr = "select max(xpsid) from XPS";
			System.out.println(qr);
			Query qry1 = ses1.createQuery(qr);
			List<String> data = qry1.list();
			ses1.close();
			String existingId = data.get(0);
			System.out.print("\nExisting id : " + existingId);
			int id = Integer.parseInt(existingId.substring(3));
			System.out.println(id);
			id++;
			if(id<=9) {
				newid = "XPS0000"+id;				
			}
			else if(id<=99) {
				newid = "XPS000"+id;	
			}
			else if(id<=999) {
				newid = "XPS00"+id;	
			}
			else if(id<=9999) {
				newid = "XPS0"+id;	
			}
			else {
				newid = "XPS"+id;
			}	
		}
		else { // if table is empty
			newid="XPS00001";
		}
		return newid;
	}

	//@Override
	public boolean addXps(XPS xps) {
		boolean result = false;
		try {
			xps.setXpsid(generateXPSId());
			xps.setXpsisavaliable(true);
			Session ses = sessionfactory.openSession();
			ses.beginTransaction();
			ses.save(xps);
			ses.getTransaction().commit();
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	//@Override
	public XPS getXPSById(String xpsid) {
		XPS result = null;
		Session session = sessionfactory.openSession();
		result = session.get(XPS.class, xpsid);
		session.close();
		return result;
	}

	//@Override
	public boolean updateXPS(XPS xps) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();		
		session.update(xps);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	//@Override
	public boolean deleteXPS(String xpsid) {
		Session ses = sessionfactory.openSession();
		XPS xps = ses.get(XPS.class, xpsid);
		ses.beginTransaction();	
		ses.delete(xps);
		ses.getTransaction().commit();
		ses.close();
		return true;
	}

	
	
}

