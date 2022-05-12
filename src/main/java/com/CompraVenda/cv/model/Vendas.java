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

@Entity
public class Vendas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="quantidade_venda")
	private int quantidade_venda;
	
	@NotEmpty
	@Column(name="data_venda")
	private String data_venda;
	
	@NotNull
	@Column(name="valor_venda")
	private double valor_venda;
	

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clientes clientes;
	

	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produtos produtos;
	
	
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionarios funcionarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
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

	public int getQuantidade_venda() {
		return quantidade_venda;
	}

	public void setQuantidade_venda(int quantidade_venda) {
		this.quantidade_venda = quantidade_venda;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}
	
}
