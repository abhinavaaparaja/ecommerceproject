package com.mysite.controllers;

import java.util.List;

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
import com.mysite.dao.ProductDAOInt;
import com.mysite.dao.SupplierDAOInt;
import com.mysite.dao.XPSDAOInt;
import com.mysite.newmodel.Message;
import com.mysite.newmodel.Product;
import com.mysite.newmodel.Supplier;
import com.mysite.newmodel.VwCustUsers;
import com.mysite.newmodel.XPS;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAOInt supplierDao;

	@Autowired
	private XPSDAOInt xpsDao;
	@Autowired
	private ProductDAOInt productDao;
	
	@Autowired
	private CustomerDAOInt customerDao;

	@RequestMapping("/reqAdminSupplierPage")
	public String displaySupplierPage(@RequestParam(name = "supAddedS", required = false) String supAddedS,
			@RequestParam(name = "supAddedF", required = false) String supAddedF,
			@RequestParam(name = "supRemovedS", required = false) String supRemovedS,
			@RequestParam(name = "supRemovedF", required = false) String supRemovedF,
			@RequestParam(name = "supEditedS", required = false) String supEditedS,
			@RequestParam(name = "supEditedF", required = false) String supEditedF, Model m) {
		Message mesg;
		if (supAddedS != null) {
			mesg = new Message("INF", "Supplier added successfully...");
			m.addAttribute("message", mesg);
		} else if (supAddedF != null) {
			mesg = new Message("ERR", "Adding Supplier failed, Try again....");
			m.addAttribute("message", mesg);
		} else if (supRemovedS != null) {
			mesg = new Message("INF", "Supplier Removed successfully...");
			m.addAttribute("message", mesg);
		} else if (supRemovedF != null) {
			mesg = new Message("ERR", "Removing Supplier failed. Try again...");
			m.addAttribute("message", mesg);
		} else if (supEditedS != null) {
			mesg = new Message("INF", "Supplier Edited successfully...");
			m.addAttribute("message", mesg);
		} else if (supEditedF != null) {
			mesg = new Message("ERR", "Editing Supplier failed. Try again...");
			m.addAttribute("message", mesg);
		} else {
			mesg = null;
		}
		List<Supplier> supplier = supplierDao.getAllSuppliers();
		m.addAttribute("supplier", supplier);
		System.out.print(supplier);

		Supplier sup = new Supplier();
		m.addAttribute("supplierObj", sup);
		return "suppliersadminpage";
	}

	@RequestMapping("/reqAdminSendSupplierDataToDB")
	public String addSupplierToDb(@Valid @ModelAttribute("supplierObj") Supplier s,BindingResult result, HttpSession hsession,Model m) {
		if(result.hasErrors()) {
			m.addAttribute("suppliers", s);
			return "suppliersadminpage";
		}
		
		s.setIsavaliable(true);
		// supplierDao.addSupplier(s);
		boolean result1 = supplierDao.addSupplier(s);
		if (result1 == true) {
			return "redirect:/reqAdminSupplierPage?supAddedS";
		} else {
			return "redirect:/reqAdminSupplierPage?supAddedF";
		}

		// return "redirect:/reqAdminSupplierPage";
	}

	@RequestMapping("/reqAdminEditSupplier") // to display product edit page
	public String getSupplierForEdit(@RequestParam("sid") String sid, Model m) {
		List<Supplier> supplier = supplierDao.getAllSuppliers();
		m.addAttribute("suppliers", supplier);
		
		Supplier s = supplierDao.getSupplierById(sid);
		m.addAttribute("supplier", s);
		return "editsupplierpage";
	}

	@RequestMapping("/reqAdminUpdateSupplier")
	public String updateSupplierToDB(@ModelAttribute("supplier") Supplier sp) {
		// supplierDao.updateSupplier(sp);
		// return "redirect:/reqAdminSupplierPage";
		boolean result = supplierDao.updateSupplier(sp);
		if (result == true) {
			return "redirect:/reqAdminSupplierPage?supEditedS";
		} else {
			return "redirect:/reqAdminSupplierPage?supEditedF";
		}

	}

	@RequestMapping("/reqAdminDeleteSupplier")
	public String adminSupplierDelete(@RequestParam(name = "sid") String s) {
		// supplierDao.deleteSupplier(s);
		// return "redirect:/reqAdminSupplierPage";
		boolean result = supplierDao.deleteSupplier(s);
		if (result == true) {
			return "redirect:/reqAdminSupplierPage?supRemovedS";
		} else {
			return "redirect:/reqAdminSupplierPage?supRemovedF";
		}
	}

	@RequestMapping("/reqAdminXPSPage")
public String displayXPSPage(@RequestParam(name ="xpsAddedS", required=false)String xpsAddedS,
		@RequestParam(name ="xpsAddedF", required=false)String xpsAddedF,
		@RequestParam(name ="xpsRemovedS", required=false)String xpsRemovedS,
		@RequestParam(name ="xpsRemovedF", required=false)String xpsRemovedF,
		@RequestParam(name ="xpsEditedS", required=false)String xpsEditedS,
		@RequestParam(name ="xpsEditedF", required=false)String xpsEditedF,
		Model m) {
	Message mesg;
	if(xpsAddedS!=null) {
		mesg=new Message("INF","XPS Record added successfully");
		m.addAttribute("message", mesg);
	}
	else if(xpsAddedF!=null) {
		mesg=new Message("ERR","XPS Record not added. Try again...");
		m.addAttribute("message", mesg);
	}
	else if(xpsRemovedS!=null) {
		mesg=new Message("INF","XPS Record removed successfully");
		m.addAttribute("message", mesg);
	}
	else if(xpsEditedS!=null) {
		mesg=new Message("INF","XPS Record edited successfully");
		m.addAttribute("message", mesg);
	}
	else {
		mesg=null;
	}
		List<Supplier> supplier = supplierDao.getAllSuppliers();
		m.addAttribute("supplier", supplier);
		
		List<XPS> xps = xpsDao.getAllXPS();
		m.addAttribute("xps", xps);		
		return  "xps_page";
	 }
	@RequestMapping("/reqAdminGetProudctsForSupplierXPS")
	public String getProductsForXPS(@RequestParam("supid") String supid, Model m) {
		List<Product> products = productDao.getProductsForSupplierForXMAP(supid);
		m.addAttribute("supid", supid);
		m.addAttribute("products", products);
		m.addAttribute("xpsObject", new XPS());
		return "addxpspage";
	}

	@RequestMapping("/reqAdminSendXPSToDb")
	public String addXPSToDB(@Valid @ModelAttribute("xpsObject") XPS xps,BindingResult result,Model m) {
		if(result.hasErrors()) {
			m.addAttribute("Xps", xps);
			return "editxpspage";
		}
		
		//xpsDao.addXps(xps);
		//return "redirect:/reqAdminXPSPage";
		
		
		boolean result1=xpsDao.addXps(xps);
		if(result1==true) {
			return "redirect:/reqAdminXPSPage?xpsAddedS";
		}
		else {
			return "redirect:/reqAdminXPSPage?xpsAddedF";
		}
	
	}

	@RequestMapping("/reqAdminEditXPS")
	public String getXPSForEdit(@RequestParam("xpsid") String xpsid, Model m) {
		List<XPS> xps = xpsDao.getAllXPS();
		m.addAttribute("xps", xps);		
		
		XPS xps1 = xpsDao.getXPSById(xpsid);
		m.addAttribute("Xps", xps1);
		return "editxpspage";
	}

	@RequestMapping("/reqAdminUpdateXPS")
	public String updateXPSToDB(@Valid @ModelAttribute("xps") XPS xps) {
		
		
		
		//xpsDao.updateXPS(xps);
		//return "redirect:/reqAdminXPSPage";
		boolean result1 = xpsDao.updateXPS(xps);
		if (result1 == true) {
			return "redirect:/reqAdminXPSPage?xpsRemovedS";
		} else {
			return "redirect:/reqAdminXPSPage?xpsRemovedF";
		}
	}
	
	@RequestMapping("/reqAdminDeleteXPS")
	public String adminXPSDelete(@RequestParam(name = "xpsid") String xps) {
		//xpsDao.deleteXPS(xps);
		//return "redirect:/reqAdminXPSPage";
		boolean result = xpsDao.deleteXPS(xps);
		if (result == true) {
			return "redirect:/reqAdminXPSPage?xpsRemovedS";
		} else {
			return "redirect:/reqAdminSupplierPage?xpsRemovedF";
		}
	}
	
	
	
	@RequestMapping("/reqAdminUsersPage")
	public String displayUsersForAdmin(
			@RequestParam(name="disableCustS", required=false)String  disableCustS,
			@RequestParam(name="disableCustF", required=false)String  disableCustF,
			@RequestParam(name="enableCustS", required=false)String  enableCustS,
			@RequestParam(name="enableCustF",  required=false)String  enableCustF,			
			Model m) {
		Message mesg;
		if(disableCustS!=null) {
			mesg=new Message("INF","Customer Disabled successfully");
			m.addAttribute("message", mesg);
		}
		else if(disableCustF!=null) {
			mesg=new Message("ERR","Disabling Customer failed. Try again...");
			m.addAttribute("message", mesg);
		}
		else if(enableCustS!=null) {
			mesg=new Message("INF","Customer Enabled successfully");
			m.addAttribute("message", mesg);
		}
		else if(enableCustF!=null) {
			mesg=new Message("INF","Enabling Customer failed. Try agail...");
			m.addAttribute("message", mesg);
		}
		else {
			mesg=null;
		}
		
		List<VwCustUsers> custusers = customerDao.getCustUsers();
		m.addAttribute("custusers", custusers);
		
		
		return "userspageadmin";
	}
	
	@RequestMapping("/reqAdminDisableCustomer")
	public String disableUser(@RequestParam("custid")String custid) {
		boolean result=customerDao.disableCustomer(custid);
		if(result==true) {
			return "redirect:/reqAdminUsersPage?disableCustS";
		}
		else {
			return "redirect:/reqAdminUsersPage?disableCustF";
		}		
	}
	
	@RequestMapping("/reqAdminEnableCustomer")
	public String enableUser(@RequestParam("custid")String custid) {
		boolean result=customerDao.enableCustomer(custid);
		if(result==true) {
			return "redirect:/reqAdminUsersPage?enableCustS";
		}
		else {
			return "redirect:/reqAdminUsersPage?enableCustF";
		}		
	}
	
	
	
}

