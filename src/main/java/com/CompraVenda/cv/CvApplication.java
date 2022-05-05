package com.CompraVenda.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class CvApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("111"));
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
