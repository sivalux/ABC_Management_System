package com.example.ABC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ABC.model.Product;
import com.example.ABC.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		this.productRepository.save(product);	
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if(optional.isPresent()) {
			product = optional.get();
		}else {
			throw new RuntimeException("Product not found for id ::"+id);
		}
		return product;
	}

	@Override
	public void deleteProductById(int id) {
		this.productRepository.deleteById(id);
		
	}

}
