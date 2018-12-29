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

import com.mysite.newmodel.Customer;
import com.mysite.newmodel.UserDetails;
import com.mysite.newmodel.VwCustUsers;
@Repository
public class CustomerDAOImp implements CustomerDAOInt {
	@Autowired
	private SessionFactory sessionFactory;

	
	private String generateCustId() {
		String newcustid=null;
		Session session =sessionFactory.openSession();
		Query qr=session.createQuery("from Customer");
		int nor=qr.list().size();
		session.close();
		
		if(nor>0) {
			Session session1=sessionFactory.openSession();	
		Query qr1=session1.createQuery("select max(customerid) from Customer");
		List<String> data=qr1.list();
		session1.close();
		String existingMaxId=data.get(0);
		int custid=Integer.parseInt(existingMaxId.substring(4));
		custid++;
		if(custid<=9) {
			newcustid="CUST0000"+custid;
		}
		else if(custid<=99) {
			newcustid="CUST000"+custid;
		}
			else if(custid<=999) {
		newcustid="CUST00"+custid;
		}
		else if(custid<=9999) {
				newcustid="CUST0"+custid;
			}
			else {
					newcustid="CUST"+custid;
				}
		}
		else {
			newcustid="CUST00001";
		}
		return newcustid;
	}
	



	
	private String generateUserId() {
		String newusrid=null;
		Session session =sessionFactory.openSession();
		Query qr2=session.createQuery("from UserDetails");
		int nor=qr2.list().size();
		session.close();
		if(nor>0) {
			Session session1=sessionFactory.openSession();	
		Query qr1=session1.createQuery("select max(userid) from UserDetails");
		List<String> data=qr1.list();
		session1.close();
		String existingMaxId=data.get(0);
		int usrid=Integer.parseInt(existingMaxId.substring(3));
		usrid++;
		if(usrid<=9) {
			newusrid="USR0000"+usrid;
		}
		else if(usrid<=99) {
			newusrid="USR000"+usrid;
		}
			else if(usrid<=999) {
				newusrid="USR00"+usrid;
		}
		else if(usrid<=9999) {
			newusrid="USR0"+usrid;
			}
		else if(usrid<=99999) {
			newusrid="USR"+usrid;
		}
			else {
				newusrid="USR"+usrid;
				}
		}
		else {
			newusrid="USR00001";
		}
		return newusrid;
	}
	


	
	private String generateBillingAddressId() {
		String newbaddid=null;
		Session session =sessionFactory.openSession();
		Query qr3=session.createQuery("from BillingAddress");
		int nor=qr3.list().size();
		session.close();
		if(nor>0) {
			Session session2=sessionFactory.openSession();	
		Query qr2=session2.createQuery("select max(billingaddressid) from BillingAddress");
		List<String> data=qr2.list();
		session2.close();
		String existingMaxId=data.get(0);
		int baddid=Integer.parseInt(existingMaxId.substring(4));
		baddid++;
		if(baddid<=9) {
			newbaddid="BADD0000"+baddid;
		}
		else if(baddid<=99) {
			newbaddid="BADD000"+baddid;
		}
			else if(baddid<=999) {
				newbaddid="BADD00"+baddid;
		}
		else if(baddid<=9999) {
			newbaddid="BADD0"+baddid;
			}
		else if(baddid<=99999) {
			newbaddid="BADD"+baddid;
		}
			else {
				newbaddid="BADD"+baddid;
				}
		}
		else {
			newbaddid="BADD00001";
		}
		return newbaddid;
	}


	
	private String generateShippingAddressId() {
		String newsaddid=null;
		Session session =sessionFactory.openSession();
		Query qr4=session.createQuery("from ShippingAddress");
		int nor=qr4.list().size();
		session.close();
		if(nor>0) {
			Session session3=sessionFactory.openSession();	
		Query qr3=session3.createQuery("select max(shippingaddressid) from ShippingAddress");
		List<String> data=qr3.list();
		session3.close();
		String existingMaxId=data.get(0);
		int saddid=Integer.parseInt(existingMaxId.substring(4));
		saddid++;
		if(saddid<=9) {
			newsaddid="SADD0000"+saddid;
		}
		else if(saddid<=99) {
			newsaddid="SADD000"+saddid;
		}
			else if(saddid<=999) {
				newsaddid="SADD00"+saddid;
		}
		else if(saddid<=9999) {
			newsaddid="SADD0"+saddid;
			}
		else if(saddid<=99999) {
			newsaddid="SADD"+saddid;
		}
			else {
				newsaddid="SADD"+saddid;
				}
		}
		else {
			newsaddid="SADD00001";
		}
		return newsaddid;
	}
	

	
	private String generateCartId() {
		String newcid=null;
		Session session =sessionFactory.openSession();
		Query qr5=session.createQuery("from Cart");
		int nor=qr5.list().size();
		session.close();
		if(nor>0) {
			Session session4=sessionFactory.openSession();	
		Query qr4=session4.createQuery("select max(cartid) from Cart");
		List<String> data=qr4.list();
		session4.close();
		String existingMaxId=data.get(0);
		int cid=Integer.parseInt(existingMaxId.substring(4));
		cid++;
		if(cid<=9) {
			newcid="CART0000"+cid;
		}
		else if(cid<=99) {
			newcid="CART000"+cid;
		}
			else if(cid<=999) {
				newcid="CART00"+cid;
		}
		else if(cid<=9999) {
			newcid="CART0"+cid;
			}
		else if(cid<=99999) {
			newcid="CART"+cid;
		}
			else {
				newcid="CART"+cid;
				}
		}
		else {
			newcid="CART00001";
		}
		return newcid;
	}

	
		private void saveCustomerImage(Customer cust) {
			try {
				if(cust.getImageFile()!=null) {
					Path path=Paths.get("E:\\newproject\\testsite\\src\\main\\webapp\\resources"+cust.getCustomerid()+".jpg");
					cust.getImageFile().transferTo(new File(path.toString()));
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
		}




		//@Override
		public String addCustomer(Customer cust) {
		
				String usrid=null;
				cust.setCustomerid(generateCustId());
				cust.getUserDetails().setUserid(generateUserId());
				cust.getBillingAddress().setBillingaddressid(generateBillingAddressId());
				cust.getShippingAddress().setShippingaddressid(generateShippingAddressId());
				cust.getCart().setCartid(generateCartId());
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				session.save(cust);
				session.getTransaction().commit();
				session.close();
				 saveCustomerImage(cust);
				 usrid=cust.getUserDetails().getUserid();
				 return usrid;
				
			}





		//@Override
		public Customer getCustomerByCustId(String cid) {
			Session ses = sessionFactory.openSession();
			Customer cust = ses.get(Customer.class, cid);
			ses.close();
			return cust;
		}


		//@Override
		public Customer getCustomerById(String usrid) {
			Session ses = sessionFactory.openSession();
			UserDetails ud = ses.get(UserDetails.class, usrid);
			ses.close();
			System.out.println("\nUser in dao :  " + ud);
			System.out.println("\nCustomer in dao :  " + ud.getCustomer());
			return ud.getCustomer();
		}





		//@Override
		public List<VwCustUsers> getCustUsers() {
			List<VwCustUsers> data=null;
			Session ses = sessionFactory.openSession();
			String q = " from VwCustUsers";
			Query qry = ses.createQuery(q);
			data = qry.list();
			ses.close();		
			return data;
		}





		//@Override
		public boolean disableCustomer(String custid) {
			
			boolean result=false;
			try {
				Session ses = sessionFactory.openSession();
				Customer cust = ses.get(Customer.class,custid);
				UserDetails ud = cust.getUserDetails();
				ud.setEnabled(false);
				ses.beginTransaction();
				ses.update(ud);
				ses.getTransaction().commit();
				ses.close();
				result = true;
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			return result;
		}

		//@Override
		public boolean enableCustomer(String custid) {
			boolean result=false;
			try {
				Session ses = sessionFactory.openSession();
				Customer cust = ses.get(Customer.class,custid);
				UserDetails ud = cust.getUserDetails();
				ud.setEnabled(true);
				ses.beginTransaction();
				ses.update(ud);
				ses.getTransaction().commit();
				ses.close();
				result = true;
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			return result;
		}





		//@Override
		public boolean changePassword(String custid, String currentpwd, String newpwd) {
			boolean result=false;
			Session ses = sessionFactory.openSession();
			// Get complete customer object based on custid
			// compare customer.userdetails password with parameter currentpwd
			// overwrite userdetais.password with newpwd if above passwords match
			Customer cust = ses.get(Customer.class, custid);
			UserDetails ud = cust.getUserDetails();
			if(ud.getPassword().equals(currentpwd)) {
				ud.setPassword(newpwd);
				ses.beginTransaction();
				ses.update(ud);
				ses.getTransaction().commit();
				result=true;
			}
			ses.close();
			return result;
		}






		

}

		