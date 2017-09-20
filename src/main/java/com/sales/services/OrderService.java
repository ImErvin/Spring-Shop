package com.sales.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.OrderException;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.CustomerRepo;
import com.sales.repositories.OrderRepo;
import com.sales.repositories.ProductRepo;

@Service("OrderService")
public class OrderService  {
	
	@Autowired
	private OrderRepo oRepo;
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired 
	private ProductRepo pRepo;
	
	
	public Order save(Order o) throws OrderException{
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		o.setOrderDate(date);
		String errorMessage = "";
		boolean error = false;
		
		Product p = pRepo.findOne(o.getProd().getpId());
		Customer c = cRepo.findOne(o.getCust().getcId());
		
		if(p == null){
			errorMessage += "No such product: " + o.getProd().getpId() + " ";
			error = true;
		}
		else if(p.getQtyInStock() < o.getQty()){
			errorMessage += "Quantity too large: Product stock = "+ p.getQtyInStock() + " ";
			error = true;
		}
		
		if(c == null){
			errorMessage += "No such customer: "+ o.getCust().getcId() + " ";
			error = true;
		}
		
		if(error == true){
			throw new OrderException(errorMessage, o.getProd().getpId(), o.getCust().getcId(), o.getQty());
		}else{
			o.getProd().setpDesc(p.getpDesc());
			p.setQtyInStock(p.getQtyInStock() - o.getQty());
			o.getCust().setcName(c.getcName());		
			return oRepo.save(o);
		}
		
	}
	
	public ArrayList<Order> getOrders(){
		return(ArrayList<Order>) oRepo.findAll();
	}
}