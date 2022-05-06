package com.CompraVenda.cv.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;
import com.CompraVenda.cv.repository.ProdutosRepository;
import com.CompraVenda.cv.repository.VendasRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



@Controller
public class IndexController {	
	@Autowired
	private ProdutosRepository pr;
	
	@Autowired
	private VendasRepository vr;
	
	@RequestMapping("/")
	public ModelAndView listaProdutosIndex() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Produtos> produtosIndex = pr.findAllByQuantidade();
		mv.addObject("produtosIndex", produtosIndex);
		return mv;
	}
	
	@RequestMapping("/login")
	public String abrirLogin() {
		//ModelAndView mv = new ModelAndView("index");
		return "login";
	}
	
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/funcionarios";
		}
		else if (request.isUserInRole("ROLE_VENDEDOR")) {
			return "redirect:/clientes";
		}
			return "redirect:/produtos";

	}
	
	
	@RequestMapping("/relatorio-produtos")
	public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ModelAndView mv = new ModelAndView("index");
		Document documento = new Document();
		try {
			response.setContentType("aplication/pdf");
			response.addHeader("Content-Disposition", "Inline; filename="+"produtos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Produtos em Estoque"));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(6);
			
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Descrição"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Preco Compra"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Preco Venda"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Quantidade Disponível"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Liberado"));
			
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			
			Iterable<Produtos> produtos = pr.findAll();
			for(Produtos lista:produtos) {
				tabela.addCell(lista.getNome_produto());
				tabela.addCell(lista.getDescricao());
				tabela.addCell(String.valueOf(lista.getPreco_compra()));
				tabela.addCell(String.valueOf(lista.getPreco_venda()));
				tabela.addCell(String.valueOf(lista.getQuantidade_disponivel()));
				tabela.addCell(lista.getLiberado_venda());				
			}
			
			documento.add(tabela);
			documento.close();
			
		} catch(Exception e) {
			System.out.println(e);
			documento.close();
		}
		
	}
	
	
	
	@RequestMapping("/relatorio-vendas")
	public void gerarRelatorioVendas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ModelAndView mv = new ModelAndView("index");
		Date data = new Date();
		String dataAtual = new SimpleDateFormat("yyyy-MM-dd").format(data);
		Long total;
		
		Document documento = new Document();
		try {
			response.setContentType("aplication/pdf");
			response.addHeader("Content-Disposition", "Inline; filename="+"vendas.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Vendas"));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(3);
			
			PdfPCell col1 = new PdfPCell(new Paragraph("Quantidade de Venda"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Data da Venda"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Valor da Venda"));

			
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			Iterable<Vendas> vendas = vr.findAll();
			for(Vendas lista:vendas) {
				tabela.addCell(String.valueOf(lista.getQuantidade_venda()));
				tabela.addCell(String.valueOf(lista.getData_venda()));
				tabela.addCell(String.valueOf(lista.getValor_venda()));				
			}
			
			documento.add(tabela);
			
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Total de Vendas Hoje"));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela2 = new PdfPTable(1);
			
			PdfPCell col4 = new PdfPCell(new Paragraph("Quantidade de Venda"));
			tabela2.addCell(col4);
			total=vr.findByDataVendido(dataAtual);			
			tabela2.addCell(String.valueOf(total));
			documento.add(tabela2);
			
			documento.close();
			
		} catch(Exception e) {
			System.out.println(e);
			documento.close();
		}
		
	}
	
	
	
	
	
}
