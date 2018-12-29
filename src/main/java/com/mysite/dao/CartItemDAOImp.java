package com.mysite.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.newmodel.Cart;
import com.mysite.newmodel.CartItem;
import com.mysite.newmodel.Vw_Customer_Cart_Items;

@Repository
public class CartItemDAOImp implements CartItemDAOInt {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public boolean addItemTOCart(CartItem citem) {
		boolean result=false;
		Cart ct = citem.getCart();
		boolean itemfound=false;
		CartItem existingItem=null;
		for(CartItem ci:ct.getCartItems()) {
			if(ci.getXpsid().equals(citem.getXpsid())) {
				itemfound=true;
				existingItem=ci;
				break;
			}
		}
		if(itemfound==true) {
			if(existingItem.getQuantity()<5) {
				System.out.print("\n" + citem.getXpsid() + " found in cart");
				
				existingItem.setQuantity(existingItem.getQuantity()+1);
				Session ses = sessionFactory.openSession();
				ses.beginTransaction();
				ses.update(existingItem);
				ses.getTransaction().commit();
				ses.close();	
				result=true;
			}
			else { // quantity is already 5
				result=false;
			}		
		}
		else { // item not found
			System.out.print("\n" + citem.getXpsid() + " not found in cart");
			
			citem.setCartitemid(generateCartitemid());
			try {
				Session ses = sessionFactory.openSession();
				ses.beginTransaction();
				ses.save(citem);
				ses.getTransaction().commit();
				ses.close();
				result=true;
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}	
		}
		return result;
	}	
	
	

	private String generateCartitemid() {
		String newcartitemid=null;
		Session session =sessionFactory.openSession();
		Query qr=session.createQuery("from CartItem");
		int nor=qr.list().size();
		session.close();
		
		if(nor>0) {//if table is empty
			Session session1=sessionFactory.openSession();	
		Query qr1=session1.createQuery("select max(cartitemid) from CartItem");
		List<String> data=qr1.list();
		session1.close();
		String existingMaxId=data.get(0);
		int cartitem=Integer.parseInt(existingMaxId.substring(8));
		cartitem++;
		if(cartitem<=9) {
			newcartitemid="CARTITEM0000"+cartitem;
		}
		else if(cartitem<=99) {
			newcartitemid="CARTITEM000"+cartitem;
		}
			else if(cartitem<=999) {
				newcartitemid="CARTITEM00"+cartitem;
		}
		else if(cartitem<=9) {
			newcartitemid="CARTITEM0"+cartitem;
			}
				else {
					newcartitemid="CARTITEM"+cartitem;
				}
		}
		else {
			newcartitemid="CARTITEM00001";
		}
		return newcartitemid;
	}


	//@Override
	public boolean deleteCartitem(String cartitemid) {
		boolean result=false;
		try {
			Session ses = sessionFactory.openSession();
			CartItem ci = ses.get(CartItem.class,cartitemid);
			ses.beginTransaction();
			ses.delete(ci);
			ses.getTransaction().commit();
			ses.close();
			result=true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}


	//@Override
	public boolean incrQtyInCart(String cartitemid) {
		boolean result=false;
		Session ses = sessionFactory.openSession();
		try {
		CartItem ci = ses.get(CartItem.class, cartitemid);
			if(ci.getQuantity()<=4) {
				ci.setQuantity(ci.getQuantity()+1);
				ses.beginTransaction();
				ses.update(ci);
				ses.getTransaction().commit();
				ses.close();
				result=true;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}		
		return result;
	}


	////@Override
	public boolean decrQtyInCart(String cartitemid) {
		boolean result=false;
		Session ses = sessionFactory.openSession();
		try {
		CartItem ci = ses.get(CartItem.class, cartitemid);
			if(ci.getQuantity()>=2) {
				ci.setQuantity(ci.getQuantity()-1);
				ses.beginTransaction();
				ses.update(ci);
				ses.getTransaction().commit();
				ses.close();
				result=true;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}		
		return result;
	}

	
	//@Override
	public void updateCart(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		session.close();
	
	}



	//@Override
	public boolean clearcartitem(String cartid) {
		boolean result=false;
		try {
			Session ses = sessionFactory.openSession();
			Cart ci = ses.get(Cart.class,cartid);
			
			for(CartItem  ci1:ci.getCartItems()) {
			ses.beginTransaction();
			ses.delete(ci1);
			ses.getTransaction().commit();
			}
			ses.beginTransaction();
			ci.setGrandtotal(0);
			ses.update(ci);
			ses.getTransaction().commit();
			ses.close();
			result=true;
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}



	//@Override
	public Cart getCartById(String cartid) {
		Session ses = sessionFactory.openSession();
		Cart cart = ses.get(Cart.class,cartid);
		ses.close();
		return cart;
	}



	//@Override
	public List<Vw_Customer_Cart_Items> getCartItemsForCart(String cartid) {
		List<Vw_Customer_Cart_Items> data= null;
		Session ses = sessionFactory.openSession();
		String q = "from Vw_Customer_Cart_Items where cartid ='" + cartid + "' order by cartitemid";
		Query qry = ses.createQuery(q);
		data = qry.list();
		ses.close();	
		System.out.println(data);
		return data;
	}


	}
