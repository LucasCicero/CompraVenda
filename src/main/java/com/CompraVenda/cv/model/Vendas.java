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
public class Vendas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private int quantidade_venda;
	
	@NotEmpty
	private Date data_venda;
	
	@NotEmpty
	private double valor_venda;
	
	@NotEmpty
	@ManyToOne
	private Clientes clientes;
	
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

	public int getQuantidade_venda() {
		return quantidade_venda;
	}

	public void setQuantidade_venda(int quantidade_venda) {
		this.quantidade_venda = quantidade_venda;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}
	
}
