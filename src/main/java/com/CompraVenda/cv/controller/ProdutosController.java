package com.CompraVenda.cv.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.CompraVenda.cv.model.Compras;
import com.CompraVenda.cv.model.Fornecedores;
import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Produtos;
import com.CompraVenda.cv.model.Vendas;
import com.CompraVenda.cv.repository.ClientesRepository;
import com.CompraVenda.cv.repository.ComprasRepository;
import com.CompraVenda.cv.repository.FornecedoresRepository;
import com.CompraVenda.cv.repository.FuncionariosRepository;
import com.CompraVenda.cv.repository.ProdutosRepository;
import com.CompraVenda.cv.repository.VendasRepository;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository pr;
	
	@Autowired
	private ComprasRepository cr;
	
	@Autowired
	private FornecedoresRepository fr;
	
	@Autowired
	private FuncionariosRepository fcr;
	
	@Autowired
	private VendasRepository vr;
	
	@Autowired
	private ClientesRepository clr;
	
	// GET que chama o form para cadastrar produto
	@RequestMapping("/produtos/cadastrarProduto")
	public String form() {
		return "produto/form-produto";
	}
	
	// POST que cadastra produto
	@RequestMapping(value = "/produtos/cadastrarProduto", method = RequestMethod.POST)
	public String form(@Valid Produtos produtos, BindingResult result, RedirectAttributes attributes) {		
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/produtos/cadastrarProduto";
		}

		pr.save(produtos);
		attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
		return "redirect:/produtos/cadastrarProduto";
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
	@RequestMapping("/produtos/detalhes-produto/{id}")
	public ModelAndView detalhesProduto(@PathVariable("id") int id) {
		Produtos produtos = pr.findById(id);
		ModelAndView mv = new ModelAndView("produto/detalhes-produto");
		mv.addObject("produtos", produtos);
		
		Iterable<Compras> compras = cr.findByProdutos(produtos);
		mv.addObject("compras", compras);
		
		return mv;
	}
	
	// GET que detalha os produtos
		@RequestMapping("/produtos/detalhes-produto-venda/{id}")
		public ModelAndView detalhesProdutoVenda(@PathVariable("id") int id) {
			Produtos produtos = pr.findById(id);
			ModelAndView mv = new ModelAndView("produto/detalhes-produto-venda");
			mv.addObject("produtos", produtos);
			
			Iterable<Vendas> vendas = vr.findByProdutos(produtos);
			mv.addObject("vendas", vendas);
			
			return mv;
		}
		
		
		@RequestMapping(value = "/produtos/detalhes-produto-venda/{id}", method = RequestMethod.POST)
		public String detalhesProdutosVendaPost(@PathVariable("id") int id, @Valid Vendas vendas,
				BindingResult result, RedirectAttributes attributes,@RequestParam(value="id_cliente")Integer id_cliente) {
			String cpf="";
			Integer quantidadeDisponivel,quantidadeVenda= 0;
			if (result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos");
				return "redirect:/produtos/detalhes-produto-venda/{id}";
			}

			/*
			if (cr.findByRg(candidato.getRg()) != null) {
				attributes.addFlashAttribute("mensagem_erro", "RG duplicado");
				return "redirect:/vaga/{codigo}";
			}
			*/
			
			
			Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (auth instanceof UserDetails) {
				 cpf= ((UserDetails)auth).getUsername();
			}
			else {
				 cpf= auth.toString();
			}
			
			Produtos produtos = pr.findById(id);		
			if(produtos.getLiberado_venda().equals("N") || produtos.getQuantidade_disponivel()<=0) {
				attributes.addFlashAttribute("mensagem_erro", "Produto não disponível para a venda!");
				return "redirect:/produtos/detalhes-produto-venda/{id}";							
			}
			
			else {
			Funcionarios funcionarios= fcr.findByCpf(cpf);
			vendas.setFuncionarios(funcionarios);
			vendas.setProdutos(produtos);
			Clientes clientes= clr.findById(id);
			
			quantidadeVenda= vendas.getQuantidade_venda();
			quantidadeDisponivel= produtos.getQuantidade_disponivel();
			produtos.setQuantidade_disponivel(quantidadeDisponivel-quantidadeVenda);
			vendas.setClientes(clientes);
			
			
			
			vr.save(vendas);
			attributes.addFlashAttribute("mensagem", "Venda registrada com sucesso!");
			return "redirect:/produtos/detalhes-produto-venda/{id}";
			}
		}
	
	
	
	// POST que adiciona candidato a vaga
		@RequestMapping(value = "/produtos/detalhes-produto/{id}", method = RequestMethod.POST)
		public String detalhesProdutosPost(@PathVariable("id") int id, @Valid Compras compras,
				BindingResult result, RedirectAttributes attributes,@RequestParam(value="id_fornecedor")Integer id_fornecedor) {
			String cpf="";
			Integer quantidadeDisponivel,quantidadeCompra,precoCompra =0;
			
			if (result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Verifique os campos");
				return "redirect:/produtos/detalhes-produto/{id}";
			}

			/*
			if (cr.findByRg(candidato.getRg()) != null) {
				attributes.addFlashAttribute("mensagem_erro", "RG duplicado");
				return "redirect:/vaga/{codigo}";
			}
			*/
			
			
			Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (auth instanceof UserDetails) {
				 cpf= ((UserDetails)auth).getUsername();
			}
			else {
				 cpf= auth.toString();
			}
			
			Funcionarios funcionarios= fcr.findByCpf(cpf);
			compras.setFuncionarios(funcionarios);
			Produtos produtos = pr.findById(id);
			compras.setProdutos(produtos);
			Fornecedores fornecedores= fr.findById(id);
			compras.setFornecedores(fornecedores);
			
			quantidadeCompra= compras.getQuantidade_compra();
			precoCompra= compras.getValor_compra();
			quantidadeDisponivel= produtos.getQuantidade_disponivel();
			produtos.setQuantidade_disponivel(quantidadeCompra+quantidadeDisponivel);
			produtos.setPreco_compra(precoCompra);
			cr.save(compras);
			attributes.addFlashAttribute("mensagem", "Compra registrada com sucesso!");
			return "redirect:/produtos/detalhes-produto/{id}";
		}
	
	
	
	
	//GET que deleta produto
	@RequestMapping("/produtos/deletarProduto")
	public String deletarProduto(int id) {
		Produtos produtos = pr.findById(id);
		pr.delete(produtos);
		return "redirect:/produtos";
	}
	
	// Métodos que atualizam produto
	// GET que chama o FORM de edição de produto
	@RequestMapping("/produtos/editar-produto")
	public ModelAndView editarProduto(int id) {
		Produtos produtos = pr.findById(id);
		ModelAndView mv = new ModelAndView("produto/update-produto");
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	// POST que atualiza o produto
	@RequestMapping(value = "/produtos/editar-produto", method = RequestMethod.POST)
	public String updateProduto(@Valid Produtos produtos, BindingResult result, RedirectAttributes attributes){
		pr.save(produtos);
		attributes.addFlashAttribute("success", "Produto alterado com sucesso!");
			
		int idInt = produtos.getId();
		String id = "" + idInt;
		return "redirect:/produtos/detalhes-produto/" + id;
	}
}
