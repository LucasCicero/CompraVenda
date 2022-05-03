package com.CompraVenda.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.CompraVenda.cv.model.Funcionarios;
import com.CompraVenda.cv.model.Role;
import com.CompraVenda.cv.repository.ClientesRepository;
import com.CompraVenda.cv.repository.FuncionariosRepository;
import com.CompraVenda.cv.repository.RoleRepository;

@SpringBootApplication
public class CvApplication {

@Autowired
private static RoleRepository rr;	

@Autowired
private static FuncionariosRepository fr;
	
	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("123"));
		/*
		Role role = rr.findByNome("ROLE_ADMIN");
		
		
		if(role == null) {
			Role role1 = new Role();
			role1.setNome("ROLE_ADMIN");
			Role role2 = new Role();
			role2.setNome("ROLE_VENDEDOR");
			Role role3 = new Role();
			role3.setNome("ROLE_COMPRADOR");
			Role role4 = new Role();
			role4.setNome("ROLE_CLIENTE");
			
			Funcionarios funcionario = fr.findByCpf("249.252.810-38");
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			funcionario.setSenha(passwordEncoder.encode("111"));
			funcionario.setRole(role1);
			
			
			
		}
		*/
	}

}
