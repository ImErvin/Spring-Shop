package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepo;

@Service("ProductService")
public class ProductService {
	
	@Autowired
	private ProductRepo pRepo;
	
	public Product save(Product p){
		return pRepo.save(p);
	}
	
	public ArrayList<Product> getProducts(){
		return (ArrayList<Product>) pRepo.findAll();
	}
}