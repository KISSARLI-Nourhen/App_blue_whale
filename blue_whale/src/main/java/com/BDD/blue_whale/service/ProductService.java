package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Product;

@Service
public interface ProductService {
	
	public void addProduct(Product product);
	
	public List<Product> listproduct();
	
	public Optional<Product> getProductById(long product_id);
	
	public void deleteProduct(long product_id);
	
	public void updateProduct(Product product);
}
