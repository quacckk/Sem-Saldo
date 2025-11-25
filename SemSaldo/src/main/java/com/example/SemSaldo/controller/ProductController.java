package com.example.SemSaldo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SemSaldo.model.Product;
import com.example.SemSaldo.service.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/semsaldo")
public class ProductController {
	
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> list(){
		return productService.getAll();
	}
	@PostMapping
	public Product add(@RequestBody Product product) {
		System.out.println("Recebido -" + product);
		return productService.save(product);
	}

}
