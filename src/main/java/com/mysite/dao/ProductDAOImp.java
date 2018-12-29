package com.mysite.dao;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.newmodel.OrderDetails;
import com.mysite.newmodel.Product;
import com.mysite.newmodel.VW_PRD_CUST_REVIEWS;
import com.mysite.newmodel.VW_P_XPS_S;


@Repository
public class ProductDAOImp implements ProductDAOInt {

	@Autowired
	private SessionFactory sessionFactory;
	//@Override
	public List<Product> getAllProducts() {
		List<Product> data;
		Session session = sessionFactory.openSession();
		Query qry = session.createQuery("from Product");
		data = qry.list();
		session.close();
		return data;

	}
	
	public String  generateproductId() {
		String newpdid=null;
		Session session =sessionFactory.openSession();
		Query qr=session.createQuery("from Product");
		int nor=qr.list().size();
		session.close();
		
		if(nor>0) {//if table is empty
			Session session1=sessionFactory.openSession();	
		Query qr1=session1.createQuery("select max(productid) from Product");
		List<String> data=qr1.list();
		session1.close();
		String existingMaxId=data.get(0);
		int pdid=Integer.parseInt(existingMaxId.substring(1));
		pdid++;
		if(pdid<=9) {
			newpdid="P0000"+pdid;
		}
		else if(pdid<=99) {
			newpdid="P000"+pdid;
		}
			else if(pdid<=999) {
		newpdid="P00"+pdid;
		}
		else if(pdid<=9) {
				newpdid="P0"+pdid;
			}
				else {
					newpdid="P"+pdid;
				}
		}
		else {
			newpdid="P00001";
		}
		return newpdid;
	}
private void saveProductImage(Product p) {
	try {
		if(p.getImageFile()!=null) {
			Path path=Paths.get("E:\\newproject\\testsite\\src\\main\\webapp\\resources\\images"+p.getProductid()+".jpg");
		p.getImageFile().transferTo(new File(path.toString()));
	
		}
		
	}
	catch(Exception ex) {
	ex.printStackTrace();
	}
}



	//@Override
	public boolean addproduct(Product p) {
		boolean result=false;
		try {
		p.setProductid(generateproductId());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		saveProductImage(p);
		session.close();
		result=true;

	}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	//@Override
	public Product getProductById(String productId) {
		Product result = null;
		Session session = sessionFactory.openSession();
		result = session.get(Product.class, productId);
		session.close();
		return result;
	}

	//@Override
	public boolean updateProduct(Product p) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		

	
	//@Override
	public boolean deleteProduct(String pid) {
		Session session = sessionFactory.openSession();
		Product prd= session.get(Product.class, pid);
		session.beginTransaction();
		session.delete(prd);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	//@Override
	public List<Product> getProductsForSupplierForXMAP(String supid) {
		List<Product> products = null;		
		Session ses = sessionFactory.openSession();
		String qry = "from Product where productid not in(select productid from XPS where supplierid='" + supid +"') order by 1";
		Query q = ses.createQuery(qry);
		products=q.list();
		ses.close();
		return products;
	}

	//@Override
	public void setRating(String pid, int rating, String ordetid) {
		
		Session ses = sessionFactory.openSession();		
		Product prd = ses.get(Product.class, pid);
		OrderDetails ordet = ses.get(OrderDetails.class, ordetid);
		ordet.setIsratinggiven(true);
		ordet.setRating(rating);
		//int erating = prd.getNo_rating();
		float erating = prd.getProduct_ratings();
		erating += (float)rating;
		//int nor = prd.getNo_itemssold() + 1;
		float newrating;
		if(prd.getNo_rating()>=1) {
			newrating = (float)(erating)/2;
		}
		else {
			newrating = erating;
		}
		DecimalFormat df = new DecimalFormat("#.#");
		//df.setRoundingMode(RoundingMode.CEILING);
		newrating = Float.parseFloat(df.format(newrating));
		 
		prd.setProduct_ratings(newrating);
		prd.setNo_rating(prd.getNo_rating()+1);
		ses.beginTransaction();
		ses.update(prd);
		ses.update(ordet);
		ses.getTransaction().commit();
		ses.close();
		
	}

	//@Override
	public List<VW_P_XPS_S> getBestPriceVW_P_XPS_S() {

		Session ses = sessionFactory.openSession();		
		String qry = "from VW_P_XPS_S v1 where xpsprice = ( select min(xpsprice) fromVW_P_XPS_S v2 where v1.productid = v2.productid )";
		Query qr = ses.createQuery(qry);
		List<VW_P_XPS_S> vw_p_xps_s_data = qr.list();
		ses.close();
		return vw_p_xps_s_data;
		
	
		
			}

	//@Override
	public List<VW_PRD_CUST_REVIEWS> getProductReviews(String pid) {
		Session ses = sessionFactory.openSession();
		List<VW_PRD_CUST_REVIEWS> reviews=null;
		String q = "from VW_PRD_CUST_REVIEWS where productid='"+pid+"'";
		Query qry = ses.createQuery(q);
		reviews = qry.list();
		ses.close();
		return reviews;
	}

}