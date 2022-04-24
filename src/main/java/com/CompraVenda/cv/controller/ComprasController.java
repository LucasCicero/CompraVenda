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

import com.CompraVenda.cv.model.Compras;
import com.CompraVenda.cv.repository.ComprasRepository;

@Controller
public class ComprasController {
	
	@Autowired
	private ComprasRepository cpr;
	
	// GET que chama o form para cadastrar a compra
	@RequestMapping("/cadastrarCompra")
	public String form() {
		return "compra/form-compra";
	}
	
	// POST que cadastra as compras
	@RequestMapping(value = "/cadastrarCompra", method = RequestMethod.POST)
	public String form(@Valid Compras compras, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCompra";
		}

		cpr.save(compras);
		attributes.addFlashAttribute("mensagem", "Compra cadastrada com sucesso!");
		return "redirect:/cadastrarCompra";
	}
	
	// GET que lista as compras
	@RequestMapping("/compras")
	public ModelAndView listaCompras() {
		ModelAndView mv = new ModelAndView("compra/lista-compra");
		Iterable<Compras> compras = cpr.findAll();
		mv.addObject("compras", compras);
		return mv;
	}
	
	// GET que detalha as compras
	@RequestMapping("/detalhes-compra/{id}")
	public ModelAndView detalhesCompra(@PathVariable("id") int id) {
		Compras compras = cpr.findById(id);
		ModelAndView mv = new ModelAndView("compra/detalhes-compra");
		mv.addObject("compras", compras);

		// lista de dependentes baseada no id do funcionário
		//Iterable<Dependente> dependentes = dr.findByFuncionario(funcionario);
		//mv.addObject("dependentes", dependentes);

		return mv;
	}
	
	//GET que deleta uma compra
	@RequestMapping("/deletarCompra")
	public String deletarCompra(int id) {
		Compras compras = cpr.findById(id);
		cpr.delete(compras);
		return "redirect:/compras";
	}
	
	// Métodos que atualizam as compras
	// GET que chama o FORM de edição da compra
	@RequestMapping("/editar-compra")
	public ModelAndView editarCompra(int id) {
		Compras compras = cpr.findById(id);
		ModelAndView mv = new ModelAndView("compra/update-compra");
		mv.addObject("compra", compras);
		return mv;
	}
	
	// POST que atualiza a compra
	@RequestMapping(value = "/editar-compra", method = RequestMethod.POST)
	public String updateCompra(@Valid Compras compras, BindingResult result, RedirectAttributes attributes){
		cpr.save(compras);
		attributes.addFlashAttribute("success", "Compra alterada com sucesso!");
			
		int idInt = compras.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-compra/" + id;
	}
}

