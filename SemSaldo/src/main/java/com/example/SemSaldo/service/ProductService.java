package com.example.SemSaldo.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	public byte[] gerarExcelProdutos() throws Exception{
		List<Product> produtos = repository.findAll();
		
		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Produtos");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Nome");
		header.createCell(1).setCellValue("Descrição");
		header.createCell(2).setCellValue("Gtin");
		header.createCell(3).setCellValue("Quantidade em Cx");
		header.createCell(4).setCellValue("Endereço");
		header.createCell(5).setCellValue("Situação do produto");
		header.createCell(6).setCellValue("Data de Registro");
		
		int i = 1;
		for (Product p: produtos) {
			Row row = sheet.createRow(i++);
			row.createCell(0).setCellValue(p.getNome());
			row.createCell(1).setCellValue(p.getDescricao());
			row.createCell(2).setCellValue(p.getGtin());
			row.createCell(3).setCellValue(p.getQtd());
			row.createCell(4).setCellValue(p.getEndereco());
			row.createCell(5).setCellValue(p.getSituacao());
			row.createCell(6).setCellValue(p.getDataRegistro());
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		workbook.close();
		return out.toByteArray();
	}

}
