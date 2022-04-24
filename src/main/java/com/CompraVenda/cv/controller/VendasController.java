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

import com.CompraVenda.cv.model.Vendas;
import com.CompraVenda.cv.repository.VendasRepository;

@Controller
public class VendasController {
	
	@Autowired
	private VendasRepository vr;
	
	// GET que chama o form para cadastrar venda
	@RequestMapping("/cadastrarVenda")
	public String form() {
		return "venda/form-venda";
	}
	
	// POST que cadastra as vendas
	@RequestMapping(value = "/cadastrarVenda", method = RequestMethod.POST)
	public String form(@Valid Vendas vendas, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarVendas";
		}

		vr.save(vendas);
		attributes.addFlashAttribute("mensagem", "Venda cadastrada com sucesso!");
		return "redirect:/cadastrarVenda";
	}
	
	// GET que lista as vendas
	@RequestMapping("/vendas")
	public ModelAndView listaVendas() {
		ModelAndView mv = new ModelAndView("venda/lista-venda");
		Iterable<Vendas> vendas = vr.findAll();
		mv.addObject("vendas", vendas);
		return mv;
	}
	
	// GET que detalha as vendas
	@RequestMapping("/detalhes-venda/{id}")
	public ModelAndView detalhesVenda(@PathVariable("id") int id) {
		Vendas vendas = vr.findById(id);
		ModelAndView mv = new ModelAndView("venda/detalhes-venda");
		mv.addObject("vendas", vendas);
		
		// lista de dependentes baseada no id do funcionário
		//Iterable<Dependente> dependentes = dr.findByFuncionario(funcionario);
		//mv.addObject("dependentes", dependentes);

		return mv;
	}
	
	//GET que deleta uma venda
	@RequestMapping("/deletarVenda")
	public String deletarVenda(int id) {
		Vendas vendas = vr.findById(id);
		vr.delete(vendas);
		return "redirect:/vendas";		
	}
	
	// Métodos que atualizam as vendas
	// GET que chama o FORM de edição das vendas
	@RequestMapping("/editar-venda")
	public ModelAndView editarVenda(int id) {
		Vendas vendas = vr.findById(id);
		ModelAndView mv = new ModelAndView("venda/update-venda");
		mv.addObject("venda", vendas);
		return mv;
	}
	
	// POST que atualiza as vendas
	@RequestMapping(value = "/editar-venda", method = RequestMethod.POST)
	public String updateVenda(@Valid Vendas vendas, BindingResult result, RedirectAttributes attributes){
		vr.save(vendas);
		attributes.addFlashAttribute("success", "Venda alterada com sucesso!");
			
		int idInt = vendas.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-venda/" + id;
	}
}
