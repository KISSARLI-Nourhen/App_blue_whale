package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Product_translation;

@Service
public interface Product_translationService {

	public void addProduct_translation(Product_translation product_translations);
	
	public List<Product_translation> listproduct_translation();
	
	public Optional<Product_translation> getProduct_translationById(long product_translations_id);
	
	public void deleteProduct_translation(long product_translations_id);
	
	/*public List<Product_translation> findByProduct(long product_id);*/
	
	public void updateProduct_translation(Product_translation product_translation);
}
