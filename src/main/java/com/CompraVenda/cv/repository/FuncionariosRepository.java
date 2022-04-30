package com.CompraVenda.cv.repository;
/*
import java.util.List;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.repository.CrudRepository;
import com.CompraVenda.cv.model.Funcionarios;

public interface FuncionariosRepository extends CrudRepository<Funcionarios, Long>{
	
	Funcionarios findById(int id);
	Funcionarios findByCpf(String cpf);
	

	
	/*
	List<Funcionarios> findByNome(String nome);
	List<Funcionarios> findByCpf(String cpf);
	
	//Query para buscar por nome
	@Query(value = "SELECT u FROM Funcionarios u WHERE u.nome LIKE %?1%")
	List<Funcionarios> findByNomesFuncionarios(String nome);
	
	//Query para buscar por cpf
	@Query(value = "SELECT u FROM Funcionarios u WHERE u.cpf LIKE %?1%")
	List<Funcionarios> findByCpfFuncionarios(String cpf);
	*/
	
}
