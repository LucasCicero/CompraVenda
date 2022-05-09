package com.CompraVenda.cv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;

@Entity
public class Compras implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="quantidade_compra")
	private int quantidade_compra;
	
	@NotEmpty
	@Column(name="data_compra")
	private String data_compra;
	
	@NotNull
	@Column(name="valor_compra")
	private int valor_compra;
	
	@ManyToOne
	@JoinColumn(name="id_fornecedor", updatable=false)
	private Fornecedores fornecedores;
	
	
	@ManyToOne
	@JoinColumn(name="id_produto", updatable=false)
	private Produtos produtos;
	
	
	@ManyToOne
	@JoinColumn(name="id_funcionario", updatable=false)
	private Funcionarios funcionarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade_compra() {
		return quantidade_compra;
	}

	public void setQuantidade_compra(int quantidade_compra) {
		this.quantidade_compra = quantidade_compra;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public int getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(int valor_compra) {
		this.valor_compra = valor_compra;
	}
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Funcionarios getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}

}
