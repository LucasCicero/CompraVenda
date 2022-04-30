package com.CompraVenda.cv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	//@ManyToMany
	@OneToMany
	private List<Funcionarios> funcionarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
	

}
