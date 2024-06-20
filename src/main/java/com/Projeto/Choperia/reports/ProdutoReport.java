package com.Projeto.Choperia.reports;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.Projeto.Choperia.dtos.ProdutoDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ProdutoReport {

private List<ProdutoDTO> lista;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public ProdutoReport(List<ProdutoDTO> lista){
		
		this.lista = lista;
		
	}
	
	public byte[] createPDF() {
		
		
		try {
			
			Document documento = new Document(PageSize.A4);
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			Image logo = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/skol.png")));
					
			documento.add(logo);
			
			
			Paragraph titulo = new Paragraph();
			Phrase phrase = new Phrase("Relatorio de Produto");
			titulo.add(phrase);
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			
			
			documento.add(titulo);
			
			for(ProdutoDTO produtoDTO: lista) {
				Paragraph dados = new Paragraph();
				dados.add("Codigo: "+produtoDTO.getIdProduto() + "\n");
				dados.add("Nome: "+produtoDTO.getNomeProduto() + "\n");
				dados.add("Preco: "+produtoDTO.getPrecoProduto() + "\n");
				dados.add("Fornecedor: "+produtoDTO.getFornecedorProduto() + "\n");
				dados.add("Validade: "+produtoDTO.getValidadeProduto() + "\n");
				
				
				dados.setSpacingAfter(5);
				documento.add(dados);
				
			}
			
					
			documento.close();
					
			return stream.toByteArray();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}


