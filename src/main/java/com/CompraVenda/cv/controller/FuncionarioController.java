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

import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.repository.FuncionariosRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionariosRepository fr;
	
	// GET que chama o form para cadastrar funcionário
	@RequestMapping("/cadastrarFuncionario")
	public String form() {
		return "funcionario/form-funcionario";
	}
	
	// POST que cadastra funcionários
	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
	public String form(@Valid Funcionarios funcionarios, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarFuncionario";
		}

		fr.save(funcionarios);
		attributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
		return "redirect:/cadastrarFuncionario";
	}
	
	// GET que lista funcionários
	@RequestMapping("/funcionarios")
	public ModelAndView listaFuncionarios() {
		ModelAndView mv = new ModelAndView("funcionario/lista-funcionario");
		Iterable<Funcionarios> funcionarios = fr.findAll();
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}
	
	// GET que detalha os funcionários
	@RequestMapping("/detalhes-funcionario/{id}")
	public ModelAndView detalhesFuncionario(@PathVariable("id") int id) {
		Funcionarios funcionarios = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/detalhes-funcionario");
		mv.addObject("funcionarios", funcionarios);

		// lista de dependentes baseada no id do funcionário
		//Iterable<Dependente> dependentes = dr.findByFuncionario(funcionario);
		//mv.addObject("dependentes", dependentes);

		return mv;
	}
	
	//GET que deleta funcionário
	@RequestMapping("/deletarFuncionario")
	public String deletarFuncionario(int id) {
		Funcionarios funcionarios = fr.findById(id);
		fr.delete(funcionarios);
		return "redirect:/funcionarios";
			
	}
	
	// Métodos que atualizam funcionário
	// GET que chama o FORM de edição do funcionário
	@RequestMapping("/editar-funcionario")
	public ModelAndView editarFuncionario(int id) {
		Funcionarios funcionarios = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/update-funcionario");
		mv.addObject("funcionario", funcionarios);
		return mv;
	}
	
	// POST que atualiza o funcionário
	@RequestMapping(value = "/editar-funcionario", method = RequestMethod.POST)
	public String updateFuncionario(@Valid Funcionarios funcionarios,  BindingResult result, RedirectAttributes attributes){
		fr.save(funcionarios);
		attributes.addFlashAttribute("success", "Funcionário alterado com sucesso!");
			
		int idInt = funcionarios.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-funcionario/" + id;
	}
}

