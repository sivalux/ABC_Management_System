package com.example.ABC.service;

import java.util.List;

import com.example.ABC.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductById(int id);
	void deleteProductById(int id);
}
