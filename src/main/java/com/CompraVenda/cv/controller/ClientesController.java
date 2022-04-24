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

import com.CompraVenda.cv.model.Clientes;
import com.CompraVenda.cv.repository.ClientesRepository;

@Controller
public class ClientesController {
	
	@Autowired
	private ClientesRepository clr;
	
	// GET que chama o form para cadastrar cliente
	@RequestMapping("/cadastrarCliente")
	public String form() {
		return "cliente/form-cliente";
	}
	
	// POST que cadastra clientes
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(@Valid Clientes clientes, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarCliente";
		}

		clr.save(clientes);
		attributes.addFlashAttribute("mensagem", "Clientes cadastrado com sucesso!");
		return "redirect:/cadastrarCliente";
	}
	
	// GET que lista os clientes
	@RequestMapping("/clientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("lista-cliente");
		//Iterable<Clientes> clientes = clr.findAll();
		//mv.addObject("clientes", clientes);
		return mv;
	}
	
	// GET que detalha os clientes
	@RequestMapping("/detalhes-cliente/{id}")
	public ModelAndView detalhesCliente(@PathVariable("id") int id) {
		Clientes clientes = clr.findById(id);
		ModelAndView mv = new ModelAndView("cliente/detalhes-cliente");
		mv.addObject("clientes", clientes);

		// lista de dependentes baseada no id do funcionário
		//Iterable<Dependente> dependentes = dr.findByFuncionario(funcionario);
		//mv.addObject("dependentes", dependentes);

		return mv;
	}
	
	//GET que deleta clientes
	@RequestMapping("/deletarCliente")
	public String deletarCliente(int id) {
		Clientes clientes = clr.findById(id);
		clr.delete(clientes);
		return "redirect:/clientes";
	}
	
	// Métodos que atualizam cliente
	// GET que chama o FORM de edição do cliente
	@RequestMapping("/editar-cliente")
	public ModelAndView editarCliente(int id) {
		Clientes clientes = clr.findById(id);
		ModelAndView mv = new ModelAndView("cliente/update-cliente");
		mv.addObject("cliente", clientes);
		return mv;
	}
	
	// POST que atualiza o cliente
	@RequestMapping(value = "/editar-cliente", method = RequestMethod.POST)
	public String updateCLiente(@Valid Clientes clientes, BindingResult result, RedirectAttributes attributes){
		clr.save(clientes);
		attributes.addFlashAttribute("success", "Cliente alterado com sucesso!");
			
		int idInt = clientes.getId();
		String id = "" + idInt;
		return "redirect:/detalhes-cliente/" + id;
	}
}
