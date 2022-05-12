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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CompraVenda.cv.model.Compras;
import com.CompraVenda.cv.model.Fornecedores;
import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.repository.ComprasRepository;
import com.CompraVenda.cv.repository.FornecedoresRepository;
import com.CompraVenda.cv.repository.FuncionariosRepository;
import com.CompraVenda.cv.repository.ProdutosRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComprasController {
	
	@Autowired
	private ComprasRepository cpr;
	
	@Autowired
	private FuncionariosRepository fr;
        
        @Autowired
	private ProdutosRepository pr;
        
        @Autowired
	private FornecedoresRepository fcr;
	
	// GET que chama o form para cadastrar a compra
	@RequestMapping("/compras/cadastrarCompra")
	public String form() {
		return "compra/form-compra";
	}
	
	// POST que cadastra as compras
	@RequestMapping(value = "/compras/cadastrarCompra", method = RequestMethod.POST)
	public String form(@Valid Compras compras, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/compras/cadastrarCompra";
		}

		cpr.save(compras);
		attributes.addFlashAttribute("mensagem", "Compra cadastrada com sucesso!");
		return "redirect:/compras/cadastrarCompra";
	}
	
	// GET que lista as compras
	@RequestMapping("/compras")
	public ModelAndView listaCompras() {
		ModelAndView mv = new ModelAndView("compra/lista-compra");
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
		 Iterable<Compras> compras =cpr.findByCompradorId(id);
		mv.addObject("compras", compras);
		return mv;
	}
	
	// GET que detalha as compras
	@RequestMapping("/compras/detalhes-compra/{id}")
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
	@RequestMapping("/compras/deletarCompra")
	public String deletarCompra(int id) {
		Compras compras = cpr.findById(id);
		cpr.delete(compras);
		return "redirect:/compras";
	}
	
	// Métodos que atualizam as compras
	// GET que chama o FORM de edição da compra
	@RequestMapping("/compras/editar-compra")
	public ModelAndView editarCompra(int id) {
		Compras compras = cpr.findById(id);
		ModelAndView mv = new ModelAndView("compra/update-compra");
		mv.addObject("compras", compras);
		return mv;
	}
	
	// POST que atualiza a compra
	@RequestMapping(value = "/compras/editar-compra", method = RequestMethod.POST)
	public String updateCompra(@Valid Compras compras, BindingResult result, RedirectAttributes attributes,@RequestParam(value="id_fornecedor")Integer id_fornecedor,@RequestParam(value="id_produtos")Integer id_produtos){
		String cpf="";
		
                
                Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (auth instanceof UserDetails) {
				 cpf= ((UserDetails)auth).getUsername();
			}
			else {
				 cpf= auth.toString();
			}
			
		Funcionarios funcionarios= fr.findByCpf(cpf);
                compras.setFuncionarios(funcionarios);
                Fornecedores fornecedores = fcr.findById(id_fornecedor);
		compras.setFornecedores(fornecedores);
                Produtos produtos = pr.findById(id_produtos);
		compras.setProdutos(produtos);
                
            
                cpr.save(compras);
		attributes.addFlashAttribute("success", "Compra alterada com sucesso!");
			
		int idInt = compras.getId();
		String id = "" + idInt;
		return "redirect:/compras/detalhes-compra/" + id;
	}
}

