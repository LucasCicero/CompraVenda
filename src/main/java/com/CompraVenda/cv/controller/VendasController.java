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

import com.CompraVenda.cv.model.Clientes;
import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;
import com.CompraVenda.cv.repository.ClientesRepository;
import com.CompraVenda.cv.repository.FuncionariosRepository;
import com.CompraVenda.cv.repository.ProdutosRepository;
import com.CompraVenda.cv.repository.VendasRepository;

@Controller
public class VendasController {
	
	@Autowired
	private VendasRepository vr;
        
    @Autowired
	private ClientesRepository cr;
                
    @Autowired
	private FuncionariosRepository fcr;
        
    @Autowired
	private ProdutosRepository pr;
	
	// GET que chama o form para cadastrar venda
	@RequestMapping("/vendas/cadastrarVenda")
	public String form() {
		return "venda/form-venda";
	}
	
	// POST que cadastra as vendas
	@RequestMapping(value = "/vendas/cadastrarVenda", method = RequestMethod.POST)
	public String form(@Valid Vendas vendas, BindingResult result, RedirectAttributes attributes,@RequestParam(value="id_cliente")Integer id_cliente,@RequestParam(value="id_produtos")Integer id_produtos) {
        String cpf="";
            
        Integer quantidadeDisponivel,quantidadeVenda= 0;
            
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/vendas/cadastrarVenda";
		}
                		 
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (auth instanceof UserDetails) {
			cpf= ((UserDetails)auth).getUsername();
		}
		else {
			cpf= auth.toString();
		}
                        
        Produtos produtos = pr.findById(id_produtos);		
		if(produtos.getLiberado_venda().equals("N") || produtos.getQuantidade_disponivel()<=0) {
			attributes.addFlashAttribute("mensagem_erro", "Produto não disponível para a venda!");
			return "redirect:/produtos/detalhes-produto-venda/{id}";							
		}
		else{
			Funcionarios funcionarios= fcr.findByCpf(cpf);
            vendas.setFuncionarios(funcionarios);
			Clientes clientes = cr.findById(id_cliente);
			vendas.setClientes(clientes);
			vendas.setProdutos(produtos);
			
			quantidadeVenda= vendas.getQuantidade_venda();
			quantidadeDisponivel= produtos.getQuantidade_disponivel();
			produtos.setQuantidade_disponivel(quantidadeDisponivel-quantidadeVenda);
                
			vr.save(vendas);
			attributes.addFlashAttribute("mensagem", "Venda cadastrada com sucesso!");
			return "redirect:/vendas/cadastrarVenda";
        }
	}
	
	// GET que lista as vendas
	@RequestMapping("/vendas")
	public ModelAndView listaVendas() {
		ModelAndView mv = new ModelAndView("venda/lista-venda");
		
		String cpf="";

		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (auth instanceof UserDetails) {
			 cpf= ((UserDetails)auth).getUsername();
		}
		else {
			 cpf= auth.toString();
		}
		
		Funcionarios funcionario = fcr.findByCpf(cpf);
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
	public String updateVenda(@Valid Vendas vendas, BindingResult result, RedirectAttributes attributes,@RequestParam(value="id_cliente")Integer id_cliente,@RequestParam(value="id_produtos")Integer id_produtos){
		
        String cpf="";
		 
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		if (auth instanceof UserDetails) {
			 cpf= ((UserDetails)auth).getUsername();
		}
		else {
			 cpf= auth.toString();
		}
			
		Funcionarios funcionarios= fcr.findByCpf(cpf);
        vendas.setFuncionarios(funcionarios);
		Clientes clientes = cr.findById(id_cliente);
		vendas.setClientes(clientes);
        Produtos produtos = pr.findById(id_produtos);
		vendas.setProdutos(produtos);           
		vr.save(vendas);              
                
		attributes.addFlashAttribute("success", "Venda alterada com sucesso!");
			
		int idInt = vendas.getId();
		String id = "" + idInt;
		return "redirect:/vendas/detalhes-venda/" + id;
	}
}
