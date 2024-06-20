package com.Projeto.Choperia.reports;

import java.io.ByteArrayOutputStream;

import org.apache.commons.io.IOUtils;

import com.Projeto.Choperia.dtos.ProdutoDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class DadosProdutoReport {
	
private ProdutoDTO produtoDTO;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public DadosProdutoReport(ProdutoDTO produtoDTO){
		
		this.produtoDTO = produtoDTO;
		
	}
	
	public byte[] createPDF() {
		
		
		try {
			
			Document documento = new Document(PageSize.A4);
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			Image imagem = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/"+produtoDTO.getImagemProduto())));
			imagem.setAlignment(Element.ALIGN_CENTER);
					
			documento.add(imagem);
			
			
			
				Paragraph dados = new Paragraph();
				dados.add("Codigo: "+produtoDTO.getIdProduto() + "\n");
				dados.add("Nome: "+produtoDTO.getNomeProduto() + "\n");
				dados.add("Preco: "+produtoDTO.getPrecoProduto() + "\n");
				dados.add("Fornecedor: "+produtoDTO.getFornecedorProduto() + "\n");
				dados.add("Validade: "+produtoDTO.getValidadeProduto() + "\n");
				dados.setSpacingAfter(5);
				documento.add(dados);
				
					
			documento.close();
					
			return stream.toByteArray();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}






	


