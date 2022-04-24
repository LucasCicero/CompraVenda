package com.CompraVenda.cv.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.repository.ProdutosRepository;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository pr;
	
	// GET que chama o form para cadastrar produto
	@RequestMapping("/cadastrarProduto")
	public String form() {
		return "produto/form-produto";
	}
	
	// POST que cadastra produto
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
	public String form(@Valid Produtos produtos, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarProduto";
		}

		pr.save(produtos);
		attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
		return "redirect:/cadastrarProduto";
	}
	
	// GET que lista produtos
	@RequestMapping("/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("produto/lista-produto");
		Iterable<Produtos> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	// GET que detalha os produtos
	@RequestMapping("/detalhes-produto/{id}")
	public ModelAndView detalhesProduto(@PathVariable("id") int id) {
		Produtos produtos = pr.findById(id);
		ModelAndView mv = new ModelAndView("produto/detalhes-produto");
		mv.addObject("produtos", produtos);

		// lista de dependentes baseada no id do funcionário
		//Iterable<Dependente> dependentes = dr.findByFuncionario(funcionario);
		//mv.addObject("dependentes", dependentes);

		return mv;
	}
	
	//GET que deleta produto
	@RequestMapping("/deletarProduto")
	public String deletarFuncionario(int id) {
		Produtos produtos = pr.findById(id);
		pr.delete(produtos);
		return "redirect:/produtos";
	}
	
	// Métodos que atualizam produto
	// GET que chama o FORM de edição de produto
	@RequestMapping("/editar-produto")
	public ModelAndView editarProduto(int id) {
		Produtos produtos = pr.findById(id);
		ModelAndView mv = new ModelAndView("produto/update-produto");
		mv.addObject("produto", produtos);
		return mv;
	}
	
	// POST que atualiza o produto
	@RequestMapping(value = "/editar-produto", method = RequestMethod.POST)
	public String updateProduto(@Valid Produtos produtos, BindingResult result, RedirectAttributes attributes){
		pr.save(produtos);
		attributes.addFlashAttribute("success", "Produto alterado com sucesso!");
			
		int idInt = produtos.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-produto/" + id;
	}
}
