package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String showCustomer(Model m){
		
		ArrayList<Customer> customers = cService.getCustomers();
		m.addAttribute("customers", customers);
		return "showCustomers";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getCustomer(@ModelAttribute("customer") Customer c, HttpServletRequest http){
		
		return "addCustomer";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("customer") Customer c, BindingResult result, HttpServletRequest http, Model m){	
		
		if (result.hasErrors()) {
			
			return "addCustomer";
		}
		
		else {
			cService.save(c);
			ArrayList<Customer> customers = cService.getCustomers();
			m.addAttribute("customers", customers);
			return "showCustomers";
		}
	}
}
