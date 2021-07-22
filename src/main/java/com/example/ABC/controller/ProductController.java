package com.example.ABC.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ABC.model.Product;
import com.example.ABC.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	//display list of products
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());
		return "index";
	}
	
	@GetMapping("/showAddProductForm")
	public String showAddProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		return "new_product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, Errors errors, Model model) {
		System.out.println("aaaaaa"+errors.hasErrors())	;
		if(errors.hasErrors()) {
			return "new_product";
		}else{
			productService.saveProduct(product);
			model.addAttribute("message","Added Successfully.....");
			return "redirect:/";
		}
	}
	
	@GetMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable ( value = "id") int id, Model model) {
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		return "update_product";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable (value = "id") int id) {
		this.productService.deleteProductById(id);
		return "redirect:/";
		
	}
}
