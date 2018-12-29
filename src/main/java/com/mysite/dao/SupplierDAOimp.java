package com.mysite.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mysite.newmodel.Supplier;
@Repository
public class SupplierDAOimp implements SupplierDAOInt {
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> data;
		Session session = sessionFactory.openSession();
		Query qry = session.createQuery("from Supplier");
		data = qry.list();
		session.close();
		return data;

	}
public String generateSupplierid() {
	String newsid=null;
	Session session =sessionFactory.openSession();
	Query qr=session.createQuery("from Supplier");
	int nor=qr.list().size();
	session.close();
	
	if(nor>0) {//if table is empty
		Session session1=sessionFactory.openSession();	
	Query qr1=session1.createQuery("select max(supplierid) from Supplier");
	List<String> data=qr1.list();
	session1.close();
	String existingMaxId=data.get(0);
	int sid=Integer.parseInt(existingMaxId.substring(1));
	sid++;
	if(sid<=9) {
		newsid="S0000"+sid;
	}
	else if(sid<=99) {
		newsid="S000"+sid;
	}
	else if(sid<=999) {
		newsid="S00"+sid;
	}
	else if(sid<=9999) {
		newsid="S0"+sid;
	}
	else {
		newsid="S"+sid;
	}
}
else {
newsid="S00001";
}
return newsid;
}

private void saveSupplierImage(Supplier s) {
	try {
		if(s.getImageFile()!=null) {
			Path path=Paths.get("E:\\newproject\\testsite\\src\\main\\webapp\\resources\\suppliers"+s.getSupplierid()+".jpg");
		s.getImageFile().transferTo(new File(path.toString()));
	
		}
		
	}
	catch(Exception ex) {
	ex.printStackTrace();
	}
}
	//@Override
	public boolean addSupplier(Supplier s) {
		boolean result=false;
		try {
		
		s.setSupplierid(generateSupplierid());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		saveSupplierImage(s);
		session.close();
		result=true;

	}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	//@Override
	public Supplier getSupplierById(String supplierid) {
		Supplier result = null;
		Session session = sessionFactory.openSession();
		result = session.get(Supplier.class, supplierid);
		session.close();
		return result;
	}
	
	public boolean updateSupplier(Supplier s) {
		//boolean result=false;
		Session session = sessionFactory.openSession();
			session.beginTransaction();		
			session.update(s);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		


	public boolean deleteSupplier(String sid) {
		Session ses = sessionFactory.openSession();
			Supplier s = ses.get(Supplier.class, sid);
			ses.beginTransaction();	
			ses.delete(s);
			ses.getTransaction().commit();
			ses.close();
			return true;
		}
	
	
	}



