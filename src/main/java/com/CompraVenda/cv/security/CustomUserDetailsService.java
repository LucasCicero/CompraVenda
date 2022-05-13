package com.CompraVenda.cv.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.repository.FuncionariosRepository;

@Repository
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	FuncionariosRepository fr;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Funcionarios funcionario = fr.findByCpf(cpf);
		
		if(funcionario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
                
		return funcionario;
	}
}
