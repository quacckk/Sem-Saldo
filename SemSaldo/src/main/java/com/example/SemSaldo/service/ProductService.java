package com.example.SemSaldo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.SemSaldo.model.Product;
import com.example.SemSaldo.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	public List<Product> getAll(){return repository.findAll();}
	public Product save(Product product) {return repository.save(product);}

}
