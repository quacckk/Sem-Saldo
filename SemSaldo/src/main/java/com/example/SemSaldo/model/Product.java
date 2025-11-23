package com.example.SemSaldo.model;

import jakarta.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Nome;
	private String Descricao;
	private Integer Gtin;
	private Integer Qtd;
	private String Endereco;
	
	public Product(Long id , String nome, String descricao, Integer gtin, Integer qtd, String endereco) {
		
		this.id = id;
		this.setName(nome);
		this.setDescricao(descricao);
		this.setGtin(gtin);
		this.setQtd(qtd);
		this.setEndereco(endereco);
	}

	public String getName() {
		return Nome;
	}

	public void setName(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Integer getGtin() {
		return Gtin;
	}

	public void setGtin(Integer gtin) {
		Gtin = gtin;
	}

	public Integer getQtd() {
		return Qtd;
	}

	public void setQtd(Integer qtd) {
		Qtd = qtd;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}


}
