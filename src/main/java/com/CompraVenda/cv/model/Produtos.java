package com.CompraVenda.cv.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Produtos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String nome_produto;
	
	@NotEmpty
	private String descricao;
	
	
	@NotNull
	private double preco_compra;
	
	@NotNull
	private double preco_venda;
	
	@NotNull
	private int quantidade_disponivel;
	
	@NotEmpty
	private String liberado_venda;
	
	
	@ManyToOne
	private Categorias categorias;
	
	
	@ManyToOne
	private Vendas vendas;
	
	
	@ManyToOne
	private Compras compras;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco_compra() {
		return preco_compra;
	}

	public void setPreco_compra(double preco_compra) {
		this.preco_compra = preco_compra;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public int getQuantidade_disponivel() {
		return quantidade_disponivel;
	}

	public void setQuantidade_disponivel(int quantidade_disponivel) {
		this.quantidade_disponivel = quantidade_disponivel;
	}

	public String getLiberado_venda() {
		return liberado_venda;
	}

	public void setLiberado_venda(String liberado_venda) {
		this.liberado_venda = liberado_venda;
	}
	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Vendas getVendas() {
		return vendas;
	}

	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}

	
	
}
