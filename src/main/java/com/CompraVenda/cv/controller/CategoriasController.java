package com.CompraVenda.cv.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CompraVenda.cv.model.Categorias;
import com.CompraVenda.cv.model.Clientes;
import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;
import com.CompraVenda.cv.repository.CategoriasRepository;
import com.CompraVenda.cv.repository.ProdutosRepository;

@Controller
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository cr;
	
	@Autowired
	private ProdutosRepository pr;
	
	// GET que chama o form para cadastrar categoria
	@RequestMapping("/cadastrarCategoria")
	public String form() {
		return "categoria/form-categoria";
	}
	
	// POST que cadastra uma categoria
	@RequestMapping(value = "/cadastrarCategoria", method = RequestMethod.POST)
	public String form(@Valid Categorias categorias, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCategoria";
		}
		
		
		cr.save(categorias);
		attributes.addFlashAttribute("mensagem", "Categoria cadastrada com sucesso!");
		return "redirect:/cadastrarCategoria";
	}
	
	// GET que lista categorias
	@RequestMapping("/categorias")
	public ModelAndView listaCategorias() {
		ModelAndView mv = new ModelAndView("categoria/lista-categoria");
		Iterable<Categorias> categorias = cr.findAll();
		mv.addObject("categorias", categorias);
		return mv;
	}
	
	// GET que detalha as categorias
	@RequestMapping("/detalhes-categoria/{id}")
	public ModelAndView detalhesCategoria(@PathVariable("id") int id) {
		Categorias categorias = cr.findById(id);
		ModelAndView mv = new ModelAndView("categoria/detalhes-categoria");
		mv.addObject("categorias", categorias);

		Iterable<Produtos> produtos = pr.findByCategorias(categorias);
		mv.addObject("produtos", produtos);

		return mv;
	}
	
	@RequestMapping(value = "/detalhes-categoria/{id}", method = RequestMethod.POST)
	public String detalhesCategoriaPost(@PathVariable("id") int id, @Valid Produtos produtos,
			BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/detalhes-categoria/{id}";
		}
		

		/*
		if (cr.findByRg(candidato.getRg()) != null) {
			attributes.addFlashAttribute("mensagem_erro", "RG duplicado");
			return "redirect:/vaga/{codigo}";
		}
		*/		

		Categorias categorias= cr.findById(id);
		produtos.setCategorias(categorias);
		pr.save(produtos);
		attributes.addFlashAttribute("mensagem", "Venda registrada com sucesso!");
		return "redirect:/detalhes-categoria/{id}";
	}


	//GET que deleta categoria
	@RequestMapping("/deletarCategoria")
	public String deletarCategoria(int id) {
		Categorias categorias = cr.findById(id);
		cr.delete(categorias);
		return "redirect:/categorias";
	}
	
	// Métodos que atualizam categoria
	// GET que chama o FORM de edição da categoria
	@RequestMapping("/editar-categoria")
	public ModelAndView editarCategoria(int id) {
		Categorias categorias = cr.findById(id);
		ModelAndView mv = new ModelAndView("categoria/update-categoria");
		mv.addObject("categorias", categorias);
		return mv;
	}
	
	// POST que atualiza o categoria
	@RequestMapping(value = "/editar-categoria", method = RequestMethod.POST)
	public String updateCategoria(@Valid Categorias categorias, BindingResult result, RedirectAttributes attributes){
		cr.save(categorias);
		attributes.addFlashAttribute("success", "Categoria alterada com sucesso!");
			
		int idInt = categorias.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-categoria/" + id;
	}
}
