package com.sales.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
@SessionAttributes(value = {"Customer", "Order", "Product"})
public class MainController {

	public List<String> c = new ArrayList<String>();
	
	public List<String> o = new ArrayList<String>();
	
	public List<String> p = new ArrayList<String>();
	
	@Autowired
	@Qualifier("CustomerService")
	private CustomerService cService;
	
	@Qualifier("OrderService")
	private OrderService oService;
	
	@Qualifier("ProductService")
	private ProductService pService;
	
}
