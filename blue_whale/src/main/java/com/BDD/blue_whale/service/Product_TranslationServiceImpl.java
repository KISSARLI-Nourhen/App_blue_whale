package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Product_translation;
import com.BDD.blue_whale.repositories.Product_translationRepository;

@Service
@Transactional
public class Product_TranslationServiceImpl implements Product_translationService{

	@Autowired
	private Product_translationRepository product_translationRepository;
	
	
	@Override
	public void addProduct_translation(Product_translation product_translation) {
		product_translationRepository.save(product_translation);
		
	}

	@Override
	public List<Product_translation> listproduct_translation() {
		
		return product_translationRepository.findAll();
	}

	@Override
	public Optional<Product_translation> getProduct_translationById(long product_translations_id) {
		
		return product_translationRepository.findById(product_translations_id);
	}

	@Override
	public void deleteProduct_translation(long product_translations_id) {
		
		product_translationRepository.deleteById(product_translations_id);
	}

	@Override
	public void updateProduct_translation(Product_translation product_translation) {
		product_translationRepository.save(product_translation);
		
	}

	/*@Override
	public List<Product_translation> findByProduct(long product_id) {
		
		return product_translationRepository.findByProduct_product_id(product_id);
	}*/
	
	
	
	
}
