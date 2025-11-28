package com.example.SemSaldo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
	private String situacao;
	private LocalDate dataRegistro;

	
	public Product(){}
	
	public Product(Long id , String nome, String descricao, Integer gtin, Integer qtd, String endereco, String situacao, LocalDate date, LocalDate dataRegistro) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.gtin = gtin;
		this.qtd = qtd;
		this.endereco = endereco;
		this.situacao = situacao;
		this.dataRegistro = dataRegistro;
		
		
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	
	@PrePersist
	public void prePesist() {
		this.dataRegistro = LocalDate.now();
	}

	
	
}
