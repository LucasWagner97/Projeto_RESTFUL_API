package com.Projeto.Choperia.dtos;

public class ProdutoDTO {
	
	private Long idProduto;
	private String nomeProduto;
	private Double precoProduto;
	private String fornecedorProduto;
	private Integer validadeProduto;
	private String imagemProduto;
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public String getFornecedorProduto() {
		return fornecedorProduto;
	}
	public void setFornecedorProduto(String fornecedorProduto) {
		this.fornecedorProduto = fornecedorProduto;
	}
	public Integer getValidadeProduto() {
		return validadeProduto;
	}
	public void setValidadeProduto(Integer validadeProduto) {
		this.validadeProduto = validadeProduto;
	}
	public String getImagemProduto() {
		return imagemProduto;
	}
	public void setImagemProduto(String imagemProduto) {
		this.imagemProduto = imagemProduto;
	}
	
	
	
	

}
