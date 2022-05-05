package com.CompraVenda.cv.controller;

//import javax.management.relation.Role;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Role;

import com.CompraVenda.cv.repository.FuncionariosRepository;
import com.CompraVenda.cv.repository.RoleRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionariosRepository fr;
	
	@Autowired
	private RoleRepository rr;
	
	// GET que chama o form para cadastrar funcionário
	@RequestMapping("/funcionarios/cadastrarFuncionario")
	public String form() {
		return "funcionario/form-funcionario";
	}
	
	// POST que cadastra funcionários
	@RequestMapping(value = "/funcionarios/cadastrarFuncionario", method = RequestMethod.POST)
	public String form(@Valid Funcionarios funcionarios, BindingResult result, RedirectAttributes attributes,@RequestParam(value="papel")Integer papel, @RequestParam(value="senha")String senha) {
			String role_name="";
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/funcionarios/cadastrarFuncionario";
		}
		
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		funcionarios.setSenha(passwordEncoder.encode(senha));
		
		if (papel==0) {
		
		role_name="ROLE_ADMIN";
		}
		else if (papel==1) {
		role_name="ROLE_VENDEDOR";
		}
		
		else if(papel==2) {
		role_name="ROLE_COMPRADOR";
		}
		else {
		role_name="ROLE_CLIENTE";
		}
		
		Role role =rr.findByNome(role_name);
		funcionarios.setRole(role);
		fr.save(funcionarios);
		attributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
		return "redirect:/funcionarios/cadastrarFuncionario";
	}
	
	// GET que lista funcionários
	@RequestMapping("/funcionarios")
	public ModelAndView listaFuncionarios() {
		
		String cpf="";
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (auth instanceof UserDetails) {
			 cpf= ((UserDetails)auth).getUsername();
		}
		else {
			 cpf= auth.toString();
		}
		System.out.println("cpf>>"+cpf);
		
		
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
	@RequestMapping("/funcionarios/deletarFuncionario")
	public String deletarFuncionario(int id) {
		Funcionarios funcionarios = fr.findById(id);
		fr.delete(funcionarios);
		return "redirect:/funcionarios";
			
	}
	
	// Métodos que atualizam funcionário
	// GET que chama o FORM de edição do funcionário
	@RequestMapping("/funcionarios/editar-funcionario")
	public ModelAndView editarFuncionario(int id) {
		Funcionarios funcionarios = fr.findById(id);
		ModelAndView mv = new ModelAndView("funcionario/update-funcionario");
		mv.addObject("funcionario", funcionarios);
		return mv;
	}
	
	// POST que atualiza o funcionário
	@RequestMapping(value = "/funcionarios/editar-funcionario", method = RequestMethod.POST)
	public String updateFuncionario(@Valid Funcionarios funcionarios,  BindingResult result, RedirectAttributes attributes){
		fr.save(funcionarios);
		attributes.addFlashAttribute("success", "Funcionário alterado com sucesso!");
			
		int idInt = funcionarios.getId();
		String id = "" + idInt;
		return "redirect:/funcionarios/detalhes-funcionario/" + id;
	}
}

