package com.CompraVenda.cv.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Compras implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private int quantidade_compra;
	
	@NotEmpty
	private Date data_compra;
	
	@NotEmpty
	private int valor_compra;
	
	@ManyToOne
	private Fornecedores fornecedores;
	
	@NotEmpty
	@ManyToOne
	private Produtos produtos;
	
	@NotEmpty
	@ManyToOne
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

	public Date getData_compra() {
		return data_compra;
	}

	public void setData_compra(Date data_compra) {
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
