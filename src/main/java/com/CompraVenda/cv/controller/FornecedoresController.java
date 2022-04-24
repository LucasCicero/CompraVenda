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

import com.CompraVenda.cv.model.Fornecedores;
import com.CompraVenda.cv.repository.FornecedoresRepository;

@Controller
public class FornecedoresController {
	
	@Autowired
	private FornecedoresRepository fcr;
	
	// GET que chama o form para cadastrar funcionários
	@RequestMapping("/cadastrarFornecedor")
	public String form() {
	return "fornecedor/form-fornecedor";
	}
	
	// POST que cadastra fornecedor
	@RequestMapping(value = "/cadastrarFornecedor", method = RequestMethod.POST)
	public String form(@Valid Fornecedores fornecedores, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarFornecedor";
		}

		fcr.save(fornecedores);
		attributes.addFlashAttribute("mensagem", "Fornecedor cadastrado com sucesso!");
		return "redirect:/cadastrarFornecedor";
	}
	
	// GET que lista fornecedores
	@RequestMapping("/fornecedores")
	public ModelAndView listaFornecedores() {
		ModelAndView mv = new ModelAndView("fornecedor/lista-fornecedor");
		Iterable<Fornecedores> fornecedores = fcr.findAll();
		mv.addObject("fornecedores", fornecedores);
		return mv;
	}
	
	// GET que traz detalhes dos fornecedores
	@RequestMapping("/detalhes-fornecedor/{id}")
	public ModelAndView detalhesFornecedor(@PathVariable("id") int id) {
		Fornecedores fornecedores = fcr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/detalhes-fornecedor");
		mv.addObject("fornecedores", fornecedores);

		// lista de dependentes baseada no id do funcionário
		//Iterable<Dependente> dependentes = dr.findByFuncionario(funcionario);
		//mv.addObject("dependentes", dependentes);

		return mv;
	}
	
	//GET que deleta fornecedor
	@RequestMapping("/deletarFornecedor")
	public String deletarFornecedor(int id) {
		Fornecedores fornecedores = fcr.findById(id);
		fcr.delete(fornecedores);
		return "redirect:/fornecedores";	
	}
	
	// Métodos que atualizam fornecedores
	// GET que chama o FORM de edição do fornecedor
	@RequestMapping("/editar-fornecedor")
	public ModelAndView editarFornecedor(int id) {
		Fornecedores fornecedores = fcr.findById(id);
		ModelAndView mv = new ModelAndView("fornecedor/update-fornecedor");
		mv.addObject("fornecedor", fornecedores);
		return mv;
	}
	
	// POST que atualiza o funcionário
	@RequestMapping(value = "/editar-fornecedor", method = RequestMethod.POST)
	public String updateFuncionario(@Valid Fornecedores fornecedores, BindingResult result, RedirectAttributes attributes){
			
		fcr.save(fornecedores);
		attributes.addFlashAttribute("success", "Fornecedor alterado com sucesso!");
			
		int idInt = fornecedores.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-fornecedor/" + id;	
	}
}
