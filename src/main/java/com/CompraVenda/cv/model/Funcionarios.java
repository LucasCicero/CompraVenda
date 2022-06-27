package com.CompraVenda.cv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Lob;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Funcionarios implements Serializable, UserDetails{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="nome")
	private String nome;
	
	@NotEmpty
	@Column(name="cpf", unique=true)
	private String cpf;
	
	@NotEmpty
	@Column(name="senha")
	private String senha;
	
	@NotEmpty
	@Column(name="papel")
	private String papel;
	
	@OneToMany(mappedBy = "funcionarios", cascade = CascadeType.REMOVE)
	private List<Compras> compras;
	
	@OneToMany(mappedBy = "funcionarios", cascade = CascadeType.REMOVE)
	private List<Vendas> vendas;
	
	@ManyToOne
	private Role role;


	public Funcionarios() {
	
	}

	public List<Compras> getCompras() {
		return compras;
	}

	public void setCompras(List<Compras> compras) {
		this.compras = compras;
	}

	public List<Vendas> getVendas() {
		return vendas;
	}

	public void setVendas(List<Vendas> vendas) {
		this.vendas = vendas;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//return (Collection<? extends GrantedAuthority>) this.roles;
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add((new SimpleGrantedAuthority((this.role.getNome()))));
		return auths;
	}

	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.cpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
