package com.example.SemSaldo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SemSaldo.model.Product;
import com.example.SemSaldo.service.ProductService;

@RestController
@RequestMapping("/api/semsaldo")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> list(){
		return service.getAll();
	}
	@PostMapping
	public Product add(@RequestBody Product product) {
		return service.save(product);
	}

}
