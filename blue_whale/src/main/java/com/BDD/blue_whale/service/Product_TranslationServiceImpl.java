package com.BDD.blue_whale.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.dto.ProductDTO;
import com.BDD.blue_whale.dto.Product_translationDTO;
import com.BDD.blue_whale.dto.languageDTO;
import com.BDD.blue_whale.entities.Product;
import com.BDD.blue_whale.entities.Product_translation;
import com.BDD.blue_whale.entities.World_language;
import com.BDD.blue_whale.repositories.ProductRepository;
import com.BDD.blue_whale.repositories.Product_translationRepository;
import com.BDD.blue_whale.repositories.World_languagesRepository;

@Service
@Transactional
public class Product_TranslationServiceImpl implements Product_translationService{

	@Autowired
	private Product_translationRepository product_translationRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private World_languagesRepository world_languagesRepository;
	
	@Override
	public void addProduct_translation(Product_translation product_translation) {
		product_translationRepository.save(product_translation);
		
	}

	@Override
	public List<Product_translation> listproduct_translation() {
		
		return product_translationRepository.findAll();
	}

	@Override
	public Product_translation getProduct_translationById(long product_translations_id) {
		
		return product_translationRepository.findById(product_translations_id).orElse(null);
	}

	@Override
	public void deleteProduct_translation(long product_translations_id) {
		
		product_translationRepository.deleteById(product_translations_id);
	}

	@Override
	public void updateProduct_translation(Product_translation product_translation) {
		product_translationRepository.save(product_translation);
		
	}
	
	@Override
	public Product_translationDTO create(Product_translationDTO ptDTO) {
		
		Product_translation PT = new Product_translation();
		PT.setTranslation(ptDTO.getTranslation());
		
		ProductDTO prodDTO = ptDTO.getProduct();
		Product product = productRepository.findById( (long) prodDTO.getProduct_id()).orElse(null);;
		PT.setProduct(product);
		
		languageDTO languageDTO = ptDTO.getWorld_language();
		World_language l = world_languagesRepository.findById((String) languageDTO.getAlpha2()).orElse(null);
		System.out.println(l);
		PT.setWorld_language(l);
		
		product_translationRepository.save(PT);
		
		return ptDTO;
		
	}

	/*@Override
	public List<Product_translation> findByProduct(long product_id) {
		
		return product_translationRepository.findByProduct_product_id(product_id);
	}*/
	
	
	
	
}
