package com.mysite.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.controllers.EmailService;
import com.mysite.newmodel.Cart;
import com.mysite.newmodel.CartItem;
import com.mysite.newmodel.OrderDetails;
import com.mysite.newmodel.Orders;
import com.mysite.newmodel.Product;
import com.mysite.newmodel.ShippingAddress;
import com.mysite.newmodel.VW_PRD_CUST_REVIEWS;
import com.mysite.newmodel.Vw_Customer_Cart_Items;
import com.mysite.newmodel.XPS;
@Repository
public class OrderDAOImp implements OrderDAOInt {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private EmailService emailService;
	
	//@Override
	public void confirmCustomerOrder(Cart cart) {
			Orders ord = new Orders();
			String orderid = generateOrderId();
			ord.setOrderid(orderid);
			ord.setCustomerid(cart.getCustomer().getCustomerid());
			ord.setNoitems(cart.getCartItems().size());
			ord.setOrdertotal(cart.getGrandtotal());
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			Date date = new Date(currentDate.getTime());
			System.out.println(date);
			
			ord.setOrderdate(date);
			ShippingAddress sad = cart.getCustomer().getShippingAddress();
			
			String shipAddress = sad.getHouseno() + ", " + sad.getStreet() + ", " +
								 sad.getArea() + ", " + sad.getCity() + ", " + sad.getState() + ", " +
								 sad.getCountry() + "," + sad.getPincode();
			
			ord.setShippingAddress(shipAddress);
			
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(cart.getCustomer());
			ses.save(ord);
			ses.getTransaction().commit();
			ses.close();	
			
			ses = sessionFactory.openSession();
			String qry = "from Vw_Customer_Cart_Items where cartid='" + cart.getCartid() +"'";
			Query q = ses.createQuery(qry);
			List <Vw_Customer_Cart_Items> items = q.list();
			for(Vw_Customer_Cart_Items item:items) {
				OrderDetails orddet = new OrderDetails();
				orddet.setOrderid(orderid);
				orddet.setOrderDetid(generateOrderDetId());
				orddet.setProductid(item.getProductid());
				orddet.setProductname(item.getProductname());
				orddet.setSupplierid(item.getSupplierid());
				orddet.setSuppliername(item.getSuppliername());
				orddet.setQuantity(item.getQuantity());
				orddet.setProductprice(item.getXpsprice());
				orddet.setIsratinggiven(false);
				orddet.setRating(0);
				orddet.setIsreviewgiven(false);
				orddet.setReview(null);	
				
				
				XPS xmap = ses.get(XPS.class, item.getXpsid());
				xmap.setXpsstock(xmap.getXpsstock()-item.getQuantity());
				
				Product product = ses.get(Product.class, xmap.getProductid());
				
				product.setNo_itemssold(product.getNo_itemssold() + item.getQuantity());
			
				ses.beginTransaction();
				ses.save(orddet);
				ses.update(xmap);
				ses.update(product);
				ses.getTransaction().commit();
			}	
		
			List<CartItem> citems = cart.getCartItems();
			for(CartItem ci : citems) {
				ses.beginTransaction();
				ses.delete(ci);
				ses.getTransaction().commit();			
			}

			ses.close();
			ses = sessionFactory.openSession();
			cart.setGrandtotal(0);		
			ses.beginTransaction();
			ses.update(cart);
			ses.getTransaction().commit();

		String subject="Order Success::JustClick.com";
		String body="Dear"+cart.getCustomer().getCustname()+",\nWelcome to JustClick.com";;
		body = body+"\n\n Your order has placed Successfully.....!!!! Thank you\nYour OrderId:"+orderid;
		body = body+"\nRegards,\nJustClick Team\n";
		try {
			emailService.send(cart.getCustomer().getCustemailid(),subject,body);
			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}
		
		
		private String generateOrderId() {
			String newOrderId = "";

			Session ses = sessionFactory.openSession();
			Query qq = ses.createQuery("from Orders");

			if (qq.list().size() == 0) {
				newOrderId = "ORD00001";
				ses.close();
			} else {
				Query q = ses.createQuery("select max(orderid) from Orders");
				String prevId = q.list().get(0).toString();
				// String prevId = data.get(0).toString();
				System.out.print("\nExisting : " + prevId);
				int id = Integer.parseInt(prevId.substring(3));
				System.out.print("\nExisting id : " + id);
				id = id + 1;
				if (id <= 9)
					newOrderId = "ORD0000" + id;
				else if (id <= 99)
					newOrderId = "ORD000" + id;
				else if (id <= 999)
					newOrderId = "ORD00" + id;
				else if (id <= 9999)
					newOrderId = "ORD0" + id;
				else
					newOrderId = "ORD" + id;
				System.out.print("\nGenerated : " + newOrderId);
				ses.close();
			}
			return newOrderId;
		}
		
		private String generateOrderDetId() {
			String newOrderDetId = "";

			Session ses = sessionFactory.openSession();
			Query qq = ses.createQuery("from OrderDetails");

			if (qq.list().size() == 0) {
				newOrderDetId = "ORDDET00001";
				ses.close();
			} else {
				Query q = ses.createQuery("select max(orderDetid) from OrderDetails");
				String prevId = q.list().get(0).toString();
				// String prevId = data.get(0).toString();
				System.out.print("\nExisting : " + prevId);
				int id = Integer.parseInt(prevId.substring(6));
				System.out.print("\nExisting id : " + id);
				id = id + 1;
				if (id <= 9)
					newOrderDetId = "ORDDET0000" + id;
				else if (id <= 99)
					newOrderDetId = "ORDDET000" + id;
				else if (id <= 999)
					newOrderDetId = "ORDDET00" + id;
				else if (id <= 9999)
					newOrderDetId = "ORDDET0" + id;
				else
					newOrderDetId = "ORDDET" + id;
				System.out.print("\nGenerated : " + newOrderDetId);
				ses.close();
			}
			
			
			
			return newOrderDetId;
		}
	

	//@Override
	public List<Orders> getcustomerorders(String customerid) {
		List<Orders> orders = null;	
		Session ses = sessionFactory.openSession();
		String qry ="from Orders where customerid='" + customerid +"'";
		Query q = ses.createQuery(qry);
		orders=q.list();
		ses.close();
		return orders;
	}



	//@Override
	public List<OrderDetails> getOrderDetailsByOrderId(String orderid) {
		List<OrderDetails> orderdetails = null;	
		Session ses = sessionFactory.openSession();
		String qry ="from OrderDetails where orderid='" + orderid +"'";
		Query q = ses.createQuery(qry);
		orderdetails=q.list();
		ses.close();
		return orderdetails;
	}



	//@Override
	public OrderDetails getOrderDetailsById(String ordetid) {
		OrderDetails data = null;
		Session ses = sessionFactory.openSession();
		data = ses.get(OrderDetails.class, ordetid);
		ses.close();
		return data;
	}



	//@Override
	public void addProductReview(String ordetid, String reviewtitle, String reviewbody) {
		Session ses = sessionFactory.openSession();
		OrderDetails ordetdata = ses.get(OrderDetails.class, ordetid);
		ordetdata.setIsreviewgiven(true);
		ordetdata.setReviewtitle(reviewtitle);
		ordetdata.setReviewbody(reviewbody);
		ses.beginTransaction();
		ses.update(ordetdata);
		ses.getTransaction().commit();
		ses.close();		
	}

	
	

	}
