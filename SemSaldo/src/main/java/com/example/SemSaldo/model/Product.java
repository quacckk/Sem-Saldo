package com.example.SemSaldo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Integer gtin;
	private Integer qtd;
	private String endereco;

	
	public Product(){}
	
	public Product(Long id , String nome, String descricao, Integer gtin, Integer qtd, String endereco) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.gtin = gtin;
		this.qtd = qtd;
		this.endereco = endereco;
		
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getGtin() {
		return gtin;
	}

	public void setGtin(Integer gtin) {
		this.gtin = gtin;
	}
	
	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
