package com.mysite.controllers;



import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.dao.CustomerDAOInt;
import com.mysite.dao.ViewDAOInt;
import com.mysite.newmodel.BillingAddress;
import com.mysite.newmodel.Cart;

import com.mysite.newmodel.Customer;
import com.mysite.newmodel.Message;
import com.mysite.newmodel.ShippingAddress;

import com.mysite.newmodel.UserDetails;


@Controller
public class HomeController {
	@Autowired                                                                                                                                                                                                                                                                                     
	private CustomerDAOInt customerDao;
	
	@Autowired
	private ViewDAOInt viewDao;
	
	@Autowired
	private EmailService emailservice;
	
	@RequestMapping(value= {"/","/reqHomePage"})
	public String displayHomepage(Model m) {

		List<com.mysite.newmodel.VW_P_XPS_S> view = viewDao.getBestPriceVW_P_XPS_S();
		m.addAttribute("views", view);
		
		return "home";
	}

	@RequestMapping("/reqSignUpPage")
	public String displaySignUppage(Model m) {
		Customer cust = new Customer();
		cust.setUserDetails(new UserDetails());
		cust.setBillingAddress(new BillingAddress());
		cust.setShippingAddress(new ShippingAddress());
		cust.setCart(new Cart());
		System.out.print("\nCust object before signup : " + cust.getUserDetails());
		m.addAttribute("customer", cust);
		List<com.mysite.newmodel.VW_P_XPS_S> view = viewDao.getBestPriceVW_P_XPS_S();
		m.addAttribute("views", view);
		
		
		return "signup";
	}
	

	@RequestMapping("/reqSendSignupToDB")
	public String addCustomerTODBSpring(@Valid@ModelAttribute("customer") Customer cust,BindingResult result,Model m) throws MessagingException {
		
		if(result.hasErrors()) {
			m.addAttribute("customer", cust);
			return "signup";
		}
		System.out.print("\nCust object after signup : "  + cust.getUserDetails());
		cust.getUserDetails().setRole("ROLE_USER");
		cust.getUserDetails().setEnabled(true);

		cust.getBillingAddress().setHouseno(cust.getShippingAddress().getHouseno());
		cust.getBillingAddress().setStreet(cust.getShippingAddress().getStreet());
		cust.getBillingAddress().setArea(cust.getShippingAddress().getArea());
		cust.getBillingAddress().setCity(cust.getShippingAddress().getCity());
		cust.getBillingAddress().setState(cust.getShippingAddress().getState());
		cust.getBillingAddress().setCountry(cust.getShippingAddress().getCountry());
		cust.getBillingAddress().setPincode(cust.getShippingAddress().getPincode());
		
		
		String userid=null;
		

		userid=customerDao.addCustomer(cust);
		if(userid!=null) {
			//m.addAttribute("userid",userid);
			String subject="Signup Success:: justclick.com";
			String body="Dear "+cust.getCustname() +",\n Welcome to justclick.com";
			body= body +"\n\n Your account has created successfully...... thank you\n your userid: "+userid+ "\n use this userid to login to our website";
			body= body +"\n\n Regards,\n justclick Team";
			emailservice.send(cust.getCustemailid(),subject,body);
		
			String req = "redirect:/reqSpringLoginPage?userid="+userid;
			return req;
		}
		else {
			return "redirect:/reqSignUpPage";
		}	
		}	
	
	
	@RequestMapping("/reqForgotPassword")
	public String forgotPassword(@RequestParam("userid")String userid) throws MessagingException {
		Customer cust = customerDao.getCustomerById(userid);
				System.out.println(cust);
		
		String emailid = cust.getCustemailid();
		
		
		String subject="Password Recovery :: JustClick.com";
		String body= "Dear " + cust.getCustname() +",\nWelcome to JustCLick.com";
		body = body + "\nUser ID :  " + cust.getCustomerid();
		body = body + "\nPassword : " + cust.getUserDetails().getPassword();
		body = body + "\n\n\nRegards,\nJustClick Team";
		emailservice.send(cust.getCustemailid(), subject, body);	
		
		return  "redirect:/reqSpringLoginPage";
	}
	

	
	
	}

