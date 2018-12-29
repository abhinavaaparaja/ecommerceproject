package com.mysite.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.dao.CartItemDAOInt;
import com.mysite.dao.CustomerDAOInt;
import com.mysite.dao.OrderDAOInt;
import com.mysite.dao.ProductDAOInt;
import com.mysite.dao.VW_cartitemDAOInt;
import com.mysite.dao.ViewDAOInt;
import com.mysite.newmodel.CartItem;
import com.mysite.newmodel.Customer;
import com.mysite.newmodel.Message;
import com.mysite.newmodel.OrderDetails;
import com.mysite.newmodel.Orders;
import com.mysite.newmodel.Product;
import com.mysite.newmodel.VW_CARTITEM;
import com.mysite.newmodel.VW_PRD_CUST_REVIEWS;
import com.mysite.newmodel.VW_P_XPS_S;
import com.mysite.newmodel.Vw_Customer_Cart_Items;

@Controller
public class LoginController {

	@Autowired
	private CustomerDAOInt customerDao;
	@Autowired
	private ProductDAOInt productDao;
	@Autowired
	private ViewDAOInt viewDao;
	@Autowired
	private CartItemDAOInt cartDao;

	@Autowired
	private VW_cartitemDAOInt vwcartitemDao;
	
	@Autowired
	private OrderDAOInt  orderDao;
	
	
	@RequestMapping("/reqSpringLoginPage")
	public String displaySpringLoginPage(@RequestParam(value = "userid", required = false) String uid,
			@RequestParam(value = "loginfirst", required = false) String lf,
			@RequestParam(value = "autherror", required = false) String aer,
			@RequestParam(value = "logout", required = false) String lout,
			@RequestParam(value="pwdChangedS", required=false)String pwdChangedS,
			Model m) {
		Message mesg = null;
		if (uid != null) { // request after signup
			System.out.print("\nSingup is Done. Your user ID : " + uid);
			mesg =new Message("INF","Singup is Done. Your user ID : " + uid);

			m.addAttribute("message", mesg);
		}
		
		if (lf != null) { // request needs authentication
			System.out.print("\nLoginFirst");
			mesg = new Message("ERR","Please login before you continue.");
			m.addAttribute("message", mesg);
		} 
		
		else if (aer != null) { // reqtuest when login failed
			System.out.print("\nLogin failed, Try again....");
			mesg = new Message("ERR","Authenctaion failed. Please try again....");
			m.addAttribute("message", mesg);	
		}
		
		else if (lout != null) { // after logout
			System.out.print("\nLogin failed, Try again....");
			mesg = new Message("INF", "	Loged out successfully....");
			m.addAttribute("message", mesg);				
		}
		else if(pwdChangedS!=null) { // after change pwd		
			mesg = new Message("INF","Password changed successful");
			m.addAttribute("message", mesg);
		}
		
		
		List<com.mysite.newmodel.VW_P_XPS_S> view = viewDao.getBestPriceVW_P_XPS_S();
		m.addAttribute("views", view);
		
		
		return "login";
	}

	@RequestMapping(value={"/loginSuccess","/reqUserHome"})
	public String loginsucesspage(HttpSession hsession,Model m,@RequestParam(name = "itemsAddedS", required = false) String cartAddedS,
			@RequestParam(name = "itemsAddedF", required = false) String cartAddedF,@RequestParam(name="clearcartS", required=false)String clearcartS)
			
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		String userrole = authentication.getAuthorities().toString();
		System.out.print("\n UserId :" + username);
		System.out.print("\n Role:" + userrole);
		
		

		Customer cust = customerDao.getCustomerById(username);
		//m.addAttribute("customer", cust);
		hsession.setAttribute("customer", cust);
	
		System.out.print("\nFrom session : " + hsession.getAttribute("customer"));
		if (userrole.contains("ROLE_ADMIN")) {
			System.out.print("\nAdmin logedin");

			return "loginsucesspage_admin";
		} 
		else {
			System.out.print("\n User logedin");
			Message mesg=null;
			if(cartAddedS!=null) {
				mesg = new Message("INF","Item added to Cart successfully");
			}
			else if(cartAddedF!=null) {
				mesg = new Message("ERR","Item not added to cart. Maximum quantity can be 5 for same item.");
			}
			else if(clearcartS!=null) {
				mesg = new Message("INF","Cart cleared succesfully.");
			}
			m.addAttribute("message", mesg);
			
			
			
			
			List<com.mysite.newmodel.VW_P_XPS_S> view = viewDao.getBestPriceVW_P_XPS_S();
			m.addAttribute("views", view);
			return "loginsucesspage_user";
		}
		
	}
	@RequestMapping("/reqmoredetails")
	public String displayproductuser( @RequestParam(name="pid")String pid,Model m,
			@RequestParam(name="itemAddedToCartS", required=false)String itemAddedToCartS,
			@RequestParam(name="itemAddedToCartF", required=false)String itemAddedToCartF)
			 {
		if(itemAddedToCartS!=null) {
			Message mesg = new Message("INF","Item added to cart successfully.");
			m.addAttribute("message", mesg);
		}
		if(itemAddedToCartF!=null) {
			Message mesg = new Message("ERR","Item not added to cart. Maximum quantity can be 5 for same item.");
			m.addAttribute("message", mesg);
		}
		
		List<VW_P_XPS_S> view=viewDao.getAllVW_P_XPS_SbyproductId(pid);
		m.addAttribute("views",view);
		
		List<VW_PRD_CUST_REVIEWS> reviews= productDao.getProductReviews(pid);
		m.addAttribute("reviews", reviews);
		System.out.println(reviews);
		return "moredetails";
		
	
		
		
			 }
	@RequestMapping( "/reqGuestMoreSuppliersForProduct")
	public String displayMoreSupplierForProductGuest(@RequestParam(name="pid")String pid, Model m) {
		
		List<VW_P_XPS_S> view = viewDao.getAllVW_P_XPS_SbyproductId(pid);
		m.addAttribute("views",view);	
		
		List<VW_PRD_CUST_REVIEWS> reviews = productDao.getProductReviews(pid);
		m.addAttribute("reviews",reviews);
		return "allsuppliersforproductpageGuest";
	}
	
			 
		
			
	
	
	
 
	
	@RequestMapping("/reqAdminProductPage")
	public String displayAdminProductpage(@RequestParam(name = "prodAddedS", required = false) String prodAddedS,
			@RequestParam(name = "prodAddedF", required = false) String prodAddedF,
			@RequestParam(name = "prodRemovedS", required = false) String prodRemovedS,
			@RequestParam(name = "prodRemovedF", required = false) String prodRemovedF,
			@RequestParam(name = "prodEditedS", required = false) String prodEditedS,
			@RequestParam(name = "prodEditedF", required = false) String prodEditedF, Model m) {
		Message mesg;
		if (prodAddedS != null) {
			mesg = new Message("INF", "Product added successfully...");
			m.addAttribute("message", mesg);
		} else if (prodAddedF != null) {
			mesg = new Message("ERR", "Adding Product failed, Try again....");
			m.addAttribute("message", mesg);
		} else if (prodRemovedS != null) {
			mesg = new Message("INF", "Product Removed successfully...");
			m.addAttribute("message", mesg);
		} else if (prodRemovedF != null) {
			mesg = new Message("ERR", "Removing Product failed. Try again...");
			m.addAttribute("message", mesg);
		} else if (prodEditedS != null) {
			mesg = new Message("INF", "Product Edited successfully...");
			m.addAttribute("message", mesg);
		} else if (prodEditedF != null) {
			mesg = new Message("ERR", "Editing Product failed. Try again...");
			m.addAttribute("message", mesg);
		} else {
			mesg = null;
		}

		List<Product> product = productDao.getAllProducts();
		m.addAttribute("product", product);
		System.out.print(product);

		Product prd = new Product();
		m.addAttribute("productObj", prd);
		return "product_page";
	}

	@RequestMapping("/reqAdminSendProductDataToDB")
	public String addProductToDBSpring(@Valid @ModelAttribute("productObj") Product prd,BindingResult result, HttpSession hsession,Model m) {
		if(result.hasErrors()) {
			m.addAttribute("products", prd);
			return "product_page";
		}
		prd.setIsproductavaliable(true);	
		boolean result1=productDao.addproduct(prd);
		if(result1==true) {
			return "redirect:/reqAdminProductPage?prodAddedS";
		}
		else {
			return "redirect:/reqAdminProductPage?prodAddedF";
		}
	}
	@RequestMapping("/reqAdminEditProductPage")
	public String addProductEditPage(@RequestParam(name = "productid") String pid, Model m) {
		List<Product> product = productDao.getAllProducts();
		m.addAttribute("product", product);

		Product product1 = productDao.getProductById(pid);
		m.addAttribute("products", product1);
		return "editproductpage";
	}

	@RequestMapping("/reqAdminUpdateProductPage")
	public String addProductUpdatePage(@ModelAttribute(name = "productid") Product p,Model m) {
		//productDao.updateProduct(p);
		//return "redirect:/reqAdminProductPage";
	
		boolean result=productDao.updateProduct(p);
		if(result==true) {
			return "redirect:/reqAdminProductPage?prodEditedS";
		}
		else {
			return "redirect:/reqAdminProductPage?prodEditedF";
		}
		
	}
	
	

	@RequestMapping("/reqAdminDeleteProductPage")
	public String adminProductDelete(@RequestParam(name = "productid") String p) {
		//productDao.deleteProduct(p);
		
		boolean result=productDao.deleteProduct(p);
		if(result==true) {
			return "redirect:/reqAdminProductPage?prodRemovedS";
		}
		else {
			return "redirect:/reqAdminProductPage?prodRemovedF";
		}		
	}
	
	

	@RequestMapping("/reqUserAddXpsToCart")
	public String addXpsToCart(@RequestParam("xpsid") String xpsid,
			@RequestParam(name="pid", required=false) String pid,
			HttpSession hsession) {
		Customer presentCustomer =(Customer)hsession.getAttribute("customer");
		boolean result=false;
		CartItem citem = new CartItem();	
		citem.setCart(presentCustomer.getCart());
	citem.setXpsid(xpsid);
	citem.setQuantity(1);

	result=cartDao.addItemTOCart(citem);
	if (result == true) {
		if (pid == null) {
			return "redirect:/loginSuccess?itemsAddedS";
		}

		else {
			Customer cust = customerDao.getCustomerByCustId(presentCustomer.getCustomerid());
			hsession.setAttribute("customer", cust);
			return "redirect:/reqmoredetails?pid="+ pid +"&itemAddedToCartS";
		}
	}
	else {
		if (pid == null) {
			return "redirect:/loginSuccess?itemsAddedF";
		} else {

				return "redirect:/reqmoredetails?pid="+pid+"&itemAddedToCartF";	
			}
		}

}
	

		@RequestMapping("/reqUserCartItem")
	public String displayCartItem(
			@RequestParam(name="itemDeleteS",required=false) String itemDeleteS,
			@RequestParam(name="itemDeleteF",required=false) String itemDeleteF,
			@RequestParam(name="incrCartItemS", required=false)String incrCartItemS,
			@RequestParam(name="decrCartItemS", required=false)String decrCartItemS	,	
			@RequestParam(name="clearcartS", required=false)String clearcartS,

			
		
			HttpSession hsession,Model m) {
		
		Message mesg;
		if(itemDeleteS!=null) {
			mesg=new Message("INF","Product Delete from CartSuccessfully....");
			m.addAttribute("message",mesg);
		}
		else if(itemDeleteF!=null) {
			mesg=new Message("ERR","Product Delete From Cart failed,Try Again....");
			m.addAttribute("message", mesg);
		}
		else if(incrCartItemS!=null) {
			mesg = new Message("INF","Item quantity increased");
			m.addAttribute("message", mesg);
		}
		
		
		else if(decrCartItemS!=null) {
			mesg = new Message("INF","Item quantity decresed");
			m.addAttribute("message", mesg);
		}
	
		Customer cust = (Customer)hsession.getAttribute("customer");
		String cartid=cust.getCart().getCartid();
			
		List<VW_CARTITEM> cartitems= vwcartitemDao.getALLCartitems(cartid);
		double sum=0;
		for(VW_CARTITEM v:cartitems) {
			sum+=v.getQuantity()*v.getXpsprice();
		}
		cust.getCart().setGrandtotal(sum);
		cartDao.updateCart(cust.getCart());
		m.addAttribute("cartitems", cartitems);
		System.out.print(cartitems);
		return "cartitem";
		
		
	}
	
	@RequestMapping("/reqUserDeleteItemFromCart")
	public String deleteItemFromCart(@RequestParam("cartitemid")String cartitemid, HttpSession hsession) {
		boolean result = cartDao.deleteCartitem(cartitemid);
		if(result==true) {
			String custid = ((Customer)hsession.getAttribute("customer")).getCustomerid();
			Customer cust = customerDao.getCustomerByCustId(custid);

			hsession.setAttribute("customer", cust);
			return "redirect:/reqUserCartItem?itemDeleteS";
		}
		else {
			return "redirect:/reqUserCartItem?itemDeleteF";
		}
		
		
			}
		@RequestMapping("/reqUserIncrQuantity")
	public String incrQtyInCart(
			@RequestParam("cartitemid")String cartitemid) {
		boolean result = cartDao.incrQtyInCart(cartitemid);
		if(result==true) {			
			return "redirect:/reqUserCartItem?incrCartItemS";
		}
		else {
			return "redirect:/reqUserCartItem?incrCartItemF";
		}		
	}
	
	
	@RequestMapping("reqUserDecrQuantity")
	public String DecrQtyInCart(
		@RequestParam("cartitemid")String cartitemid) {
		
		boolean result = cartDao.decrQtyInCart(cartitemid);
		if(result==true) {
			return "redirect:/reqUserCartItem?decrCartItemS";
		}
		else {
		 return "redirect:/reqUserCartItem?decrCartItemF";
	}
	}
	
	@RequestMapping("/reqUserChangePwdPage")
	public String changePwdPage(
			@RequestParam(value="pwdChangedF", required=false)String pwdChangedF,
			Model m) {
		Message mesg=null;
		if(pwdChangedF!=null) { // after change pwd		
			mesg = new Message("ERR","Can not change password. Current password entered was wrong");	
		}
		m.addAttribute("message", mesg);
		return "changePwdUser";
	}
	
	@RequestMapping("/reqUserChangePwdToDB")
	public String changeUserPassword(HttpSession hsession,
			@RequestParam("currentpwd")String currentpwd,
			@RequestParam("newpwd")String newpwd,
			@RequestParam("confirmpwd")String confirmpwd,Model m			
			) {
		String custid = ((Customer)hsession.getAttribute("customer")).getCustomerid();
		boolean res=false;
		if(newpwd.equals(confirmpwd)) {
			res = customerDao.changePassword(custid,currentpwd,newpwd);
		}
		else {
			Message mesg = new Message("ERR","New password and Confirm passwords are mismatching");
			m.addAttribute("message", mesg);					
			return "changePwdUser";
		}
		if(res==true) {
			return "redirect:/reqSpringLoginPage?pwdChangedS";
		}
		else {
			return "redirect:/reqUserChangePwdPage?pwdChangedF";
		}
	}
	

	
	
	@RequestMapping("/reqclearcartitems")
	public String clearcartitems(@RequestParam("cartid")String cartid,HttpSession hsession) {
		boolean result =cartDao.clearcartitem(cartid);
					return "redirect:/loginSuccess?clearcartS";
		}
		


	@RequestMapping("/reqUserGetCartItems")
	public String getCartItemsForCustomer(HttpSession hsession, Model m,
			@RequestParam(name="deletedCartItemS", required=false)String deletedCartItemS,
			@RequestParam(name="deletedCartItemF", required=false)String deletedCartItemF,
			@RequestParam(name="incrCartItemS", required=false)String incrCartItemS,
			@RequestParam(name="decrCartItemS", required=false)String decrCartItemS			
			) {
		
		Message mesg=null;
		if(deletedCartItemS!=null) {
			mesg = new Message("INF","Item removed from cart successfully.");
		}
		else if(deletedCartItemF!=null) {
			mesg = new Message("ERR","Removing Item from cart failed. Try again...");
		}
		else if(incrCartItemS!=null) {
			mesg = new Message("INF","Item quantity increased");
		}
		else if(decrCartItemS!=null) {
			mesg = new Message("INF","Item quantity decresed");
		}
		m.addAttribute("message", mesg);
		Customer cust = ((Customer)hsession.getAttribute("customer"));
		String cartid = cust.getCart().getCartid();
		List<Vw_Customer_Cart_Items> cartitems = cartDao.getCartItemsForCart(cartid);
		double sum=0;
		for(Vw_Customer_Cart_Items v:cartitems) {
			sum += v.getQuantity() * v.getXpsprice();
		}
		cust.getCart().setGrandtotal(sum);
		cartDao.updateCart(cust.getCart());
		hsession.setAttribute("customer", cust);
		m.addAttribute("cartitems", cartitems);
		return "cartitem";
	}
	

	@RequestMapping("/reqMyOrders")
	public String displayMyOrders(@RequestParam (name="customerid") String customerid,Model m) {
		List<Orders> orders= orderDao.getcustomerorders(customerid);
		m.addAttribute("orders",orders);
		return "orders";
		
	}

	@RequestMapping("/reqOrderDetails")
	public String displayOrderDetails(@RequestParam(name="orderid")String orderid,Model m) {
		List<OrderDetails> orderdetails =orderDao.getOrderDetailsByOrderId(orderid);
		System.out.println(orderid);
		m.addAttribute("orderdetails", orderdetails);
		return "orderdetails";
	}
	
	@RequestMapping("/reqUserAddProductRatig")
	public String rateProductByCustomer(
			@RequestParam("pid")String pid,
			@RequestParam("rating")int rating,
			@RequestParam("oid")String oid,
			@RequestParam("ordetid")String ordetid
			) {
		productDao.setRating(pid,rating,ordetid);
		return "redirect:/reqOrderDetails?orderid="+oid;
	}
	@RequestMapping("/reqUserReviewProductPage")
	public String reqUserReviewProductPage(			
			@RequestParam("ordetid")String ordetid,
			Model m) {	
		
		OrderDetails ordetdata = orderDao.getOrderDetailsById(ordetid);
		m.addAttribute("ordetid", ordetid);
		Product prd = productDao.getProductById(ordetdata.getProductid());
		m.addAttribute("product", prd);
		return "product_review";
	}
	@RequestMapping("/reqSendProductReviewToDb")
	public String ProductReviewtoDb(@RequestParam("ordetid")String ordetid,
	@RequestParam("reviewtitle")String reviewtitle,
	@RequestParam("reviewbody")String reviewbody
	) {
		orderDao.addProductReview(ordetid,reviewtitle,reviewbody);
		OrderDetails ordetdata = orderDao.getOrderDetailsById(ordetid);
		return "redirect:/reqOrderDetails?orderid="+ordetdata.getOrderid();
	}
	
	
	
	
@RequestMapping("/reqLogout")
	public String displaylogout() {
		return "redirect:/reqSpringLoginPage?logout";

	
		
	}
	
}
