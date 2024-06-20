package com.Projeto.Choperia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.Choperia.dtos.ProdutoDTO;
import com.Projeto.Choperia.enums.MensagemEnum;
import com.Projeto.Choperia.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping("/produto")
@Tag(name = "Produtos", description = "Choperia API")
public class ProdutoController {
	
	
	@Autowired
     private ProdutoService produtoService;
	
	@GetMapping("/listar")
	public List<ProdutoDTO> listarTodos(){
		return produtoService.listarTodos();
		
	}
	
	@PostMapping("/salvar")
	@Operation(summary = "", description = "Salvar dados do produto na base de bancos.")
	@ApiResponse(responseCode = "200", description = "Sucesso")
    @ApiResponse(responseCode = "404", description = "Não encontrado")

	
	public ResponseEntity salvar(@RequestBody ProdutoDTO produtoDTO) {
		try {
			produtoService.salvar(produtoDTO);
			return ResponseEntity.ok(MensagemEnum.CADASTRADO.getDescricao());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		 }
		}
		@PostMapping("/excluir/{id}")
		@Operation(summary = "", description = "Excluir dados do pedido")
	    @ApiResponse(responseCode = "200", description = "Sucesso")
	    @ApiResponse(responseCode = "404", description = "Não encontrado")


		public ResponseEntity excluir(@PathVariable Long id) {
			try {
				produtoService.excluir(id);
				return ResponseEntity.ok(MensagemEnum.EXCLUIDO.getDescricao());
			}catch (Exception e) {
				 return ResponseEntity.badRequest().body(e.getMessage());
			}
		}

		@GetMapping("/gerar/relatorio")
		@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
		public ResponseEntity gerarRelatorio() {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData(
					"attachment", "produto.pdf");
			return ResponseEntity.ok().headers(headers)
					.body(produtoService.gerarRelatorio());
		}
		
		@GetMapping("/gerar/relatorio/{id}")
		@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
		public ResponseEntity gerarRelatorio(@PathVariable Long id) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData(
					"attachment", "produto.pdf");
			return ResponseEntity.ok().headers(headers)
					.body(produtoService.gerarRelatorio());

		


	}

}
