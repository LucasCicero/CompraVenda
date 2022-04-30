package com.CompraVenda.cv.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CompraVenda.cv.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
	Role  findByNome(String nome);
	

}