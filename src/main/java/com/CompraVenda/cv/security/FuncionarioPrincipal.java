/*
package com.CompraVenda.cv.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.CompraVenda.cv.model.Funcionarios;

public class FuncionarioPrincipal implements UserDetails {
	
	private String cpf;
	private String password;
	
	
	public FuncionarioPrincipal(Funcionarios funcionario) {
		this.cpf=funcionario.getCpf();
		this.password=funcionario.getSenha();
	}
	
	public static FuncionarioPrincipal create(Funcionarios funcionario) {
		return new FuncionarioPrincipal(funcionario);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cpf;
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
*/