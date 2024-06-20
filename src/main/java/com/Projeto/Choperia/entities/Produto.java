package com.Projeto.Choperia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column (name = "nome", length = 100, nullable = false)
	private String nome;
	@Column (name = "preco", length = 100, nullable = false)
	private Double preco;
	@Column (name = "fornecedor", length = 100, nullable = false)
	private String fornecedor;
	@Column (name = "validade", length = 100, nullable = false)
	private Integer validade;
	@Column (name = "imagem", length = 30, nullable = false)
	private String imagem;
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
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Integer getValidade() {
		return validade;
	}
	public void setValidade(Integer validade) {
		this.validade = validade;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
	

}
