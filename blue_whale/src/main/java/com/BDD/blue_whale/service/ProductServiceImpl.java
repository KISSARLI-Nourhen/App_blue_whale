package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.dto.ProductDTO;
import com.BDD.blue_whale.entities.Product;
import com.BDD.blue_whale.repositories.ProductRepository;
import com.BDD.blue_whale.repositories.Product_translationRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private Product_translationRepository product_translationRepository;
	
	@Override
	public void addProduct(Product product) {
		ProductRepository.save(product);	
	}

	@Override
	public List<Product> listproduct() {
		
		return ProductRepository.findAll();
	}
	

	@Override
	public Optional<Product> getProductById(long product_id) {
		
		return ProductRepository.findById(product_id);
	}

	@Override
	public void deleteProduct(long product_id) {
		ProductRepository.deleteById(product_id);
		
	}

	@Override
	public void updateProduct(Product product) {
		ProductRepository.save(product);
		
	}

	
	

}
