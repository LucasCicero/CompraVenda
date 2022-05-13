package com.CompraVenda.cv.repository;
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Funcionarios;

public interface FuncionariosRepository extends CrudRepository<Funcionarios, Long>{
	
	Funcionarios findById(int id);
	Funcionarios findByCpf(String cpf);
	
}
