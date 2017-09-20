package com.sales.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepo;

@Service("CustomerService")
public class CustomerService {

	@Autowired
	private CustomerRepo cRepo;
	
	public Customer save(Customer c){
		return cRepo.save(c);		
	}
	
	public ArrayList<Customer> getCustomers(){
		return (ArrayList<Customer>) cRepo.findAll();
	}
}