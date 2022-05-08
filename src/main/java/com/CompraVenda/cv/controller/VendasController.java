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

import com.CompraVenda.cv.model.Compras;
import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;
import com.CompraVenda.cv.repository.FuncionariosRepository;
import com.CompraVenda.cv.repository.VendasRepository;

@Controller
public class VendasController {
	
	@Autowired
	private VendasRepository vr;
	
	@Autowired
	private FuncionariosRepository fr;
	
	// GET que chama o form para cadastrar venda
	@RequestMapping("/vendas/cadastrarVenda")
	public String form() {
		return "venda/form-venda";
	}
	
	// POST que cadastra as vendas
	@RequestMapping(value = "/vendas/cadastrarVenda", method = RequestMethod.POST)
	public String form(@Valid Vendas vendas, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/vendas/cadastrarVendas";
		}

		vr.save(vendas);
		attributes.addFlashAttribute("mensagem", "Venda cadastrada com sucesso!");
		return "redirect:/vendas/cadastrarVenda";
	}
	
	// GET que lista as vendas
	@RequestMapping("/vendas")
	public ModelAndView listaVendas() {
		ModelAndView mv = new ModelAndView("venda/lista-venda");
		String cpf="";
		//Iterable<Compras> compras = cpr.findAll();
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (auth instanceof UserDetails) {
			 cpf= ((UserDetails)auth).getUsername();
		}
		else {
			 cpf= auth.toString();
		}
		
		Funcionarios funcionario = fr.findByCpf(cpf);
		Integer id= funcionario.getId();
		 Iterable<Vendas> vendas = vr.findByVendedorId(id);
		mv.addObject("vendas", vendas);
		return mv;
	}
	
	// GET que detalha as vendas
	@RequestMapping("/vendas/detalhes-venda/{id}")
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
	@RequestMapping("/vendas/deletarVenda")
	public String deletarVenda(int id) {
		Vendas vendas = vr.findById(id);
		vr.delete(vendas);
		return "redirect:/vendas";		
	}
	
	// Métodos que atualizam as vendas
	// GET que chama o FORM de edição das vendas
	@RequestMapping("/vendas/editar-venda")
	public ModelAndView editarVenda(int id) {
		Vendas vendas = vr.findById(id);
		ModelAndView mv = new ModelAndView("venda/update-venda");
		mv.addObject("vendas", vendas);
		return mv;
	}
	
	// POST que atualiza as vendas
	@RequestMapping(value = "/vendas/editar-venda", method = RequestMethod.POST)
	public String updateVenda(@Valid Vendas vendas, BindingResult result, RedirectAttributes attributes,@RequestParam(value="quantidade_venda")Integer quantidade_venda){
		/*
		Integer nova_quantidade=0;
		if (quantidade_venda != vendas.getQuantidade_venda()) {
			Produtos produtos = vendas.getProdutos();
			nova_quantidade= quantidade_venda-vendas.getQuantidade_venda();
			if (nova_quantidade<0) {
				nova_quantidade=nova_quantidade*-1;
			}
			
			produtos.setQuantidade_disponivel(produtos.getQuantidade_disponivel()-nova_quantidade);
		}
		*/
		
		vr.save(vendas);
		attributes.addFlashAttribute("success", "Venda alterada com sucesso!");
			
		int idInt = vendas.getId();
		String id = "" + idInt;
		return "redirect:/vendas/detalhes-venda/" + id;
	}
}
