package com.mfi.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mfi.formmodel.CustomerForm;
import com.mfi.model.Customer;
import com.mfi.service.CustomerService;
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService crmService;	
	@PostMapping("/register")
	public String addCrm(@ModelAttribute("crmBean") @Valid CustomerForm crm, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("crmBean",crm);
            return "customer/MFI_CRM_01";
        }
        String nrc=crm.getNrc();
        Date dob=Date.valueOf(crm.getDob());
        String customerCode=null;
        LocalDate now = LocalDate.now();
		Date createdDate = Date.valueOf(now);
        List<Customer> crmlist= crmService.selectAll();
        for(Customer cus:crmlist) {
        	if(cus.getNrc().equals(nrc)) {
        		model.addAttribute("message","Customer already exist!!!");
        		model.addAttribute("crmBean",crm);
        		return "customer/MFI_CRM_01";
        	}
        }
		if(crmlist.isEmpty()) {
			customerCode = String.format("CRM0001");
//			crm.setCustomerCode(d);
//			crm.setCreatedDate(createdDate);
//			crmService.save(crm);
		
		}
		else
		{
			int i = crmlist.size();
			int gid = i+1;
			customerCode = String.format("CRM%04d", gid);
//			crm.setCustomerCode(id);
//			crm.setCreatedDate(date);
//			crmService.save(crm);
//			return "redirect:/customerSearch";
		}
		
		Customer customer=new Customer();
		customer.setCustomerCode(customerCode);
		customer.setName(crm.getName());
		customer.setNrc(crm.getNrc());
		customer.setPhone(crm.getPhone());
		customer.setEmail(crm.getEmail());
		customer.setDob(dob);
		customer.setGender(crm.getGender());
		customer.setAddress(crm.getAddress());
		customer.setCurrentJob(crm.getCurrentJob());
		customer.setPositon(crm.getPositon());
		customer.setCompanyName(crm.getCompanyName());
		customer.setMonthlyIncome(crm.getMonthlyIncome());
		customer.setCreatedUser(1);
		customer.setCreatedDate(createdDate);
		customer.setUpdateUser(1);
		customer.setUpdateDate(null);
		crmService.save(customer);
		return "redirect:/customerSearch";
		
		
    }
	
		@RequestMapping("/crmSearch")
		public String searchAll(@ModelAttribute("crmBean") Customer crm, Model model ){
				
		
			String query=crm.getName()==null?crm.getNrc():crm.getName();
			if(query.equals("")) {
				List<Customer> crmList = crmService.selectAll();
				model.addAttribute("crmList", crmList);
				//model.addAttribute("mesg", message);
				return "customer/MFI_CRM_02";
			}else {
				List<Customer> crmList = crmService.searchNameOrNrc(query);
				model.addAttribute("crmList", crmList);
				//model.addAttribute("mesg", message);
				return "customer/MFI_CRM_02";
			}
			
	
			
		}
		@GetMapping("/customerEdit/{id}")
		public String customerEdit(@PathVariable("id")String id,Model model) {
			
			Customer c1=crmService.selectOne(id);
			
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			String dob = c1.getDob().toString();  
			CustomerForm crmEdit=new CustomerForm();
			crmEdit.setCustomerCode(id);
			crmEdit.setName(c1.getName());
			crmEdit.setNrc(c1.getNrc());
			crmEdit.setPhone(c1.getPhone());
			crmEdit.setEmail(c1.getEmail());
			crmEdit.setDob(dob);
			crmEdit.setGender(c1.getGender());
			crmEdit.setAddress(c1.getAddress());
			crmEdit.setCurrentJob(c1.getCurrentJob());
			crmEdit.setPositon(c1.getPositon());
			crmEdit.setCompanyName(c1.getCompanyName());
			crmEdit.setMonthlyIncome(c1.getMonthlyIncome());
			crmEdit.setCreatedUser(c1.getCreatedUser());
			crmEdit.setCreatedDate(c1.getCreatedDate());
			crmEdit.setUpdateUser(0);
			crmEdit.setUpdateDate(null);
			model.addAttribute("crmEdit", crmEdit);
			return "customer/MFI_CRM_03";
		}
		@PostMapping("/customerEdit/{id}")
		public String customerUpdate(@ModelAttribute("crmEdit") @Valid CustomerForm crm, BindingResult result, @PathVariable("id")String id,Model model,RedirectAttributes redirectAttrs) {
			if(result.hasErrors()) {
				model.addAttribute("crmEdit", crm);
				return "customer/MFI_CRM_03";
			}
			Date dob=Date.valueOf(crm.getDob());
			
			LocalDate now = LocalDate.now();
			Date updatedDate = Date.valueOf(now);
			
			Customer customer=crmService.selectOne(id);
			customer.setName(crm.getName());
			customer.setNrc(crm.getNrc());
			customer.setPhone(crm.getPhone());
			customer.setEmail(crm.getEmail());
			customer.setDob(dob);
			customer.setGender(crm.getGender());
			customer.setAddress(crm.getAddress());
			customer.setCurrentJob(crm.getCurrentJob());
			customer.setPositon(crm.getPositon());
			customer.setCompanyName(crm.getCompanyName());
			customer.setMonthlyIncome(crm.getMonthlyIncome());
			customer.setCreatedUser(1);
			customer.setCreatedDate(crm.getCreatedDate());
			customer.setUpdateUser(1);
			customer.setUpdateDate(updatedDate);
			crmService.update(customer);
			String mesg="Update Successfully!!!";
			return "redirect:/customerSearch?mesg="+mesg;
		}
		@GetMapping("/customerDetail/{id}")
		public String viewDetail(@PathVariable("id")String id,Model model) {
			model.addAttribute("crmDetail",crmService.selectOne(id));
//			return "redirect:/customerViewDetail";
			return "customer/MFI_CRM_04";
		}
		
		
		 
		
}
