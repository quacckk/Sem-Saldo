package com.example.SemSaldo.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/excel")
	public ResponseEntity<byte[]> gerarExcel() throws Exception{
		
		byte[] excel = productService.gerarExcelProdutos();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=auditoria_dos_produtos.xlsx");
		headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		
		return ResponseEntity.ok().headers(headers).body(excel);
		
	}
	@PostMapping
	public Product add(@RequestBody Product product) {
		System.out.println("Recebido -" + product);
		return productService.save(product);
	}

}
