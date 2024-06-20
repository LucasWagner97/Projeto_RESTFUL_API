package com.Projeto.Choperia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projeto.Choperia.dtos.ProdutoDTO;
import com.Projeto.Choperia.entities.Produto;
import com.Projeto.Choperia.reports.ProdutoReport;
import com.Projeto.Choperia.repositories.ProdutoRepository;

    @Service
	public class ProdutoService {
		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		public void salvar(ProdutoDTO produtoDTO) throws Exception {
			Produto produto = new Produto ();
			produto.setId(produtoDTO.getIdProduto());
			produto.setNome(produtoDTO.getNomeProduto());
			produto.setPreco(produtoDTO.getPrecoProduto());
			produto.setFornecedor(produtoDTO.getFornecedorProduto());
			produto.setValidade(produtoDTO.getValidadeProduto());
			produto.setImagem(produtoDTO.getImagemProduto());
			produtoRepository.save(produto);
		}
			
			public List<ProdutoDTO> listarTodos(){
				List<Produto> lista = produtoRepository.findAll();
				List<ProdutoDTO> listaDTO = new ArrayList<>();
				
				for (Produto produto: lista) {
					ProdutoDTO produtoDTO = new ProdutoDTO();
					produtoDTO.setIdProduto(produto.getId());
					produtoDTO.setNomeProduto(produto.getNome());
					produtoDTO.setPrecoProduto(produto.getPreco());
					produtoDTO.setFornecedorProduto(produto.getFornecedor());
					produtoDTO.setValidadeProduto(produto.getValidade());
					produtoDTO.setImagemProduto(produto.getImagem());
					listaDTO.add(produtoDTO);
				}
				return listaDTO;
			}
					public void excluir (Long id) throws Exception{
						Produto produto = produtoRepository.findById(id).get();
						if(produto != null) {
							produtoRepository.delete(produto);
			
	}
		}

					public byte[] gerarRelatorio() {
						return new ProdutoReport(listarTodos()).createPDF();
					}
	}